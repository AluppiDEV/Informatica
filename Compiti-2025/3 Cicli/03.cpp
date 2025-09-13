#include <iostream>
#include "../../Librerie/utilities.h"
using namespace std;

int main(int argc, char const *argv[])
{

    int numero;

    cout << "Inserisci il numero di quale vuoi sapere i numeri precedenti\n : ";
    cin >> numero;

    for (int i = numero - 1; i > 0; i--)
    {
        if ((i + 1) % 2 == 0)
        {
            cout << "- " << i + 1 << endl;
        }
    }

    return 0;
}
