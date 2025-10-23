#include "017-my_function.h"
#include <iostream>
using namespace std;

int main() {
    int scelta;
    double lato, base, altezza, raggio, lato1, lato2, lato3;

    do {
        scelta = mostraMenu();

        switch (scelta) {
        case 1:
            lato = leggiLato();
            cout << "Area: " << areaQuadrato(lato) << endl;
        	cout << "Perimetro: " << perimetroQuadrato(lato) << endl;
            break;
        case 2:
            base, altezza = leggiBaseAltezza();
            cout << "Area: " << areaRettangolo(base, altezza) << endl;
            cout << "Perimetro: " << perimetroRettangolo(base, altezza) << endl;
            break;
        case 3:
            raggio = leggiRaggio();
            cout << "Area: " << areaCerchio(raggio) << endl;
            cout << "Perimetro: " << perimetroCerchio(raggio) << endl;
            break;
        case 4:
            lato1, lato2, lato3 = leggiLatiTriangolo();
            base, altezza = leggiBaseAltezza();
            cout << "Area: " << areaTriangolo(base, altezza) << endl;
            cout << "Perimetro: " << perimetroTriangolo(lato1, lato2, lato3) << endl;
            break;
        case 0:
            cout << "Arrivederci.\n";
            break;
        default:
            cout << "Scelta non valida. Riprova.\n";
        }
    } while (scelta != 0);

    return 0;
}