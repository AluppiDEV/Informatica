#include <iostream>
#define DIM 14

using namespace std;

struct Giocatore
{
    string nome;  // Nome giocatore
    string ruolo; // Ruolo del giocatore
    int punti;    // Numero di punti segnati
};

void printErr();
void addPlayer(Giocatore arr[], int index);
void printPlayer(Giocatore arr[]);
void ordinamentoPunti(Giocatore arr[], int dim);
void ordinamentoNomi(Giocatore arr[], int dim);
void ordinamentoRuolo(Giocatore arr[], int dim);
int ricercaNome(Giocatore arr[], int start, int end, string x);

int main(int argc, char const *argv[])
{
    Giocatore squadra[DIM];
    int choice;

    do
    {
        // Menu
        cout << "Scegli l'azione da eseguire:\n";
        cout << "1 - Inserire un nuovo giocatore" << endl
             << "2 - Stampare l'elenco dei giocatori" << endl
             << "3 - Ordinare per gol segnati" << endl
             << "4 - Cercare un giocatore per nome" << endl
             << "5 - Ordinare per ruolo" << endl
             << "6 - Uscire dal programma" << endl;
        cin >> choice;

        system("cls");
        switch (choice)
        {
        case 1:
        {
            int choice;

            cout << "Bevenuto nell'inserimento dati dei giocatori" << endl;
            cout << "Scegi:\n- inserire dati per un singolo giocatore (1) \n- Insreire dati per tutti i giocatori (2)";
            cin >> choice;

            if (choice == 1)
            {
                int choice;
                cout << "Scegli il giocatore da aggiungere (1-14)";
                cin >> choice;
                addPlayer(squadra, choice);
            }
            else if (choice == 2)
            {
                for (size_t i = 0; i < DIM; i++)
                {
                    addPlayer(squadra, i);
                }
            }
            else
            {
                printErr();
            }
        }
        break;

        case 2:
        {
            printPlayer(squadra);
        }

        case 3:
        {
            ordinamentoPunti(squadra, DIM);
            printPlayer(squadra);
        }

        case 4:
        {
            string search;
            cout << "Inserisci il nome da cercare\n : ";
            cin >> search;
            ordinamentoNomi(squadra, DIM);
            ricercaNome(squadra, 0, DIM, search);
        }

        case 5:
        {
            ordinamentoRuolo(squadra, DIM);
            printPlayer(squadra);
        }

        case 6:
        {
            cout << "Arrivederci";
        }

        default:
            printErr();
            break;
        }
    } while (choice == 6);

    return 0;
}

void printErr()
{
    cout << "Scelta non valida, riprova.";
}

void addPlayer(Giocatore arr[], int index)
{

    cout << "Inserisci il nome del giocatore " << index + 1 << "\n : ";
    cin >> arr[index].nome;

    cout << "Inserisci il ruolo del giocatore" << arr[index].nome << "\n : ";
    cin >> arr[index].ruolo;

    cout << "Inserisci i punti fatti da giocatore" << arr[index].nome << "\n : ";
    cin >> arr[index].punti;
}

void printPlayer(Giocatore arr[])
{
    string err = "Non inserito";
    for (size_t i = 0; i < DIM; i++)
    {
        cout << "Giocatore N" << i + 1 << endl
             << "Nome: " << (arr[i].nome != "" ? arr[i].nome : err) << endl
             << "Ruolo: " << (arr[i].ruolo != "" ? arr[i].ruolo : err) << endl
             << "Punti: " << (arr[i].punti != 0 ? arr[i].punti : 0) << endl;
    }
}

void ordinamentoPunti(Giocatore arr[], int dim)
{
    bool sentinel = true;
    int j = 0;
    do
    {
        sentinel = false;
        for (int i = 0; i < dim - 1 - j; i++)
        {
            if (arr[i].punti > arr[i + 1].punti)
            {
                swap(arr[i], arr[i + 1]);
                sentinel = true;
            }
        }
        j++;

    } while (j < (dim - 1) && sentinel);
}

void ordinamentoNomi(Giocatore arr[], int dim)
{
    bool sentinel = true;
    int j = 0;
    do
    {
        sentinel = false;
        for (int i = 0; i < dim - 1 - j; i++)
        {
            if (arr[i].nome > arr[i + 1].nome)
            {
                swap(arr[i], arr[i + 1]);
                sentinel = true;
            }
        }
        j++;

    } while (j < (dim - 1) && sentinel);
}

void ordinamentoRuolo(Giocatore arr[], int dim)
{
    bool sentinel = true;
    int j = 0;
    do
    {
        sentinel = false;
        for (int i = 0; i < dim - 1 - j; i++)
        {
            if (arr[i].ruolo > arr[i + 1].ruolo)
            {
                swap(arr[i], arr[i + 1]);
                sentinel = true;
            }
        }
        j++;

    } while (j < (dim - 1) && sentinel);
}

int ricercaNome(Giocatore arr[], int start, int end, string x)
{
    int mid = (start + end) / 2;

    if (arr[mid].nome == x)
    {
        return mid;
    }
    else if (start >= end)
    {
        return -1;
    }
    else if (arr[mid].nome < x)
    {
        return ricercaNome(arr, mid + 1, end, x);
    }
    else
    {
        return ricercaNome(arr, start, mid - 1, x);
    }
}