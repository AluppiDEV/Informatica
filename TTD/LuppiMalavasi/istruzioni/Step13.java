***********************************************************
*  USER STORY 11                                          *
*  Come arbitro, voglio leggere il risultato corretto     *
*  del TieBreak                                           *
***********************************************************


Create TieBreak, una classe derivata di Game


        Quindi create il relativo test tramite il comando (oramai dovreste sapere come si fa, ad ogni modo)
        NETBEANS:
        Click destro su TieBreak.java
        Tools > Create/Update Test
        Click su [x] Public methods > [OK] > Junit 5.x > [Select]

        IDEA:
        Nel file TieBreak.java Click destro sulla PAROLA TieBreak  e premere [Alt]-[Invio] > Create test
        SostituiteTieBreakTest con questo (versione Junit 5)
        Se necessario importate BeforeEach e Test con [Alt]+[Invio]

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
    
    
}




