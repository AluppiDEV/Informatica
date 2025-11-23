package Java.RPG_un_po_meno_baracca;

public class Party {
    public static void main(String[] args) {
        Personaggio p1 = new Mago("Maghetto", 100, 10, 200);
        Personaggio p2 = new Guerriero("Gueriero", 100, 30);

        System.out.println(p1.attacca(p2));

        PozioneMana pm = new PozioneMana("Pozione mana");
        PozioneCurativa pc = new PozioneCurativa("Pozione curativa");

        p1.aggiungiOggetto(pm);
        p1.aggiungiOggetto(pc);

        p2.aggiungiOggetto(pm);
        p2.aggiungiOggetto(pc);

        System.out.println(p2);

    }
}
