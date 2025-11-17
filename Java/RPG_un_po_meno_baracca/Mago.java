package Java.RPG_un_po_meno_baracca;

public class Mago extends Personaggio {

    private int potereMagico;
    private int mana;

    public Mago(String nome, int lp, int lpMax, int potereMagico, int mana) {
        super(nome, lp, lpMax);
        this.potereMagico = potereMagico;
        this.mana = mana;
    }

    @Override
    public boolean isAlive() {
        return lp > 0;
    }

    @Override
    public int attacca() {
        mana = mana * (1 - potereMagico / 100);
        return potereMagico;
    }
}
