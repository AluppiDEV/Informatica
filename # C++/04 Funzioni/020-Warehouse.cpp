#include "020-my_function.h"
#include <iostream>
using namespace std;

int main()
{
  char apice = static_cast<char>(248), a = static_cast<char>(133), e = static_cast<char>(138);
  int indici[MAX_SIZE];
  int quantita[MAX_SIZE];
  int dimensione;

  inizializzaMagazzinoRandom(indici, quantita, dimensione);
  cout << "Magazzino iniziale:\n";
  stampaMagazzino(indici, quantita, dimensione);

  selectionSortIndice(indici, quantita, dimensione);
  cout << "\nMagazzino ordinato per indice:\n";
  stampaMagazzino(indici, quantita, dimensione);

  inizializzaMagazzinoRandom(indici, quantita, dimensione); // Reinizializza per ordinare per quantità
  selectionSortQuantita(indici, quantita, dimensione);
  cout << "\nMagazzino ordinato per quantit" << a << ":\n";
  stampaMagazzino(indici, quantita, dimensione);

  return 0;
}