***********************************************************
*  USER STORY 1                                           *
*  Come arbitro, voglio poter dare inizio alla partita    *
*  tra due giocatori                                      *
***********************************************************

Sostituite nel file GameTest.java la classe GameTest con questa:

public class GameTest {

    Game game;

    @BeforeEach
    public void perTuttiITest() {
        game = new Game("Pippo", "Pluto");
    }

}

Se BeforeEach è rosso, click sulla parola e [Alt]+[Invio]
Lanciate GameTest.java con Run > Run 'Gamestest'  - oppure [Shift]+[F10], ed otterrete un errore di compilazione.

Viene segnalato un errore, che dovrete risolvere. 
Ricordarsi che basta solo che il test diventi verde, non fate overcoding (Basta 1 click)
Quando il test è verde, potete migliorare quel poco che c'è (5 secondi circa)


