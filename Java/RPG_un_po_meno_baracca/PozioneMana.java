package Java.RPG_un_po_meno_baracca;

public class PozioneMana extends Oggetto {

    public PozioneMana(String nome) {
        super(nome, Tipi.POZIONE_MANA);
    }

    @Override
    public String usa(Personaggio p) {
        if (!p.getClasse().equals(Classi.MAGO)) {
            return null; // Non è un mago, oggetto non consumato
        }
        
        Mago m = (Mago) p;
        
        if (m.getMp() >= m.getMpMax()) {
            return null; // Già al massimo del mana, oggetto non consumato
        }
        
        int mpMancanti = m.getMpMax() - m.getMp();
        int incremento = 7; // Ripristina 10 MP alla volta
        
        StringBuilder messaggio = new StringBuilder();
        messaggio.append("💙 Usando Pozione Mana...\n");
        
        // Ripristina a intervalli regolari fino al massimo
        for (int i = 0; i < mpMancanti; i += incremento) {
            int cura = Math.min(incremento, mpMancanti - i);
            m.setMp(m.getMp() + cura);
            messaggio.append("   MP: ").append(m.getMp()).append("/").append(m.getMpMax()).append("\n");
        }
        
        messaggio.append("💙 Mana completamente ripristinato!");
        return messaggio.toString();
    }
}
