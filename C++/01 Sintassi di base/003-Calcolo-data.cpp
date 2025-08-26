#include <iostream>
using namespace std;

int main()
{
    int anno, mese, giorno;
    int numeroGiorni;

    cout << "Scrivi una data nella forma (giorno, mese, anno)" << endl;
    cout << "Giorno ";
    cin >> giorno;

    cout << "Mese ";
    cin >> mese;

    cout << "Anno ";
    cin >> anno;

    if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12)
    {
        numeroGiorni = 31;
    }
    else if (mese == 4 || mese == 6 || mese == 9 || mese == 11)
    {
        numeroGiorni = 30;
    }
    else if (mese == 2)
    {
        if (anno % 4 == 0 && (anno % 100 != 0 || anno % 400 == 0))
        {
            numeroGiorni = 29;
        }
        else
        {
            numeroGiorni = 28;
        }
    }

    if (giorno + 1 > numeroGiorni)
    {
        giorno = 1;
        if (mese + 1 > 12)
        {
            mese = 1;
            anno = anno + 1;
        }
        else
        {
            mese = mese + 1;
        }
    }
    else
    {
        giorno = giorno + 1;
    }

    cout << "La data del giorno successivo sara' " << giorno << "/" << mese << "/" << anno << ".";
}