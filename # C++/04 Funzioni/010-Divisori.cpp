#include <iostream>
using namespace std;

int contaDivisori(int n);

int main()
{
    int n;
    cout << "Inserisci un numero naturale n: ";
    cin >> n;

    int d = contaDivisori(n);
    cout << "Il numero di divisori di n (" << n << ") e': " << d << endl;

    int divisori_d = contaDivisori(d);
    cout << "Il numero di divisori di d (" << d << ") e': " << divisori_d << endl;

    return 0;
}

int contaDivisori(int n)
{
    int count = 0;
    for (int i = 1; i <= n; ++i)
    {
        if (n % i == 0)
        {
            count++;
        }
    }
    return count;
}