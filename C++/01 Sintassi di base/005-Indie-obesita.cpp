#include <iostream>
using namespace std;

int main()
{

    int numeroPersone, numeroObesi = 0;

    float peso, altezza, indiceObs, K = 30;

    cout << "Scrivi quante persone eseguono la prova ";
    cin >> numeroPersone;

    for (int i = 0; i < numeroPersone; i++)
    {

        cout << "Inserisci il peso del " << i + 1 << " indiviuduo (kg) ";
        cin >> peso;

        cout << "Inserisci l'altezza del " << i + 1 << " indiviuduo (cm) ";
        cin >> altezza;

        indiceObs = peso / ((altezza / 100) * (altezza / 100));

        cout << "il tuo indice di obesita' e' pari a " << indiceObs << "." << endl;

        if (indiceObs > K)
        {
            numeroObesi += 1;
        }
    }

    cout << "Il numero di obesi che hanno partecipato e' pari a: " << numeroObesi << ".";

    return 0;
}