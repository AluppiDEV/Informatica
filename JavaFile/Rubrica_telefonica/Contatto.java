package JavaFile.Rubrica_telefonica;

import java.io.Serializable;

public class Contatto implements Serializable {
    private String nome;
    private String numero;

    public Contatto(String nome, String numero)  {
        this.nome = nome;
        this.numero = numero;
    }

    // Getter e setter
    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return nome + "," + numero;
    }
}
