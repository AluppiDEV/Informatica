package Java.Gestione_aeroportuale;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
    private List<Velivolo> voliInArrivo;
    private List<Velivolo> voliATerra;
    private List<Infrastruttura> infrastrutture;
    private List<Pilota> piloti;
    private List<TecnicoManutentore> tecnici;
    private GestoreMeteo gestoreMeteo;
    private int ora;
    private int minuti;

    public Aeroporto() {
        this.voliInArrivo = new ArrayList<>();
        this.voliATerra = new ArrayList<>();
        this.infrastrutture = new ArrayList<>();
        this.piloti = new ArrayList<>();
        this.tecnici = new ArrayList<>();
        this.gestoreMeteo = new GestoreMeteo();
        this.ora = 10;
        this.minuti = 0;
    }

    public void aggiungiVelivoloInArrivo(Velivolo velivolo) {
        velivolo.setInVolo(true);
        voliInArrivo.add(velivolo);
    }

    public void aggiungiInfrastruttura(Infrastruttura infrastruttura) {
        infrastrutture.add(infrastruttura);
    }

    public void aggiungiPilota(Pilota pilota) {
        piloti.add(pilota);
    }

    public void aggiungiTecnico(TecnicoManutentore tecnico) {
        tecnici.add(tecnico);
    }

    public String simulaTurno() {
        StringBuilder output = new StringBuilder();

        minuti += 10;
        if (minuti >= 60) {
            minuti = 0;
            ora++;
        }

        gestoreMeteo.aggiornaMeteo();
        CondMeteo meteo = gestoreMeteo.getCondizioneCorrente();

        output.append("--- ORA: ").append(ora).append(":").append(String.format("%02d", minuti))
                .append(" | METEO: ").append(meteo).append(" ---\n");

        int pisteLibere = contaPisteLibere();
        output.append("> Voli in arrivo: ").append(voliInArrivo.size())
                .append(" | Piste Libere: ").append(pisteLibere).append("\n");

        output.append(gestisciAtterraggi(meteo));
        output.append(gestisciManutenzioni());
        output.append(gestisciDecolli(meteo));

        output.append("\n");

        return output.toString();
    }

    private String gestisciAtterraggi(CondMeteo meteo) {
        StringBuilder output = new StringBuilder();

        if (meteo == CondMeteo.NEBBIA) {
            output.append("[BLOCCO] Nebbia: nessun atterraggio consentito.\n");
            return output.toString();
        }

        List<Velivolo> atterrati = new ArrayList<>();

        for (Velivolo velivolo : voliInArrivo) {
            if (velivolo.getCarburante() < 10.0) {
                output.append("[ALLARME] Aereo ").append(velivolo.getId())
                        .append(" (Carburante ").append(String.format("%.0f", velivolo.getCarburante()))
                        .append("%) richiede atterraggio immediato!\n");
            }

            if (meteo == CondMeteo.VENTO_FORTE && velivolo instanceof Aliante) {
                output.append("[ERRORE] Aliante ").append(velivolo.getId())
                        .append(" non può atterrare: Vento Forte.\n");
                continue;
            }

            Infrastruttura infrastrutturaLibera = trovaInfrastrutturaLibera(velivolo);
            if (infrastrutturaLibera != null) {
                if (velivolo.atterra(infrastrutturaLibera)) {
                    output.append("[OK] Aereo ").append(velivolo.getId())
                            .append(" assegnato a ").append(infrastrutturaLibera.getId()).append(".\n");
                    if (meteo == CondMeteo.PIOGGIA) {
                        velivolo.consumaCarburante(20.0);
                    }
                    atterrati.add(velivolo);
                    voliATerra.add(velivolo);
                }
            } else {
                output.append("[ERRORE] Nessuna infrastruttura disponibile per ")
                        .append(velivolo.getId()).append(". Resta in volo.\n");
            }

            velivolo.muoviti();
        }

        voliInArrivo.removeAll(atterrati);

        return output.toString();
    }

    private String gestisciManutenzioni() {
        StringBuilder output = new StringBuilder();

        for (Infrastruttura infrastruttura : infrastrutture) {
            if (infrastruttura instanceof HangarRiparazioni && infrastruttura.isOccupato()) {
                HangarRiparazioni hangar = (HangarRiparazioni) infrastruttura;
                Velivolo velivolo = hangar.getVelivoloCorrente();

                TecnicoManutentore tecnicoLibero = trovaTecnicoLibero();
                if (tecnicoLibero != null) {
                    tecnicoLibero.setOccupato(true);
                    output.append("[MANUTENZIONE] Tecnico ").append(tecnicoLibero.getNome())
                            .append(" sta riparando ").append(velivolo.getId())
                            .append(" (Turno ").append(4 - hangar.getTurniRimanenti()).append("/3).\n");

                    if (hangar.avanzaRiparazione()) {
                        output.append("[COMPLETATO] Riparazione di ").append(velivolo.getId())
                                .append(" completata.\n");
                        hangar.libera();
                        tecnicoLibero.setOccupato(false);
                    }
                }
            }
        }

        List<Velivolo> daSpostareInHangar = new ArrayList<>();
        for (Velivolo velivolo : voliATerra) {
            if (!velivolo.isOperativo()) {
                HangarRiparazioni hangarLibero = trovaHangarLibero();
                if (hangarLibero != null) {
                    hangarLibero.iniziaRiparazione(velivolo);
                    output.append("[ALLARME] ").append(velivolo.getId())
                            .append(" NON OPERATIVO (Integrità ")
                            .append(String.format("%.0f", velivolo.getIntegrita()))
                            .append("%). Spostato in ").append(hangarLibero.getId()).append(".\n");
                    daSpostareInHangar.add(velivolo);
                }
            }
        }
        voliATerra.removeAll(daSpostareInHangar);

        return output.toString();
    }

    private String gestisciDecolli(CondMeteo meteo) {
        StringBuilder output = new StringBuilder();

        if (meteo == CondMeteo.NEBBIA) {
            output.append("[BLOCCO] Nebbia: nessun decollo consentito.\n");
            return output.toString();
        }

        List<Velivolo> decollati = new ArrayList<>();
        for (Velivolo velivolo : voliATerra) {
            Pilota pilotaAbilitato = trovaPilotaAbilitato(velivolo.getModello());

            if (pilotaAbilitato == null) {
                output.append("[ERRORE] Volo ").append(velivolo.getId())
                        .append(" non può decollare: Nessun Pilota abilitato per '")
                        .append(velivolo.getModello()).append("' disponibile.\n");
                continue;
            }

            if (velivolo.getCarburante() < 100.0) {
                output.append("[ERRORE] Volo ").append(velivolo.getId())
                        .append(" non può decollare: Carburante insufficiente (")
                        .append(String.format("%.0f", velivolo.getCarburante())).append("%).\n");
                continue;
            }

            if (velivolo.decolla(pilotaAbilitato)) {
                output.append("[DECOLLO] Aereo ").append(velivolo.getId())
                        .append(" decollato con pilota ").append(pilotaAbilitato.getNome()).append(".\n");
                decollati.add(velivolo);
                liberaInfrastruttura(velivolo);
            }
        }

        voliATerra.removeAll(decollati);

        return output.toString();
    }

    private Infrastruttura trovaInfrastrutturaLibera(Velivolo velivolo) {
        for (Infrastruttura infrastruttura : infrastrutture) {
            if (!infrastruttura.isOccupato()) {
                if (velivolo instanceof AereoDiLinea && infrastruttura instanceof Pista) {
                    Pista pista = (Pista) infrastruttura;
                    if (pista.getLunghezza() >= 2000) {
                        return pista;
                    }
                } else if (velivolo instanceof Elicottero && (infrastruttura instanceof Pista || infrastruttura instanceof PiazzolaSosta)) {
                    return infrastruttura;
                } else if (infrastruttura instanceof Pista && !(infrastruttura instanceof HangarRiparazioni)) {
                    return infrastruttura;
                }
            }
        }
        return null;
    }

    private void liberaInfrastruttura(Velivolo velivolo) {
        for (Infrastruttura infrastruttura : infrastrutture) {
            if (infrastruttura.getVelivoloCorrente() == velivolo) {
                infrastruttura.libera();
                break;
            }
        }
    }

    private Pilota trovaPilotaAbilitato(String modello) {
        for (Pilota pilota : piloti) {
            if (pilota.isAbilitatoPer(modello) && !pilota.isOccupato()) {
                return pilota;
            }
        }
        return null;
    }

    private TecnicoManutentore trovaTecnicoLibero() {
        for (TecnicoManutentore tecnico : tecnici) {
            if (!tecnico.isOccupato()) {
                return tecnico;
            }
        }
        return null;
    }

    private HangarRiparazioni trovaHangarLibero() {
        for (Infrastruttura infrastruttura : infrastrutture) {
            if (infrastruttura instanceof HangarRiparazioni && !infrastruttura.isOccupato()) {
                return (HangarRiparazioni) infrastruttura;
            }
        }
        return null;
    }

    private int contaPisteLibere() {
        int count = 0;
        for (Infrastruttura infrastruttura : infrastrutture) {
            if (infrastruttura instanceof Pista && !infrastruttura.isOccupato()) {
                count++;
            }
        }
        return count;
    }
}
