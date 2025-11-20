public class Game {

    private final String[] players = new String[2];
    private final int[] punteggi = new int[2];
    private final Punti[] punti = Punti.values();

    public Game(String p1, String p2) {
        players[0] = p1;
        players[1] = p2;
        punteggi[0] = 0;
        punteggi[1] = 0;
    }

    public String getPunteggio() {
        Punti p0 = punti[punteggi[0]];
        Punti p1 = punti[punteggi[1]];

        // vittorie
        if (p0 == Punti.VINTO) return players[0] + " vince";
        if (p1 == Punti.VINTO) return players[1] + " vince";

        // vantaggio trasformato in vittoria
        if (p0 == Punti.VANTAGGIO && p1 != Punti.QUARANTA) return players[0] + " vince";
        if (p1 == Punti.VANTAGGIO && p0 != Punti.QUARANTA) return players[1] + " vince";

        // vantaggio
        if (p0 == Punti.VANTAGGIO) return "vantaggio " + players[0];
        if (p1 == Punti.VANTAGGIO) return "vantaggio " + players[1];

        // deuce
        if (p0 == Punti.QUARANTA && p1 == Punti.QUARANTA) return "parità";

        return p0.stringValue() + ", " + p1.stringValue();
    }

    private void aumentaPunteggio(int idx) {
        int other = 1 - idx;
        Punti mio = punti[punteggi[idx]];
        Punti suo = punti[punteggi[other]];

        switch (mio) {

            case ZERO -> punteggi[idx] = Punti.QUINDICI.intValue();

            case QUINDICI -> punteggi[idx] = Punti.TRENTA.intValue();

            case TRENTA -> punteggi[idx] = Punti.QUARANTA.intValue();

            case QUARANTA -> {
                // mio 40 - suo < 40 -> salgo
                if (suo.ordinal() < Punti.QUARANTA.ordinal()) {
                    punteggi[idx] = Punti.VINTO.intValue();
                    return;
                }

                // deuce -> passo a vantaggio
                if (suo == Punti.QUARANTA) {
                    punteggi[idx] = Punti.VANTAGGIO.intValue();
                }
            }

            case VANTAGGIO -> punteggi[idx] = Punti.VINTO.intValue();

            default -> {
                // se l'altro è in vantaggio e io segno -> torna deuce
                if (suo == Punti.VANTAGGIO) {
                    punteggi[idx] = Punti.QUARANTA.intValue();
                    punteggi[other] = Punti.QUARANTA.intValue();
                }
            }
        }
    }

    public void puntoPer(String player) {
        if (player.equals(players[0])) aumentaPunteggio(0);
        else if (player.equals(players[1])) aumentaPunteggio(1);
    }
}
