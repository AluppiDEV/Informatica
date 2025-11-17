package Java.RPG_un_po_meno_baracca;

public class Guerriero extends Personaggio {

    private int forzaFisica;

    public Guerriero(String nome, int lp, int lpMax, int forzaFisica) {
        super(nome, lp, lpMax);
        this.forzaFisica = forzaFisica;
    }

    @Override
    public boolean isAlive() {
        return lp > 0;
    }

    @Override
    public int attacca() {
        return forzaFisica;
    }
}
