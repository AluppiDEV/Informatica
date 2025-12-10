package Java.Gestione_aeroportuale;

public abstract class Persona {
    protected String nome;
    protected String matricola;

    public Persona(String nome, String matricola) {
        this.nome = nome;
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricola() {
        return matricola;
    }
}
