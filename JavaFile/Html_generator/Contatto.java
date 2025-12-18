package pkg002javaoffstream;

/**
 *
 * @author m.malavasi
 */
public class Contatto {
    private String nome;
    private String numero;
    
    public Contatto(String nome, String numero){
        this.nome = nome;
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        return nome + " - " + numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }
}
