// Media di N voti
#include <iostream>
using namespace std;

int main()
{

    int numeroVoti, voti, somma, media;

    cout << "Quanti voti andrai ad inserire ? ";
    cin >> numeroVoti;

    somma = 0;

    for (int i = 0; i < numeroVoti - 1; i++)
    {
        cout << "Scrivi il " << i + 1 << " voto ";
        cin >> voti;
        somma += voti;
    }

    media = somma / numeroVoti;

    cout << "La tua media e' di: " << media << ".";

    return 0;
}