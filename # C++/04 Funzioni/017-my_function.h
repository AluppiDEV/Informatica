#include <iostream>
using namespace std;
char apice = static_cast<char>(248), a = static_cast<char>(133), e = static_cast<char>(138);
/**
 *! Scrivere le librerie di funzioni per il calcolo di area e perimetro di alcune figure geometriche di b.
 *! Quadrato, rettangolo, cerchio e triangolo
 *! Le funzioni saranno 8, chiaramente una per il perimetro e una per l'area
 *! II main, attraverso un menu, le richiamerå opportunamente a seconda della richiesta dell 'utente
 */

int mostraMenu() {
    int scelta;
    cout << "\n== Menu Calcolo Area e Perimetro ==\n";
    cout << "1. Quadrato\n";
    cout << "2. Rettangolo\n";
    cout << "3. Cerchio\n";
    cout << "4. Triangolo\n";
    cout << "0. Esci\n";
    cout << ": ";
    cin >> scelta;
    return scelta;
}

//! Funzioni per l'inserimento dei dati
double leggiLato() {
    double l;
    cout << "Lato: ";
    cin >> l;
    return l;
}

double leggiBaseAltezza() {
    double b, h;
    cout << "Base: ";
    cin >> b;
    cout << "Altezza: ";
    cin >> h;
    return b, h;
}

double leggiRaggio() {
    double r;
    cout << "Raggio: ";
    cin >> r;
    return r;
}

double leggiLatiTriangolo() {
    double a, b, c;
    cout << "Lato 1: ";
    cin >> a;
    cout << "Lato 2: ";
    cin >> b;
    cout << "Lato 3: ";
    cin >> c;
    return a, b, c;
}

double PI = 3.141592653589793;

//! Funzioni di calcolo dei lati
double areaQuadrato(double lato) {
    return lato * lato;
}

double areaRettangolo(double base, double altezza) {
    return base * altezza;
}

double areaCerchio(double raggio) {
    return PI * raggio * raggio;
}

double areaTriangolo(double base, double altezza) {
    return 0.5 * base * altezza;
}

//! Funzioni calcolo dei perimetri
double perimetroQuadrato(double lato) {
    return 4 * lato;
}

double perimetroRettangolo(double base, double altezza) {
    return 2 * (base + altezza);
}

double perimetroCerchio(double raggio) {
    return 2 * PI * raggio;
}

double perimetroTriangolo(double lato1, double lato2, double lato3) {
    return lato1 + lato2 + lato3;
}