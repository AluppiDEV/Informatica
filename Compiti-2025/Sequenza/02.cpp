#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{

    float perimetro, altezza, base, area;

    cout << "Inserisci il perimetro\n : ";
    cin >> perimetro;

    cout << "Inserisci l'altezza\n : ";
    cin >> altezza;

    base = (perimetro/2) - altezza;
    area = base * altezza;

    cout << "L'area del rettangolo e di: " << area << endl;

    return 0;
}
