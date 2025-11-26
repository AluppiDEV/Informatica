package Java.RPG_un_po_meno_baracca;

public class Guerriero extends Personaggio {

    private final int forzaFisica;

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

    @Override
    public String toString() {
        return "\n--- Personaggio ---" +
                "\nNome: " + nome +
                "\nClasse: " + classe +
                "\nLP: " + lp + "/" + lpMax +
                "\nForza Fisica: " + forzaFisica +
                "\nInventario: " + inventario +
                "\n-------------------";
    }
}
