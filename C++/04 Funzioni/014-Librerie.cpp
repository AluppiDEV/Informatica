#include <iostream>
#define MAX_PRODOTTI 100
using namespace std;

const char euro = static_cast<char>(156);

void aggiungiProdotto(string nomi[], int anni[], double prezzi[], int &numLibri);

void aggiungiProdotti(string nomi[], int anni[], double prezzi[], int &numLibri);

void listaProdotti(string nomi[], int anni[], double prezzi[], int &numLibri);

void ricercaNome(string nomi[], int anni[], double prezzi[], int &numLibri);

void ricercaAnno(string nomi[], int anni[], double prezzi[], int &numLibri);

void ricercaAnnoUguale(string nomi[], int anni[], double prezzi[], int &numLibri);

void rimuoviLibro(int &id, string nomi[], int anni[], double prezzi[], int &numLibri);

void fillEmpty(int &id, string nomi[], int anni[], double prezzi[], int &numLibri);

void stampa(int id, string nomi[], double prezzi[], int anni[]);

void stampaPagine(string nomi[], double prezzi[], int anni[], int &numLibri);

double calcolaMedia(double prezzi[], int numLibri);

int main()
{

    system("cls");
    string nomi[MAX_PRODOTTI] = {"Penna", "Matita", "Quaderno", "Gomma", "Riga", "Temperamatite", "Pennarello", "Cartella", "Libro", "Taccuino"};
    double prezzi[MAX_PRODOTTI] = {1.50, 0.80, 3.00, 0.50, 1.20, 2.50, 2.00, 15.00, 10.00, 5.00};
    int anni[MAX_PRODOTTI] = {2020, 2019, 2021, 2018, 2022, 2023, 2020, 2024, 2017, 2016};
    int numLibri = 10;
    int scelta;
    int indice;

    do
    {
        cout << "\n1. Aggiungi prodotto\n2. Aggiungi prodotti\n3. Lista prodotti\n4. Calcola media\n5. Ricerca libro per nome\n6. Ricerca libri da un'anno\n7. Elimina libro\n8. \n9. Esci\n: ";
        cin >> scelta;

        switch (scelta)
        {
        case 1:
            aggiungiProdotto(nomi, anni, prezzi, numLibri);
            break;
        case 2:
            aggiungiProdotti(nomi, anni, prezzi, numLibri);
            break;
        case 3:
            listaProdotti(nomi, anni, prezzi, numLibri);
            break;
        case 4:
            cout << "Media totale: " << calcolaMedia(prezzi, numLibri) << euro << "\n";
            break;
        case 5:
            ricercaNome(nomi, anni, prezzi, numLibri);
            break;
        case 6:
            ricercaAnno(nomi, anni, prezzi, numLibri);
            break;
        case 7:
            rimuoviLibro(indice, nomi, anni, prezzi, numLibri);
            break;
        case 8:
            stampaPagine(nomi, prezzi, anni, numLibri);
            break;
        case 9:
            cout << "Arrivederci!\n";
            break;
        default:
            cout << "Scelta non valida!\n";
        }
    } while (scelta != 9);

    system("pause");
    return 0;
}

void aggiungiProdotto(string nomi[], int anni[], double prezzi[], int &numLibri)
{

    if (numLibri >= MAX_PRODOTTI)
    {
        cout << "Limite massimo prodotti raggiunto!\n";
    }
    else
    {

        cin.ignore();
        cout << "Inserisci il nome del libro: ";
        getline(cin, nomi[numLibri]);

        cout << "Inserisci prezzo prodotto: ";
        cin >> prezzi[numLibri];

        cout << "Inserisci anno di pubblicazione prodotto: ";
        cin >> anni[numLibri];

        numLibri++;
        cout << "Prodotto aggiunto!\n";
    }
}

void aggiungiProdotti(string nomi[], int anni[], double prezzi[], int &numLibri)
{

    int n;
    cout << "Quanti libri vuoi inseire?\n: ";
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        aggiungiProdotto(nomi, anni, prezzi, numLibri);
    }
}

void listaProdotti(string nomi[], int anni[], double prezzi[], int &numLibri)
{

    if (numLibri == 0)
    {
        cout << "Nessun libro presente!\n";
    }
    else
    {

        cout << "Elenco prodotti:\n";
        for (int i = 0; i < numLibri; i++)
        {
            stampa(i, nomi, prezzi, anni);
        }
    }
}

