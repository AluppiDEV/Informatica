package Java.RPG_un_po_meno_baracca;

import java.util.ArrayList;

public abstract class Personaggio {

    protected String nome;
    protected Classi classe;
    protected int lp;
    protected final int lpMax;
    protected Inventario inventario;

    public Personaggio(String nome, int lpMax) {
        this.nome = nome;
        this.lp = lpMax;
        this.lpMax = lpMax;
        this.inventario = new Inventario(Personaggio.this);
    }

    public int getLpMax() {
        return lpMax;
    }

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public boolean isAlive() {
        return lp > 0;
    };

    public Classi getClasse() {
        return classe;
    }

    public void riceviDanno(int danno) {
        lp -= danno;
    }

    public abstract int attacca(Personaggio p);

    // Gestione inventario

    public void aggiungiOggetto(Oggetto oggetto) {
        inventario.aggiungiOggetto(oggetto);
    }

    public void rimuoviOggetto(Oggetto oggetto) {
        inventario.rimuoviOggetto(oggetto);
    }

    public boolean usaOggetto(Tipi tipo) {
        return inventario.usaOggetto(tipo);
    }

    // Informazioni personaggio
    @Override
    public String toString() {
        return "\n--- Personaggio ---" +
                "\nNome: " + nome +
                "\nClasse: " + classe +
                "\nLP: " + lp + "/" + lpMax +
                "\nInventario: " + inventario +
                "\n-------------------";
    }
}
