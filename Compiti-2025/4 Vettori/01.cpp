#include <iostream>
#include "../../Librerie/utilities.h"
using namespace std;

//* 1. Costruire un vettore di N elementi con valori letti da tastiera.

int main(int argc, char const *argv[])
{
    int dim;

    cout << "Inserisci la lunchezza del vettore\n : ";
    cin >> dim;

    int arr[dim];

    for (size_t i = 0; i < dim; i++)
    {
        cout << "Inserisci il valore per il " << i + 1 << apice << "numero\n : ";
        cin >> arr[i];
    }

    cout << "Risultato finale" << endl;

    for (size_t i = 0; i < dim; i++)
    {
        cout << arr[i];
    }

    return 0;
}
