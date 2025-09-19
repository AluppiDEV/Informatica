#include "002-Registro.h"
using namespace std;

// Funzione principale
int main()
{
    const int MAX = 100;
    Studente alunno[MAX];
    int scelta;

    loadFromData(alunno);

    do {
        clear();
        showMenu(
            { "___MENU___" },
            {
                "Aggiungi uno studente",
                "Visualizza il registro",
                "Cerca uno studente",
                "Modifica i dati di uno studente",
                "Elimina uno studente",
                "Ordina il registro (per media o per nome)",
                "Esci dal programma",
            },
            &scelta);

        clear();
        switch (scelta) {
        case 1:
            // Aggiungi uno studente
            addStudent(alunno);
            break;
        case 2:
            // Visualizza il registro
            showElenco(alunno);
            break;
        case 3:
            // Cerca uno studente
            searchStudentBySurname(alunno);
            break;
        case 4:
            // Modifica i dati di uno studente
            modifyStudent(alunno);
            break;
        case 5:
            // Elimina uno studente
            deleteStudent(alunno);
            break;
        case 6: {
            // Ordina il registro
            int method;
            showMenu({ "" }, { "Ordina per nome", "Ordina per media" }, &method);
            sortAndPrint(alunno, method - 1);
        } break;
        case 7:
            // Esci dal programma
            cout << "Arrivederci!" << endl;
            break;
        default:
            cout << "Scelta non valida. Riprova." << endl;
            break;
        }
        pausa();

    } while (scelta != 7);

    return 0;
}