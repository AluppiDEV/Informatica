package Java.Assemblaggio_pc;

public class Computer {

    private String nomeConfigurazione;
    private CPU proceessore;
    private RAM memoria;
    private Disco archiviazione;
    private static final double ALIQUOTA_IVA = 0.22;

    public Computer(String nomeConfigurazione, CPU proceessore, RAM memoria, Disco archiviazione) {
        this.nomeConfigurazione = nomeConfigurazione;
        this.proceessore = proceessore;
        this.memoria = memoria;
        this.archiviazione = archiviazione;
    }

    public double calcolaPrezzoBase() {
        double tot = 0;
        tot += proceessore.getPrezzo();
        tot += memoria.getPrezzo();
        tot += archiviazione.getPrezzo();
        return tot;
    }

    public double calcolaPrezzoScontato(double percentualeSconto) {
        return (calcolaPrezzoBase() * (1 - percentualeSconto / 100));
    }

    public double calcolaPrezzoIvato(double prezzoDiPartenza) {
        return prezzoDiPartenza * (1 + ALIQUOTA_IVA);
    }

    public String stampaConfigurazione(double percentualeSconto) {
        String str = "";
        str += "# " + nomeConfigurazione + " #\n";
        str += proceessore + "\n";
        str += memoria + "\n";
        str += archiviazione + "\n";
        str += "# Prezzi #";
        str += "Prezzo totale: " + calcolaPrezzoBase();
        str += "Prezzo totale scontato: " + calcolaPrezzoScontato(percentualeSconto);
        str += "IVA totale: " + calcolaPrezzoBase() * ALIQUOTA_IVA;
        str += "Prezzo finale: " + calcolaPrezzoScontato(percentualeSconto) * (1 + ALIQUOTA_IVA / 100);
        return str;
    }

}
