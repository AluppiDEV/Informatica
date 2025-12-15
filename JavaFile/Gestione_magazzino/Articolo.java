import java.io.Serializable;

public abstract class Articolo implements Serializable {
    protected int id;
    private static int contatore = 1000;
    protected String nome;
    protected float peso;
    protected float prezzo;

    public Articolo(String nome, float peso, float prezzo) {
        id = contatore++;
        this.nome = nome;
        this.peso = peso;
        this.prezzo = prezzo;
    }

    public abstract String stampaEtichetta();

}
