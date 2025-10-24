import java.util.ArrayList;

public class Veicolo {

    private final String targa;
    private final String type;
    private ArrayList<Componente> componenti;

    public Veicolo(String targa) {
        this.targa = targa;
        this.type = targa.split(" ")[0];
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
        for (Componente c : componenti) {
            c.aggiornaUsura(km);
        }
    }

    private void consumoCarburante() {
        
    }

    public String checkManutenzione() {
        StringBuilder str = new StringBuilder();
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
