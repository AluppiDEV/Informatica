package JavaFile.Rubrica_telefonica;

public class Contatto {

    private String nome;
    private String numero;

    // costruttore completo
    public Contatto(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return nome + "," + numero;
    }

}
