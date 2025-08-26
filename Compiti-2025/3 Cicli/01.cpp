#include <iostream>
#include "../../Librerie/utilities.h"
using namespace std;

int main(int argc, char const *argv[])
{

    int numeriDaStampare;

    cout << "Inserisci quanti numeri vanno stampati\n : ";
    cin >> numeriDaStampare;

    for (int i = 0; i < numeriDaStampare; i++)
    {
        cout << "- " << i+1 << endl;
    }

    return 0;
}
