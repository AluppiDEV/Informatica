
public class Canzone {
    
    private String titolo;
    private String artista;
    private int durata; /* Durata in secondi */

    public Canzone(String titolo, String artista, int durataSec) {
        this.titolo = titolo;
        this.artista = artista; 
        this.durata = Math.max(0, durataSec);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    private String getTime() {
        int t;

        t = durata / 60;

        return t + ":" + (durata -(60 * t));
    }

    public String toString() {
        return titolo + " di " + artista +  getTime();
    }

}
