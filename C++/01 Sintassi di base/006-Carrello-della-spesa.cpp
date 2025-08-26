#include <iostream>
#include <cstdlib>
using namespace std;

int main()
{

    int numeroProdotti;
    float prezzo, totale = 0, totaleScontato;

    cout << "Inserisci quanti prodotti hai acquistato ";
    cin >> numeroProdotti;

    for (int i = 0; i < numeroProdotti; i++)
    {
        cout << "Inserisci il prezzo del " << i + 1 << " prodotto ";
        cin >> prezzo;
        totale += prezzo;
    }

    if (totale >= 400)
    {
        totaleScontato = totale - (totale * 0.2);
        cout << "Hai diritto allo sconto 20% sul totale di " << totale << endl;
    }
    else if (totale >= 200)
    {
        totaleScontato = totale - (totale * 0.1);
        cout << "Hai diritto allo sconto 10% sul totale di " << totale << endl;
    }
    else
    {
        totaleScontato = totale;
    }

    cout << "Il totale da pagare e' di " << totaleScontato << "." << endl;

    system("pause");
    return 0;
}