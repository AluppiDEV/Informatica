public class Atleta {

    private String nome;
    private String nazionalita;
    private double tempoGara;
    private String disciplina;

    public Atleta(String nome, String nazionalita, double tempoGara, String disciplina) {
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.tempoGara = tempoGara;
        this.disciplina = disciplina;
    }

    public Atleta(Atleta a) {
        nome = a.getNome();
        nazionalita = a.getNazionalita();
        tempoGara = a.getTempoGara();
        disciplina = a.getDisciplina();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public double getTempoGara() {
        return tempoGara;
    }

    public void setTempoGara(double tempoGara) {
        this.tempoGara = tempoGara;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String toString() {
        long cents = Math.round(tempoGara * 100);
        long whole = cents / 100;
        long frac = Math.abs(cents % 100);
        String tempoStr = whole + "." + (frac < 10 ? "0" + frac : String.valueOf(frac));

        String s = "Atleta: " + nome + " (" + nazionalita + ")\n";
        s += "Disciplina: " + disciplina + "\n";
        s += "Tempo di gara: " + tempoStr + " s";
        return s;
    }

}
