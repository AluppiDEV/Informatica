#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    float totPrice, lOlio, priceOlio, priceFilterAria, priceFilterOlio, priceFilterAriaCondizionata, nPastiglie, priceFreni;

    cout << "== Benvenuto nella revisione ==" << endl;
    cout << "Inserisci i litri di olio utilizzati\n : ";
    cin >> lOlio;

    cout << "Inserisci il prezzo dell'olio\n : ";
    cin >> priceOlio;

    cout << "Inserisci il prezzo del filtro dell'aria\n : ";
    cin >> priceFilterAria;

    cout << "Inserisci il prezzo del fltro dell'olio\n : ";
    cin >> priceFilterOlio;

    cout << "Inserisci il prezzo del fltro dell'aria condizionata\n : ";
    cin >> priceFilterAriaCondizionata;

    cout << "Inserisci la quantita di pastigie dei freni cambiate\n : ";
    cin >> nPastiglie;

    cout << "Inserisci il prezzo del della singla pastiglia dei freni\n : ";
    cin >> priceFreni;

    totPrice = (lOlio*priceOlio) + priceFilterAria + priceFilterOlio + priceFilterAriaCondizionata + (nPastiglie*priceFreni);

    cout << "Viene applicato lo sconto del 5%" << endl;
    cout << "Il prezzo totale ammonta a: " << totPrice << endl;

    return 0;
}
