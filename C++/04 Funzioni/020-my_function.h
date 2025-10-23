#include <algorithm>
#include <iostream>
#include <cstdlib>
#include <ctime>
char apice = static_cast<char>(248), a = static_cast<char>(133), e = static_cast<char>(138);
#define MAX_SIZE 5
using namespace std;

// Funzione per verificare se un indice è già presente
bool indicePresente(const int indici[], int dimensione, int indice)
{
    for (int i = 0; i < dimensione; ++i)
    {
        if (indici[i] == indice)
        {
            return true;
        }
    }
    return false;
}

// Funzione per inizializzare il magazzino con dati casuali
void inizializzaMagazzinoRandom(int indici[], int quantita[], int &dimensione)
{
    srand(time(0)); // Inizializza il generatore di numeri casuali

    dimensione = MAX_SIZE; // Genera una dimensione casuale

    for (int i = 0; i < dimensione; ++i)
    {
        do
        {
            indici[i] = rand() % (MAX_SIZE * 2); // Genera un indice casuale
        } while (indicePresente(indici, i, indici[i])); // Verifica duplicati

        quantita[i] = rand() % 100; // Genera una quantità casuale
    }
}

// Funzione per stampare il contenuto del magazzino
void stampaMagazzino(const int indici[], const int quantita[], int dimensione)
{
    cout << "Magazzino:\n";
    for (int i = 0; i < dimensione; ++i)
    {
        cout << "Indice: " << indici[i] << ", Quantit" << a << ": " << quantita[i] << endl;
    }
}

// Funzione per ottenere la cifra in una posizione specifica
int getCifra(int numero, int posizione)
{
    for (int i = 0; i < posizione; ++i)
    {
        numero /= 10;
    }
    return numero % 10;
}

// Selection sort per ordinare per indice
void selectionSortIndice(int indici[], int quantita[], int dimensione)
{
    for (int i = 0; i < dimensione - 1; ++i)
    {
        int minIndex = i;
        for (int j = i + 1; j < dimensione; ++j)
        {
            if (indici[j] < indici[minIndex])
            {
                minIndex = j;
            }
        }
        swap(indici[i], indici[minIndex]);
        swap(quantita[i], quantita[minIndex]); // Mantiene la corrispondenza
    }
}

// Selection sort per ordinare per quantità
void selectionSortQuantita(int indici[], int quantita[], int dimensione)
{
    for (int i = 0; i < dimensione - 1; ++i)
    {
        int minIndex = i;
        for (int j = i + 1; j < dimensione; ++j)
        {
            if (quantita[j] < quantita[minIndex])
            {
                minIndex = j;
            }
        }
        swap(quantita[i], quantita[minIndex]);
        swap(indici[i], indici[minIndex]); // Mantiene la corrispondenza
    }
}