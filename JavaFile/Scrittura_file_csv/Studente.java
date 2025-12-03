package Java.Scrittura_file_csv;

public class Studente {

    private String nome;
    private int voto;

    public Studente(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
    }

    @Override
    public String toString() {
        return nome + "," + voto;
    }
}
