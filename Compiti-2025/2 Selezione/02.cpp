#include <iostream>
#include "../../Librerie/utilities.h"
using namespace std;

int main(int argc, char const *argv[])
{

    float n1, n2;

    cout << "Inserisci il primo numero\n : ";
    cin >> n1;

    cout << "Inserisci il secondo numero\n : ";
    cin >> n2;

    if (n1 > n2)
    {
        cout << "Il numero 1 (" << n1 << ") " << e << " maggiore.";
    }
    else
    {
        cout << "Il numero 2 (" << n2 << ") " << e << " maggiore.";
    }

    return 0;
}
