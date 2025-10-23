#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIMV 10
#define DIMG 5
using namespace std;

// TODO creiamo l gioco dell'8 l'utente decide 5 numeri e il programma genera 5 numeri tra 1-90 e verifica se il giocatore a vinto

int main()
{

    srand(time(0));
    int numerVincenti[DIMV], numeriGiocati[DIMG], i, vinti = 0;

    //! Genera i numeri
    i = 0;
    while (i < DIMV)
    {
        int numero;
        bool esiste = false;

        numero = rand() % 90 + 1;

        //? controllo se il numero è già presente
        for (int j = 0; j < i; j++)
        {
            if (numerVincenti[j] == numero)
            {
                esiste = true;
            }
        }

        //? se il numero non è presente lo aggiunge all'array
        if (!esiste)
        {
            numerVincenti[i] = numero;
            i++;
        }
    }

    /*
    cout<<"Numeri generati: ";
    for (int i=0 ; i<DIMV ; i++) {
        cout<<numerVincenti[i]<<" ";
    }
    cout<<endl;
    */

    //! Numeri giocati dell'utente
    i = 0;
    while (i < DIMG)
    {
        int numero;
        bool esiste = false;

        cout << "Inserisci il " << i + 1 << " numero che vuoi giocare: ";
        cin >> numero;

        //? controllo se il numero è già presente
        for (int j = 0; j < i; j++)
        {
            if (numeriGiocati[j] == numero)
            {
                esiste = true;
            }
        }

        if (numero > 90)
        {
            esiste = true;
        }

        //? se il numero non è presente lo aggiunge all'array
        if (!esiste)
        {
            numeriGiocati[i] = numero;
            i++;
        }
        else
        {
            cout << "Il numero inserito non e' valdo inserire di nuovo" << endl;
        }
    }

    /*
    cout<<"Numeri giocati: ";
    for (int i=0 ; i<DIMG ; i++) {
        cout<<numeriGiocati[i]<<" ";
    }
    cout<<endl;
    */

    //! controllo se l'utente ha vinto
    i = 0;
    while (i < DIMG)
    {
        bool esiste = false;
        int numero;

        numero = numeriGiocati[i];

        //? controllo se il numero è già presente
        for (int j = 0; j < DIMV; j++)
        {
            if (numerVincenti[j] == numero)
            {
                esiste = true;
            }
        }

        //? se il numero non è presente lo aggiunge all'array
        if (esiste)
        {
            //? cout<<"Hai vinto con il numero "<<numero<<endl;
            vinti++;
            i++;
        }
        else if (!esiste)
        {
            cout << "Il numero " << numero << " non e' vincente" << endl;
            i++;
        }
    }

    //! determino quanti numer sono vincenti
    cout << endl;
    switch (vinti)
    {
        /*
        case 1:
            cout<<"Ha vinto solo con un numero."<<endl;
            break;
        */

    case 2:
        cout << "Hai fatto ambo." << endl;
        break;

    case 3:
        cout << "Hai fatto terna." << endl;
        break;

    case 4:
        cout << "Hai fatto quaterna." << endl;
        break;

    case 5:
        cout << "Hai fatto cinquina." << endl;
        break;

    default:
        cout << "Nessun numero e' vincete." << endl;
        break;
    }

    system("pause");
    return 0;
}