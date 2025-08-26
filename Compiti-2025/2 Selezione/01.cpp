#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n1, n2;

    cout << "Inserisci il primo intero\n : ";
    cin >> n1;
    cout << "Inserisci il secondo intero\n : ";
    cin >> n2;

    if (n1 == n2)
    {
        cout << "I numeri sono uguali!";
    }
    else
    {
        cout << "I numeri sono diversi!";
    }

    return 0;
}
