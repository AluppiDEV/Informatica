#include <iostream>
#define MAX_PRODOTTI 100
using namespace std;

const char euro = static_cast<char>(156);

void aggiungiProdotto(string nomi[], double prezzi[], int &numProdotti);

void listaProdotti(string nomi[], double prezzi[], int &numProdotti);

void rimuoviProdotto(string nomi[], double prezzi[], int &numProdotti);

double calcolaTotale(double prezzi[], int numProdotti);

int main()
{

    system("cls");
    string nomi[MAX_PRODOTTI];
    double prezzi[MAX_PRODOTTI];
    int numProdotti = 0;
    int scelta;

    do
    {
        cout << "\n1. Aggiungi prodotto\n2. Lista prodotti\n3. Rimuovi prodotto\n4. Calcola totale\n5. Esci\n: ";
        cin >> scelta;

        switch (scelta)
        {
        case 1:
            aggiungiProdotto(nomi, prezzi, numProdotti);
            break;
        case 2:
            listaProdotti(nomi, prezzi, numProdotti);
            break;
        case 3:
            rimuoviProdotto(nomi, prezzi, numProdotti);
            break;
        case 4:
        {
            double totale = calcolaTotale(prezzi, numProdotti);
            cout << "Totale: " << totale << euro << "\n";
            break;
        }
        case 5:
            cout << "Arrivederci!\n";
            break;
        default:
            cout << "Scelta non valida!\n";
        }
    } while (scelta != 5);

    return 0;
}

void aggiungiProdotto(string nomi[], double prezzi[], int &numProdotti)
{

    if (numProdotti >= MAX_PRODOTTI)
    {
        cout << "Limite massimo prodotti raggiunto!\n";
    }
    else
    {

        cin.ignore();
        cout << "Inserisci nome prodotto: ";
        getline(cin, nomi[numProdotti]);

        cout << "Inserisci prezzo prodotto: ";
        cin >> prezzi[numProdotti];

        numProdotti++;
        cout << "Prodotto aggiunto!\n";
    }
}

void listaProdotti(string nomi[], double prezzi[], int &numProdotti)
{

    if (numProdotti == 0)
    {
        cout << "Nessun prodotto nel carrello!\n";
    }
    else
    {

        cout << "Elenco prodotti:\n";
        for (int i = 0; i < numProdotti; i++)
        {
            cout << i + 1 << ") " << nomi[i] << " - " << prezzi[i] << " " << euro << "\n";
        }
    }
}

void rimuoviProdotto(string nomi[], double prezzi[], int &numProdotti)
{

    if (numProdotti == 0)
    {
        cout << "Nessun prodotto da rimuovere!\n";
    }
    else
    {

        cout << "Elenco prodotti:\n";
        for (int i = 0; i < numProdotti; i++)
        {
            cout << i + 1 << ") " << nomi[i] << " - " << prezzi[i] << " " << euro << "\n";
        }

        int scelta;
        cout << "Inserisci numero prodotto da rimuovere: ";
        cin >> scelta;

        if (scelta < 1 || scelta > numProdotti)
        {
            cout << "Scelta non valida!\n";
        }
        else
        {
            for (int i = scelta - 1; i < numProdotti - 1; i++)
            {
                nomi[i] = nomi[i + 1];
                prezzi[i] = prezzi[i + 1];
            }
            numProdotti--;
            cout << "Prodotto rimosso!\n";
        }
    }
}

double calcolaTotale(double prezzi[], int numProdotti)
{
    double totale = 0;
    for (int i = 0; i < numProdotti; i++)
    {
        totale += prezzi[i];
    }

    if (totale > 100)
    {
        totale *= 0.8;
        cout << "Applicato sconto 20%!\n";
    }

    return totale;
}