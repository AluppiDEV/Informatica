#include <iostream>
#include <cmath>
using namespace std;

/**
 *? Scrivere una funzione che riceve in ingresso tre numeri interi h, m e s che rappresentano ore minuti e secondi e
 *? restituisce il numero di secondi trascorsi dalla mezzanotte. Scrivere poi un programma
 *? che usa questa funzione per calcolare i secondi trascorsi tra due orari entrambi contenuti entro il ciclo di una giornata.
 *? Ad esempio, se i due orari inseriti fossero 12:30:00 e 13:40:30 il programma dovrebbe  stampare:
 *? I secondi trascorsi tra i due orari sono: 4230
 */

int calcolaSecondi(int h, int m, int s);

int main()
{
    system("clear");
    int h1, m1, s1, h2, m2, s2, secondiOra1, secondiOra2;

    cout << "Inserisci il primo orario\n: ";
    cin >> h1 >> m1 >> s1;
    secondiOra1 = calcolaSecondi(h1, m1, s1);

    cout << "Inserisci il secondo orario\n: ";
    cin >> h2 >> m2 >> s2;
    secondiOra2 = calcolaSecondi(h2, m2, s2);

    cout << "La differenza di secondi tra le " << h1 << ":" << m1 << ":" << s1 << " e le " << h2 << ":" << m2 << ":" << s2 << " e' di " << secondiOra2 - secondiOra1 << endl;
    return 0;
}

int calcolaSecondi(int h, int m, int s)
{
    int somma = 0;
    somma += s;
    somma += m * 60;
    somma += h * 60 * 60;
    return somma;
}