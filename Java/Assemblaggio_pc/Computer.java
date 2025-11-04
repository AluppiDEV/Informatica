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
        return proceessore.getPrezzo() + memoria.getPrezzo() + archiviazione.getPrezzo();
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
        str += "# Prezzi #" + "\n";
        str += "Prezzo totale: " + String.format("%.2f", calcolaPrezzoBase()) + "\n";
        str += "Prezzo totale scontato: " + String.format("%.2f", calcolaPrezzoScontato(percentualeSconto)) + "\n";
        str += "IVA totale: " + String.format("%.2f", calcolaPrezzoBase() * ALIQUOTA_IVA) + "\n";
        str += "Prezzo finale: "
                + String.format("%.2f", calcolaPrezzoScontato(percentualeSconto) * (1 + ALIQUOTA_IVA / 100)) + "\n";
        return str;
    }

}
