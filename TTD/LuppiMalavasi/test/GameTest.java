import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Game game;

    @BeforeEach
    public void perTuttiITest() {
        game = new Game("Pippo", "Pluto");
    }

    @Test
    public void zeroDeveEssereLaDescrizionePerIlPunteggio0() {
        assertEquals("zero, zero",game.getPunteggio());
    }

    @Test
    public void quindiciDeveEssereIlDescrittorePerIlPunteggio1() {
        game.puntoPer("Pluto");
        assertEquals("zero, quindici", game.getPunteggio());
    }

    @Test
    public void trentaDeveEssereIlDescrittorePerIlPunteggio2() {
        game.puntoPer("Pluto");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        assertEquals("trenta, quindici", game.getPunteggio());
    }

    @Test
    public void quarantaDeveEssereIlDescrittorePerIlPunteggio3() {
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        assertEquals("quaranta, zero", game.getPunteggio());
    }

    @Test
    public void robustezza() {
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        assertEquals(game.getPunteggio(), "zero, trenta");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        assertEquals(game.getPunteggio(), "trenta, trenta");
        game.puntoPer("Paperino");
        game.puntoPer("Paperoga");
        assertEquals(game.getPunteggio(), "trenta, trenta");
        game=new Game("Paperino","Paperoga");
        game.puntoPer("Paperino");
        game.puntoPer("Paperoga");
        assertEquals("quindici, quindici",game.getPunteggio());
    }

    @Test
    public void paritàDeveEssereIlDescrittorePerIlPunteggioQuandoEntrambiHannoFatto3Punti() {
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        assertEquals("parità", game.getPunteggio());
    }

    @Test
    public void vantaggioGiocatoreDeveEssereIlDescrittorePerIlPunteggioQuandoEntrambiHannoFatto3PuntiEUnoNeHaDiPiù() {
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        game.puntoPer("Pippo");
        assertEquals("vantaggio Pippo",game.getPunteggio());
        game.puntoPer("Pluto");
        assertEquals("parità", game.getPunteggio());
        game.puntoPer("Pluto");
        assertEquals("vantaggio Pluto",game.getPunteggio());
    }

    @Test
    public void VittoriaSenzaVantaggi() {
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        assertEquals("Pippo vince", game.getPunteggio());
    }

    @Test
    public void VittoriaAiVantaggi() {
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        assertEquals("Pluto vince", game.getPunteggio());
    }
}