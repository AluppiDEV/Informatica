// Calcolare la somma dei primi N numeri pari successivi ad un valore fornito da tastiera
#include <iostream>
using namespace std;

int main()
{

    int numero, numeroSomme, numeroPari, somma;

    cout << "Scrivi qua sotto di quale numero vuoi sapere i succesivi pari ";
    cin >> numero;

    cout << "Scrivi quanti numeri pari vuoi sapere ";
    cin >> numeroSomme;

    if (numero % 2 == 0)
    {
        numeroPari = numero + 2;
    }
    else
    {
        numeroPari = numero + 1;
    }

    for (int i = 0; i < numeroSomme - 1; i++)
    {
        somma = somma + numeroPari;
        numeroPari = numeroPari + 2;
    }

    cout << "Ecco la somma dei primi " << numeroSomme << " numeri pari successivi a " << numero << " -> " << somma << ".";

    return 0;
}