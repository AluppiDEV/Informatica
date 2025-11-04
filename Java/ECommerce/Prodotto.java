package Java.ECommerce;

public class Prodotto {

    private String sku;
    private String nome;
    private double prezzoUnitario;

    public Prodotto(String sku, String nome, double prezzoUnitario) {
        this.sku = sku;
        this.nome = nome;
        this.prezzoUnitario = prezzoUnitario;
    }

    public Prodotto(Prodotto p) {
        sku = p.getSku();
        nome = p.getNome();
        prezzoUnitario = p.getPrezzoUnitario();
    }

    public String getSku() {
        return sku;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[" + sku + "]").append(", Nome: " + nome).append(", Prezzo" + prezzoUnitario);
        return str.toString();
    }

}
