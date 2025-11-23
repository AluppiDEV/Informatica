package Java.RPG_un_po_meno_baracca;

public class Guerriero extends Personaggio {

    private int forzaFisica;

    public Guerriero(String nome, int lpMax, int forzaFisica) {
        super(nome, lpMax);
        this.classe = Classi.GUERIERO;
        this.forzaFisica = forzaFisica;
    }

    @Override
    public int attacca(Personaggio p) {
        p.riceviDanno(forzaFisica);
        return forzaFisica;
    }
}
