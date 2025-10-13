public class Studente {

    private String nome;
    private String cognome;
    private float media;
    private boolean promosso;

    public Studente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.media = 5;
    }

    public void setMedia(float media) {
        this.media = Math.max(1, Math.min(10, media));
        controllaPromozione();
    }

    private void controllaPromozione() {
        if (media >= 6) {
            promosso = true;
        } else {
            promosso = false;
        }
    }

    public String toString() {
        String out = "";

        out += "Nome dello studente: " + nome + "\n";
        out += "Cognome dello studente: " + cognome + "\n";
        out += "Media dello studente: " + media + "\n";
        out += "Lo studente in questo anno: " + (promosso ? "viene" : "non viene") + "promosso \n";

        return out;
    }

}
