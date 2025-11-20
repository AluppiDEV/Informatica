import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TieBreakTest {

    TieBreak tieBreak;

    @BeforeEach
    public void perTuttiITest() {
        tieBreak = new TieBreak("Pippo", "Pluto");
    }

    @Test
    public void iPunteggiSonoNumerici() {
        assertEquals("0, 0", tieBreak.getPunteggio());
        tieBreak.puntoPer("Pippo");
        assertEquals("1, 0", tieBreak.getPunteggio());
    }

    @Test
    public void VinciCon7punti() {
        tieBreak.puntoPer("Pippo");
        tieBreak.puntoPer("Pippo");
        tieBreak.puntoPer("Pippo");
        tieBreak.puntoPer("Pippo");
        tieBreak.puntoPer("Pippo");
        tieBreak.puntoPer("Pippo");
        assertEquals("6, 0", tieBreak.getPunteggio());
        tieBreak.puntoPer("Pippo");
        assertEquals( "Pippo vince",tieBreak.getPunteggio());

    }

}