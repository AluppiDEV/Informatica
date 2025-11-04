package Java.Flotta_veicoli;

import java.util.ArrayList;

public class Veicolo {

    private final String targa;
    private final String type;
    private int carburante;
    private ArrayList<Componente> componenti;

    public Veicolo(String targa) {
        this.targa = targa;
        this.type = targa.split(" ")[0];
        carburante = 100;
        componenti = new ArrayList<>();
        componenti.add(new Componente("GM"));
        componenti.add(new Componente("MT"));
        componenti.add(new Componente("TL"));
        componenti.add(new Componente("BT"));
    }

    public Veicolo(Veicolo v) {
        this.targa = v.getTarga();
        this.type = this.getType();
        componenti = new ArrayList<>();
        this.componenti.addAll(v.getComponenti());
    }

    public void cambiaComponente(String id) {
        for (Componente c : componenti) {
            if (c.getId().equals(id)) {
                c.sostituisci();
            }
        }
    }

    public void simulaViaggio(int km) {
        if (carburante - consumoCarburante(km) > 0) {

            for (Componente c : componenti) {
                c.aggiornaUsura(km);
            }
            carburante = consumoCarburante(km);
        }
    }

    private int consumoCarburante(int km) {
        switch (targa.split(" ")[0]) {
            case "MC":
                return carburante * (1 - (3 * km) / 100);
            case "CM":
                return carburante * (1 - (10 * km) / 100);
            case "MT":
                return carburante * (1 - (5 * km) / 100);
            default:
                break;
        }
        return 0;
    }

    public String checkCarburante() {
        StringBuilder str = new StringBuilder();
        str.append(carburante <= 20 ? "Necesasrio fare il pieno" : ("Resta il: " + carburante));
        return str.toString();
    }

    public String checkManutenzione() {
        StringBuilder str = new StringBuilder();
        str.append(carburante <= 20 ? "Necesasrio fare il pieno" : ("Resta il: " + carburante));
        str.append("---------------------------");
        for (Componente c : componenti) {
            str.append(c.daSostituire() ? (c.getId() + " è da sostituire") : (c.getId() + " ancora utulizzabile"))
                    .append("\n");
        }
        return str.toString();
    }

    public String getTarga() {
        return targa;
    }

    public ArrayList<Componente> getComponenti() {
        return componenti;
    }

    public String getType() {
        return type;
    }

}
