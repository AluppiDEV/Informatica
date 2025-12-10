package Java.Gestione_aeroportuale;

public class TecnicoManutentore extends Persona {
    private boolean occupato;

    public TecnicoManutentore(String nome, String matricola) {
        super(nome, matricola);
        this.occupato = false;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
}
