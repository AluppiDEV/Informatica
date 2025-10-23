//? data una parola inserita da tastiera determinare la sua lunghezza e il numero di vocali e consonanti che contiene
#include <iostream>
#define DIM 15
using namespace std;

int main()
{

    char parola[DIM];
    int nVocali = 0, nConsonanti = 0, nLettere = 0;

    cout << "Inserire una parola di massimo " << DIM - 1 << " caratteri ";
    cin >> parola;
    cout << endl;

    while (parola[nLettere] != '\0')
    {
        nLettere++;

        switch (parola[nLettere])
        {

        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':

        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':

            nVocali++;
            break;

        default:
            nConsonanti++;
            break;
        }
    }

    cout << "Ecco il numero totale di lettere: " << nLettere << ", il numero di vocali: " << nVocali << " e il numero di consonanti: " << nConsonanti << endl;

    system("pause");
    return 0;
}