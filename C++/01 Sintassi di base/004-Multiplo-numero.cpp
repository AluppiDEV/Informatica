// Stampare i primi N multipli di un numero.
#include <iostream>
using namespace std;

int main()
{

    int numeroMultipli, numero, multipli;

    cout << "Scrivi il numero di cui vuoi sapere i multipli ";
    cin >> numero;

    cout << "Scrivi quanti multipli vuoi sapere ";
    cin >> numeroMultipli;

    for (int i = 0; i < numeroMultipli; i++)
    {
        multipli = numero * (i + 1);
        cout << multipli << endl;
    }

    return 0;
}