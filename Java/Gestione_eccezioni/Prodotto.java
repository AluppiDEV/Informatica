package Java.Gestione_eccezioni;

public class Prodotto {

    private int numero;
    private final int maxNumero;
    private String nome;
    private String descrizone;

    public Prodotto(int numero, int maxNumero, String nome, String descrizone) {
        this.numero = numero;
        this.maxNumero = maxNumero;
        this.nome = nome;
        this.descrizone = descrizone;
    }

    public int getNumero() {
        return numero;
    }

    public boolean preleva() {
        if (numero-- < 0) return false;
        numero--;
        return true;
    }

    public boolean refill() {
        numero = maxNumero;
        return true;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n\t" + descrizone;
    }
}
