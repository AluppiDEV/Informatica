package Java.RPG_un_po_meno_baracca;

public class PozioneCurativa extends Oggetto {

    public PozioneCurativa(String nome) {
        super(nome, Tipi.POZIONE_CURATIVA);
    }

    @Override
    public boolean usa(Personaggio p) {
        int lpRemain = p.getLpMax()-p.getLp();
        for (int i = 0; i < lpRemain/10; i++) {
            int newLp = p.getLp() + lpRemain /10;
            p.setLp(newLp);
        }
        return true;
    }
}
