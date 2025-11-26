package Java.RPG_un_po_meno_baracca;

public class PozioneCurativa extends Oggetto {

    public PozioneCurativa(String nome) {
        super(nome, Tipi.POZIONE_CURATIVA);
    }

    @Override
    public String usa(Personaggio p) {
        if (p.getLp() >= p.getLpMax()) {
            return null; // Già al massimo della salute, oggetto non consumato
        }
        
        int lpMancanti = p.getLpMax() - p.getLp();
        int incremento = 10; // Cura 10 LP alla volta
        
        StringBuilder messaggio = new StringBuilder();
        messaggio.append("💚 Usando Pozione Curativa...\n");
        
        // Cura ad intervalli regolari fino al massimo
        for (int i = 0; i < lpMancanti; i += incremento) {
            int cura = Math.min(incremento, lpMancanti - i);
            p.setLp(p.getLp() + cura);
            messaggio.append("   LP: ").append(p.getLp()).append("/").append(p.getLpMax()).append("\n");
        }
        
        messaggio.append("💚 Completamente guarito!");
        return messaggio.toString();
    }
}
