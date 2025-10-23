#include <iostream>
#define DIM 10
using namespace std;

int main()
{

    char parola1[DIM] = {0}, parola2[DIM] = {0}, mix[DIM * 2] = {0};

    cout << "Inserisci la prima parola ";
    cin >> parola1;

    cout << "Inserisci la seconda parola ";
    cin >> parola2;

    int j = 0;
    for (int i = 0; i < (DIM * 2); i += 2)
    {
        mix[i] = parola1[j];
        mix[i + 1] = parola2[j];
        j++;
    }
    cout << endl;
    for (int i = 0; i < DIM * 2; i++)
    {
        cout << mix[i];
    }
    cout << endl;

    system("pause");
    return 0;
}