double calcolaMedia(double prezzi[], int numLibri)
{
    double totale = 0;
    double media = 0;
    for (int i = 0; i < numLibri; i++)
    {
        totale += prezzi[i];
    }

    media = totale / numLibri;

    return media;
}

void ricercaNome(string nomi[], int anni[], double prezzi[], int &numLibri)
{

    if (numLibri == 0)
    {
        cout << "Nessun libro presente!\n";
    }
    else
    {

        string nome;
        cout << "Inserisci il nome del libro da cercare\n: ";
        cin >> nome;

        cout << "Elenco prodotti con il nome " << nome << ":\n";
        for (int i = 0; i < numLibri; i++)
        {
            if (nome == nomi[i])
            {
                stampa(i, nomi, prezzi, anni);
            }
        }
    }
}

void ricercaAnno(string nomi[], int anni[], double prezzi[], int &numLibri)
{

    if (numLibri == 0)
    {
        cout << "Nessun libro presente!\n";
    }
    else
    {

        int anno;
        cout << "Inserisci l'anno da cui partire a cercare\n: ";
        cin >> anno;

        cout << "Elenco prodotti dall'anno " << anno << ":\n";
        for (int i = 0; i < numLibri; i++)
        {
            if (anno <= anni[i])
            {
                stampa(i, nomi, prezzi, anni);
            }
        }
    }
}

void ricercaAnnoUguale(string nomi[], int anni[], double prezzi[], int &numLibri)
{

    if (numLibri == 0)
    {
        cout << "Nessun libro presente!\n";
    }
    else
    {

        int anno;
        cout << "Inserisci l'anno da cercare\n: ";
        cin >> anno;

        cout << "Elenco prodotti dell'anno " << anno << ":\n";
        for (int i = 0; i < numLibri; i++)
        {
            if (anno == anni[i])
            {
                stampa(i, nomi, prezzi, anni);
            }
        }
    }
}

void ricercaPrezzoUguale(string nomi[], int anni[], double prezzi[], int &numLibri)
{

    if (numLibri == 0)
    {
        cout << "Nessun libro presente!\n";
    }
    else
    {

        double prezzo;
        cout << "Inserisci il prezzo da cercare\n: ";
        cin >> prezzo;

        cout << "Elenco prodotti con prezz " << prezzo << ":\n";
        for (int i = 0; i < numLibri; i++)
        {
            if (prezzo == prezzi[i])
            {
                stampa(i, nomi, prezzi, anni);
            }
        }
    }
}

void rimuoviLibro(int &id, string nomi[], int anni[], double prezzi[], int &numLibri)
{

    if (numLibri == 0)
    {
        cout << "Nessun libro presente!\n";
    }
    else
    {

        id = -1;
        string nome;
        cout << "Inserisci il nome del libro da eliminare\n: ";
        cin >> nome;

        for (int i = 0; i < numLibri; i++)
        {
            if (nome == nomi[i])
            {
                id = i;
            }
        }

        if (id != -1)
        {
            fillEmpty(id, nomi, anni, prezzi, numLibri);
        }
    }
}

void fillEmpty(int &id, string nomi[], int anni[], double prezzi[], int &numLibri)
{
    for (int i = id; i < numLibri; i++)
    {
        nomi[i] = nomi[i + 1];
        anni[i] = anni[i + 1];
        prezzi[i] = prezzi[i + 1];
    }

    numLibri--;
    cout << "Prodotto rimosso!\n";
}

void stampa(int id, string nomi[], double prezzi[], int anni[])
{
    cout << id + 1 << ") " << nomi[id] << " - " << prezzi[id] << " " << euro << " - " << anni[id] << "\n";
}

void stampaPagine(string nomi[], double prezzi[], int anni[], int &numLibri)
{

    if (numLibri == 0)
    {
        cout << "Nessun libro presente!\n";
    }
    else
    {

        cout << "Pagine disponibili: \n";
        for (int i = 0; i < numLibri; i += 5)
        {
            cout << (i / 5) + 1 << " ";
        }

        int idPag;
        cout << "\nInserisci la pagina da cercare\n: ";
        cin >> idPag;

        for (int i = (idPag * 5) - 5; i < idPag * 5; i++)
        {
            stampa(i, nomi, prezzi, anni);
        }
    }
}