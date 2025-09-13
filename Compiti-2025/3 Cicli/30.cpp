/*
 * Date N numero di coppie determinare
 * quante sono concordi e quante sono discordi
 */

#include <iostream>
#include "../../Librerie/utilities.h"
using namespace std;

int main(int argc, char const *argv[])
{
    int nCoppie = 0, nConcordi = 0, nDiscordi = 0;
    int ins1, ins2;

    cout << "Inserisci il numero di coppie\n : ";
    cin >> nCoppie;

    for (int i = 0; i < nCoppie; i++)
    {
        cout << "Inserisci il primo numero facente parte della coppia\n : ";
        cin >> ins1;

        cout << "Inserisci il secondo numero facente parte della coppia\n : ";
        cin >> ins2;

        if (ins1 == ins2)
        {
            nConcordi++;
        }
        else
        {
            nDiscordi++;
        }
    }

    cout << "Il numero di coppie " << e << " " << nCoppie << "," << endl;
    cout << "le coppie concordi sono" << nConcordi << "," << endl;
    cout << "in fine le coppie discodi sono " << nDiscordi << ".";

    return 0;
}
