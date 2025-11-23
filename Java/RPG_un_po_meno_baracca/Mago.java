package Java.RPG_un_po_meno_baracca;

public class Mago extends Personaggio {

    private int potereMagico;
    private int mp;
    private final int mpMax;

    public Mago(String nome, int lpMax, int potereMagico, int mpMax) {
        super(nome, lpMax);
        this.classe = Classi.MAGO;
        this.potereMagico = potereMagico;
        this.mp = mpMax;
        this.mpMax = mpMax;
    }

    public int getMpMax() {
        return mpMax;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    private int calcolaDanno() {
        if (mp > 0) {
            mp *= (1 - potereMagico / 100);
            return potereMagico;
        } else {
            return 5;
        }
    }

    @Override
    public int attacca(Personaggio p) {
        p.riceviDanno(calcolaDanno());
        return calcolaDanno();
    }
}
