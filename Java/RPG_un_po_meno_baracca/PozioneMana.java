package Java.RPG_un_po_meno_baracca;

public class PozioneMana extends Oggetto {

    public PozioneMana(String nome) {
        super(nome, Tipi.POZIONE_MANA);
    }

    @Override
    public boolean usa(Personaggio p) {
        if (p.getClasse().equals(Classi.MAGO)) {
            Mago m = (Mago) p;
            int mpRemain = m.getMpMax() - m.getMp();
            for (int i = 0; i < mpRemain / 10; i++) {
                int newMp = m.getMp() + mpRemain / 10;
                m.setMp(newMp);
            }
            return true;
        } else
            return false;
    }
}
