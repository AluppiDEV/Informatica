/*
Dato un elenco di libri con autore, argomento e prezzo determinare il volume con il prezzo minimo e il
volume con il prezzo massimo scegliendoli fra quelli che riguardano un argomento dato in input. Se
non vi sono volumi corrispondenti all'argomento proposto stampare un appropriato messaggio.
*/

#include <cstdlib>
#include <ctime>
#include <iostream>
#define DIM 10
using namespace std;

int main()
{
    system("cls");
    srand(time(0));

    int codArg, codAut, ins, iMax, iMin;
    float prezzo[DIM], pMax = 0, pMin = 50;
    string risposta, arg[DIM], aut[DIM], controllo[] { "Storico", "Sportivo", "Avventura", "Mike", "Luke", "Andrea" };
    bool exit;

    for (int i = 0; i < DIM; i++) {
        prezzo[i] = rand() % 10 + 21.99;
    }

    for (int i = 0; i < DIM; i++) {
        codArg = rand() % 3;
        arg[i] = controllo[codArg];
    }

    for (int i = 0; i < DIM; i++) {
        codAut = rand() % 3 + 3;
        aut[i] = controllo[codAut];
    }

    cout << "Ecco il nostro catalog libri" << endl;
    cout << "Autore \t Argometo \t Prezzo" << endl;
    for (int i = 0; i < DIM; i++) {
        cout << aut[i] << " \t" << arg[i] << " \t" << prezzo[i] << endl;
    }
    cout << endl;
    cout << "Benvenuto in bibblioteca" << endl;

    do {

        cout << "Scrivi qui di seguito l'argomento del libro che vuoi trovare (" << controllo[0] << " " << controllo[1] << " " << controllo[2] << ") \noppure scegli tra uno dei nostri autori (" << controllo[3] << " " << controllo[4] << " " << controllo[5] << ").";
        cin >> risposta;
        cout << endl;

        for (int i = 0; i < 6; i++) {
            if (controllo[i] == risposta) {
                if (i < 3) {
                    exit = true;
                    ins = 0;
                } else {
                    exit = true;
                    ins = 1;
                }
            }
        }

        if (!exit) {
            cout << "Argomento o autore inseriti non valido inserire di nuovo." << endl;
        }

    } while (!exit);

    switch (ins) {
    case 0:
        cout << "Ecco tutti i libri con tema " << risposta << endl;
        cout << "Autore \t Argometo \t Prezzo" << endl;
        for (int i = 0; i < DIM; i++) {
            if (arg[i] == risposta) {
                cout << aut[i] << " \t" << arg[i] << " \t" << prezzo[i] << endl;
                if (prezzo[i] > pMax) {
                    pMax = prezzo[i];
                    iMax = i;
                } else if (prezzo[i] < pMin) {
                    pMin = prezzo[i];
                    pMin = i;
                }
            }
        }
        break;

    case 1:
        cout << "Ecco tutti i libri con autore " << risposta << endl;
        cout << "Autore \t Argometo \t Prezzo" << endl;
        for (int i = 0; i < DIM; i++) {
            if (aut[i] == risposta) {
                cout << aut[i] << " \t" << arg[i] << " \t" << prezzo[i] << endl;
                if (prezzo[i] > pMax) {
                    pMax = prezzo[i];
                    iMax = i;
                } else if (prezzo[i] < pMin) {
                    pMin = prezzo[i];
                    iMin = i;
                }
            }
        }
        break;
    }

    cout << "Il prezzo maggiore e' " << endl
         << "Autore: " << aut[iMax] << ". Argomento: " << arg[iMax] << ". Prezzo: " << prezzo[iMax] << endl;
    cout << "Mentre quello minore e' " << endl
         << "Autore: " << aut[iMin] << ". Argomento: " << arg[iMin] << ". Prezzo: " << prezzo[iMin] << endl;
    cout << endl;

    system("pause");
    return 0;
}
