#include <iostream>
#include "../../Librerie/luppi.h"
#include "../../Librerie/sort.h"
#define DIM	100
using namespace std;

/**
**Gestire:
**
**- inserimento di un nuovo piatto con nome e prezzo.
**
**- ricerca del prezzo dato il nome di un piatto
**
**Tenere il menu ordinato alfabeticamente in modo da poter usare un algoritmo di ricerca dicotomica
*/


class Ristorante {
	private:
	int nPiatti;
	public:
	void setNPiatti(string string[]) {
		this->nPiatti = 0;
		for (int i=0 ; i<DIM ; i++) {
			if (string[i] != "") {
				this->nPiatti++;
			}
		}
	}
	void inserisciPiatto(string nome[], double prezzo[]);
	int cercaPrezzo(string nome[]);
};

int main() {

	string piatti[DIM] = {"Pizza", "Pasta", "Risotto", "Gelato", "Tiramisu"};
	double prezzi[DIM] = {8.5, 7.0, 9.5, 4.0, 5.5};
	int scelta;

	Ristorante ristorante;
	ristorante.setNPiatti(piatti);

	while (true) {
		showMenu({"Inserisci piatto", "Cerca prezzo"}, &scelta);
		switch (scelta) {
			case 1:
			ristorante.inserisciPiatto(piatti, prezzi);
			break;
			
			case 2:
			int indice = ristorante.cercaPrezzo(piatti);
			(indice != -1) ? cout << "Il prezzo del piatto e' " << prezzi[indice] << endl : cout << "Piatto non trovato\n";
			system("pause");
			break;
		}
	}

	return 0;
}

void Ristorante::inserisciPiatto(string nome[], double prezzo[]) {
	cout << "Inserisci il nome del piatto\n: ";
	string nomePiatto;
	cin >> nomePiatto;
	
	cout << "Inserisci il prezzo del piatto\n: ";
	double prezzoPiatto;
	cin >> prezzoPiatto;
	
	nome[nPiatti] = nomePiatto;
	prezzo[nPiatti] = prezzoPiatto;
	nPiatti++;
	selectionSort(nome, prezzo);
	updateAnimation(3);
	cout << "Piatto inserito con successo\n";
}

int Ristorante::cercaPrezzo(string nome[]) {
	int index = -1;
	int start = 0, end = nPiatti - 1, mid = start + (end - start) / 2;
	
	vector<string> menuItems(nome, nome + nPiatti);
	showMenu(menuItems);
	cout << "Inserisci il nome del piatto\n: ";
	string nomePiatto;
	cin >> nomePiatto;
	
	while (start <= end) {
		if (nomePiatto == nome[mid]) {
			index = mid;
			break;
		}
		else if (nomePiatto[0] < nome[mid][0]) {
			end = mid - 1;
		}
		else {
			start = mid + 1;
		}
		mid = start + (end - start) / 2;
	}
	return index;
}