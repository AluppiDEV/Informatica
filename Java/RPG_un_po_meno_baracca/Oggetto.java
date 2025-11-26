package Java.RPG_un_po_meno_baracca;

public abstract class Oggetto {

    protected String nome;
    protected Tipi tipo;

    public Oggetto(String nome, Tipi tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public Tipi getTipo() {
        return tipo;
    }

    public boolean usa(Personaggio p) {
        return false;
    }

    // Informazioni oggetto


    @Override
    public String toString() {
        return "[Oggetto: " + nome + ", Tipo: " + tipo + "]";
    }
}
