#include <iostream>
#include <cmath>
using namespace std;

bool CalcolaRadici(double a, double b, double c, double *x1, double *x2);

int main()
{
    system("clear");
    double a, b, c, x1, x2;

    cout << "Inserisci i tre valori della equazione: ";
    cin >> a >> b >> c;

    if (a == 0)
    {
        cout << "L'equazione non e' di secondo grado." << endl;
    }
    else if (CalcolaRadici(a, b, c, &x1, &x2))
    {
        cout << "Soluzioni x1=" << x1 << ", x2=" << x2 << endl;
    }
    else
    {
        cout << "Soluzioni non reali." << endl;
    }

    return 0;
}

bool CalcolaRadici(double a, double b, double c, double *x1, double *x2)
{
    double delta = pow(b, 2) - (4 * a * c);
    if (delta < 0)
    {
        return false;
    }
    *x1 = (-b + sqrt(delta)) / (2 * a);
    *x2 = (-b - sqrt(delta)) / (2 * a);
    return true;
}