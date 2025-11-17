package Java.RPG_un_po_meno_baracca;

public abstract class Oggetto {

    protected String nome;
    protected Oggetti tipo;

    public Oggetto(String nome, Oggetti tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public Oggetti getTipo() {
        return tipo;
    }

    public boolean usa(Personaggio p) {
        return false;
    }

}
