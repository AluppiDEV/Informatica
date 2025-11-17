package Java.RPG_un_po_meno_baracca;

import java.util.ArrayList;

public abstract class Personaggio {

    protected String nome;
    protected int lp;
    protected int lpMax;
    protected ArrayList<Oggetto> inventario;

    public Personaggio(String nome, int lp, int lpMax) {
        this.nome = nome;
        this.lp = lp;
        this.lpMax = lpMax;
        inventario = new ArrayList<>();
    }

    public abstract boolean isAlive();

    public abstract int attacca();

    public void riceviDanno(int danno) {
        lp -= danno;
    }

    public void aggiungiOggetto(Oggetto oggetto) {
        inventario.add(oggetto);
    }

    public void rimuoviOggetto(Oggetto oggetto) {
        inventario.remove(oggetto);
    }

}
