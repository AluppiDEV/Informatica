#include <iostream>
using namespace std;

int main()
{

    int tondiniPPieno = 0, tondiniPRidotto = 0, tondiniTotale = 0;
    float prezzoTondini, sconto, diametro, totale;

    cout << "Inserisci il prezzo per il singlo tondino ";
    cin >> prezzoTondini;

    cout << endl
         << "Inserisci lo sconto per i tondini scontati ";
    cin >> sconto;
    sconto = sconto / 100;

    do
    {

        cout << "Inserisci il diametro del tondino (in mm) ";
        cin >> diametro;

        if (diametro >= 29.5 && diametro <= 30.5)
        {
            tondiniPPieno++;
            tondiniTotale++;
        }
        else if (diametro >= 29 && diametro <= 31)
        {
            tondiniPRidotto++;
            tondiniTotale++;
        }

    } while (tondiniTotale < 100);

    totale = tondiniPPieno * prezzoTondini + (tondiniPRidotto * (prezzoTondini - prezzoTondini * sconto));

    cout << endl
         << "Il totale da pagare per i tondini corrsponde a " << totale << endl;

    system("pause");
    return 0;
}