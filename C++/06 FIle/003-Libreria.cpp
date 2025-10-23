#include "003-Libreria.h"
/**
 * Scrivi un programma in C che:
 *
 * Definisce una struct chiamata Libro con i seguenti campi:
 *
 * string titolo
 *
 * string autore
 *
 * int anno
 *
 * float prezzo
 *
 * Permette all’utente di:
 *
 * Inserire nuovi libri e salvarli su un file di testo chiamato "libreria.txt".
 *
 * Leggere e visualizzare tutti i libri presenti nel file.
 *
 * Visualizzare solo i libri pubblicati dopo un certo anno inserito dall’utente.
 */

int main()
{

    Libro catalogo[100];

    loadFromData(catalogo);

    int scelta = 0;

    do {
        clear();
        showMenu(
            { "  Seleziona un'operazione  " },
            { "Aggiungi libro",
                "Visualizza tutte i libri",
                "Visualizza solo i libri pubblicati dopo un certo anno",
                "Ricarica dati da file",
                "Esci" },
            &scelta);

        switch (scelta) {
        case 1:
            addBook(catalogo);
            break;
        case 2:
            elencoBook(catalogo);
            break;
        case 3:
            cercaLibroDaAnno(catalogo);
            break;
        case 4:
            loadFromData(catalogo);
            break;
        case 5:
            cout << "Arrivederci." << endl;
            break;
        default:
            cout << "Scelta non valida. Riprova." << endl;
            break;
        }
        pausa();
    } while (scelta != 5);

    return 0;
}