#include "004-Autonoleggio.h"
/*
 * Scrivi un programma in C che:
 *
 * Definisce una struct chiamata AutoNoleggio con i seguenti campi:
 *
 * string targa[10]
 *
 * string marca[20]
 *
 * string modello[20]
 *
 * int annoImmatricolazione
 *
 * int disponibile (1 se disponibile, 0 se già noleggiata)
 *
 * Permette all’utente di:
 *
 * Inserire nuove auto e salvarle su un file di testo chiamato "autonoleggio.txt".
 *
 * Visualizzare tutte le auto presenti nel file.
 *
 * Visualizzare solo le auto disponibili per il noleggio.
 *
 * Cercare un’auto per targa e modificarne lo stato di disponibilità (da disponibile a noleggiata e viceversa).
 */

int main()
{

    Autonoleggio catalogo[100];

    loadFromData(catalogo);

    int scelta = 0;

    do {
        clear();
        showMenu(
            { "  Seleziona un'operazione  " },
            { "Aggiungi auto",
                "Visualizza tutte le auto",
                "Visualizza auto disponibili",
                "Cerca auto per targa",
                "Ricarica dati da file",
                "Esci" },
            &scelta);

        switch (scelta) {
        case 1:
            addAuto(catalogo);
            break;
        case 2:
            elencoAuto(catalogo);
            break;
        case 3:
            elencoAutoDisponibili(catalogo);
            break;
        case 4:
            cercaAuto(catalogo);
            break;
        case 5:
            loadFromData(catalogo);
            break;
        case 6:
            cout << "Uscita dal programma." << endl;
            break;
        default:
            cout << "Scelta non valida. Riprova." << endl;
            break;
        }
        pausa();
    } while (scelta != 6);

    return 0;
}