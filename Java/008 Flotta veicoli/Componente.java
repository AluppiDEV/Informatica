public class Componente {

    private static int idCounter = 1;
    private String id;
    private int usura;

    public Componente(String type) {
        id = type + "-" + idCounter;
        idCounter++;
        usura = 100;
    }

    public Componente(Componente c) {
        this.id = c.getId();
        this.usura = c.getUsura();
    }

    private double calcoloUsura(int km) {
        double moltiplicatore = Math.random() + 2;
        String tipo = id.split("-")[0]; // prende la parte prima del "-"
        switch (tipo) {
            case "GM": // Gomme
                return moltiplicatore * km;
            case "MT": // Motore
                return moltiplicatore * 2 * km;
            case "TL": // Telaio
                return moltiplicatore * 0.5 * km;
            case "BT": // Batteria
                return moltiplicatore * 0.8 * km;
            default:
                return 0;
        }
    }

    public void aggiornaUsura(int km) {
        usura *= (1 - calcoloUsura(km) / 100);
    }

    public boolean daSostituire() {
        if (usura <= 30)
            return true;
        return false;
    }

    public void sostituisci() {
        
    }

    public int getUsura() {
        return usura;
    }

    public String getId() {
        return id;
    }

}
