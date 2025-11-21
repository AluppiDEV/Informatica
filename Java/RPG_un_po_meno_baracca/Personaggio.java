package Java.RPG_un_po_meno_baracca;

import java.util.ArrayList;

public abstract class Personaggio {

    protected String nome;
    protected int lp;
    protected final int lpMax;
    protected Inventario inventario;

    public Personaggio(String nome, int lp, int lpMax) {
        this.nome = nome;
        this.lp = lp;
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

}
