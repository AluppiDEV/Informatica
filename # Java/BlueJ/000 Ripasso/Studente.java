public class Studente {

    private String nome;
    private String cognome;
    private int eta;
    private double media;
    private int votiInseriti;
    private double sommaVoti;

    public Studente(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = Math.max(1, eta);
        media = 0;
        votiInseriti = 0;
    }

    public void aggiungiVoto(double voto) {

        if (voto < 0) {
            voto = 0;
        } else if (voto > 10) {
            voto = 10;
        }

        sommaVoti += voto;
        votiInseriti++;

        calcoloMedia();

    }

    private void calcoloMedia() {

        media = (sommaVoti / votiInseriti);

    }

    public String toString() {
        String out = "";

        out += "Nome dello studente: " + nome + "\n";
        out += "Cognome dello studente: " + cognome + "\n";
        out += "Eta dello studente: " + eta + "\n";
        out += "Media dello studente: " + media + "\n";

        return out;
    }

}
