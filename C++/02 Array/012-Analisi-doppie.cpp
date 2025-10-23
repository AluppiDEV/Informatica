//? data una stringa immessa da tastiera determinare se essa contiene almeno una doppia (due caratteri uguali consecutivi)
#include <iostream>
#define DIM 15
using namespace std;

int main()
{

    char parola[DIM];
    bool doppia = false;

    cout << "Inserire una parola di massimo " << DIM - 1 << " caratteri ";
    cin >> parola;

    for (int i = 0; i < DIM; i++)
    {

        if (parola[i + 1] == parola[i])
        {
            doppia = true;
        }
    }

    if (doppia = true)
    {
        cout << "Nella parola " << parola << " e' presente almeno una doppia." << endl;
    }

    system("pause");
    return 0;
}