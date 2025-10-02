
/**
 * Aggiungi qui una descrizione della classe Classe
 * 
 * @author Luppi
 * @version 1.0
 */
public class Classe {
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private int maxStud;
    private int nStud;
    private Studente students[];
    private float average;
    private int males;
    private int females;
    private String output;

    /**
     * Costruttore
     */
    public Classe(int maxStud) {
        this.maxStud = maxStud;
        students = new Studente[this.maxStud];
    }

    /**
     * Metodi getter
     */
    public float getAverage() {
        return average;
    }

    public int getMales() {
        return males;
    }

    public int getFemales() {
        return females;
    }

    /**
     * Metodi setter
     */
    public void setAverage(float average) {
        this.average = average;
    }

    public void setMales(int males) {
        this.males = males;
    }

    public void setFemales(int females) {
        this.females = females;
    }

    /**
     * Crea studente
     */
    public void addStudent(String nome, float vote, String sex) {
        if (nStud > maxStud) {
            System.out.println("Max studenti raggiuto.");
        } else {
            students[nStud] = new Studente(nome, vote, sex);
            nStud++;
        }
    }

    /**
     * Calcola media
     */
    public float calculateAverage() {
        float somma = 0;
        for (Studente studente : students) {
            somma += studente.getVote();
        }
        average = somma / nStud;
        return average;
    }

    /**
     * Calcola maschi e femmine
     */
    public String calculateSex() {
        for (Studente studente : students) {
            String sex = studente.getSex().toLowerCase();
            if (sex.equals("maschio")) {
                males++;
            } else if (sex.equals("femmina")) {
                females++;
            }
        }

        output = "Numero maschi: " + (males != 0 ? males : "Nessun maschio") + " Numero femmine: "
                + (females != 0 ? females : "Nessuna femmina");
        return output;
    }
}