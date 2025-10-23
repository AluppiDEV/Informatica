#include <iostream>
#define DIM 10
using namespace std;

int main()
{

    float all[DIM]{0}, pari = 0, dispari = 0, mediaPari = 0, mediaDispari = 0;

    for (int i = 0; i < DIM; i++)
    {
        cout << "Scrivi il " << i + 1 << " numero della lista ";
        cin >> all[i];
    }

    for (int i = 0; i < DIM; i++)
    {
        if (i % 2 == 0)
        {
            pari += all[i];
        }
        else
        {
            dispari += all[i];
        }
    }

    mediaPari = pari / (DIM / 2);
    mediaDispari = dispari / (DIM / 2);

    cout << endl;
    cout << "La lista dei numeri" << endl;
    for (int i = 0; i < DIM; i++)
    {
        cout << all[i] << ", ";
    }
    cout << endl;
    cout << "La media dei numeri pari e' " << mediaPari << endl;
    cout << "La media dei numeri dispari e' " << mediaDispari << endl;

    cout << endl;
    if (mediaDispari > mediaPari)
    {
        cout << "La media maggiore e' quella dispari" << endl;
    }
    else if (mediaPari > mediaDispari)
    {
        cout << "La media maggiore e' quella pari" << endl;
    }
    else if (mediaDispari == mediaPari)
    {
        cout << "Le medie sono uguali" << endl;
    }
    cout << endl;

    system("pause");
    return 0;
}