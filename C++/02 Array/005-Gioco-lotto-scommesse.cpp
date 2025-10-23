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
    int numeriVincenti[DIMV], numeriGiocati[DIMG], numeriVinti[DIMG], i, vinti, soldi, scommessa = 0;
    bool stop = false;

    //! Quanti soldi ha l'utente
    cout << "Con quanti soldi parti a giocare ";
    cin >> soldi;

    while (!stop)
    {

        //! Controlla la scmmessa
        bool valido = true;
        i = 0;
        scommessa = 0;
        while (scommessa == 0)
        {
            int numero;

            if (!valido)
            {
                cout << "La scommessa non e' valida riprova " << endl;
            }

            cout << "Quanti ne vuoi scommettere ";
            cin >> numero;

            //? controllo se il numero è valido
            if (soldi >= numero)
            {
                scommessa = numero;
            }
            else
            {
                valido = false;
            }
        }

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
                if (numeriVincenti[j] == numero)
                {
                    esiste = true;
                }
            }

            //? se il numero non è presente lo aggiunge all'array
            if (!esiste)
            {
                numeriVincenti[i] = numero;
                i++;
            }
        }

        /*
        cout<<"Numeri generati: ";
        for (int i=0 ; i<DIMV ; i++) {
            cout<<numeriVincenti[i]<<" ";
        }
        cout<<endl;
        */

        //! Numeri giocati dell'utente
        cout << endl;
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

        //! Controllo se l'utente ha vinto
        for (int i = 0; i < DIMG; i++)
        {
            numeriVinti[i] = 0;
        }
        i = 0;
        vinti = 0;
        while (i < DIMG)
        {
            bool esiste = false;
            int numero;

            numero = numeriGiocati[i];

            //? controllo se il numero è già presente
            for (int j = 0; j < DIMV; j++)
            {
                if (numeriVincenti[j] == numero)
                {
                    esiste = true;
                }
            }

            //? se il numero non è presente lo aggiunge all'array
            if (esiste)
            {
                //? cout<<"Hai vinto con il numero "<<numero<<endl;
                numeriVinti[i] = numero;
                vinti++;
                i++;
            }
            else if (!esiste)
            {
                //? cout<<"Il numero "<<numero<<" non e' vincente"<<endl;
                i++;
            }
        }

        //! Determino quanti numeri sono vincenti
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
            soldi += scommessa * 1.5;
            break;

        case 3:
            cout << "Hai fatto terno." << endl;
            soldi += scommessa * 2;
            break;

        case 4:
            cout << "Hai fatto quaterna." << endl;
            soldi += scommessa * 3;
            break;

        case 5:
            cout << "Hai fatto cinquina." << endl;
            soldi += scommessa * 5;
            cout << endl;
            break;

        default:
            cout << "Non hai vinto" << endl;
            soldi += -scommessa;
            break;
        }

        cout << "Adesso il tuo saldo e' di " << soldi << endl;
        if (vinti > 1)
        {
            cout << "Numeri con cui hai vinto: ";
            for (int i = 0; i < DIMG; i++)
            {
                if (numeriVinti[i] != 0)
                {
                    cout << numeriVinti[i] << " ";
                }
            }
        }
        cout << endl
             << "Numeri vincenti: ";
        for (int i = 0; i < DIMV; i++)
        {
            cout << numeriVincenti[i] << " ";
        }
        cout << endl;

        //! Controlla se il giocatore vuole finire la partita o ha finito il credito
        if (soldi == 0)
        {
            string risposta = "";
            cout << endl
                 << "Vuoi investire altri soldi? (si/no) ";
            cin >> risposta;
            if (risposta == "si" || risposta == "Si" || risposta == "SI")
            {
                cout << "Quanti ne vuoi investire ";
                cin >> soldi;
            }
            else if (risposta == "no" || risposta == "No" || risposta == "NO")
            {
                stop = true;
                cout << "Grazie e arrivederci" << endl;
            }
            else
            {
                stop = true;
                cout << "Grazie e arrivederci" << endl;
            }
        }
        else
        {
            string risposta = "";
            cout << endl
                 << "Vuoi scommettere di nuovo (si/no) ";
            cin >> risposta;
            if (risposta == "si" || risposta == "Si" || risposta == "SI")
            {
                stop = false;
            }
            else if (risposta == "no" || risposta == "No" || risposta == "NO")
            {
                cout << "Grazie e arrivederci" << endl;
                stop = true;
            }
            else
            {
                stop = true;
                cout << "Grazie e arrivederci" << endl;
            }
        }
    }

    system("pause");
    return 0;
}