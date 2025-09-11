#include <iostream>
#include "../../Librerie/utilities.h"
using namespace std;

//* 2. Costruire un vettore di N posizioni, inserendo in ogni elemento il valore del suo indice.

int main(int argc, char const *argv[])
{
    int dim;

    cout << "Inserisci la lunchezza del vettore\n : ";
    cin >> dim;

    int arr[dim];

    for (size_t i = 0; i < dim; i++)
    {
        arr[i] = i;
    }

    cout << "Risultato finale" << endl;

    for (size_t i = 0; i < dim; i++)
    {
        cout << arr[i];
    }

    return 0;
}
