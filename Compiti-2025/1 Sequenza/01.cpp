#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{

    float area, base, altezza, perimetro;

    cout << "Inserisi l'area\n :";
    cin >> area;
    cout << "Inserisi la base\n :";
    cin >> base;

    altezza = area / base;

    perimetro = (area*2) + (altezza*2);

    cout << "Il perimtro del rettangolo e di: " << perimetro << endl;

    return 0;

}