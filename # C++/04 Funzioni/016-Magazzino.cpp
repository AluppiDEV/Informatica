#include <iostream>
#include "016-my_function.h"
#define DIM 100
using namespace std;

int main()
{

	string nomi[DIM];
	int qty[DIM];
	int scelta;
	int numProdotti = 0;

	do
	{

		cout << "\n=== MENU GESTIONE MAGAZZINO ===\n";
		cout << "1. Aggiungi nuovo prodotto\n";
		cout << "2. Effettua una vendita\n";
		cout << "3. Aggiungi scorte a prodotto\n";
		cout << "4. Mostra dettagli prodotto\n";
		cout << "5. Verifica disponibilit" << a << " prodotto\n";
		cout << "6. Esci\n";
		cout << ": ";
		cin >> scelta;

		switch (scelta)
		{
		case 1:
			clear();
			addProducts(nomi, qty, numProdotti);
			break;
		case 2:
			clear();
			sell(nomi, qty, numProdotti);
			break;
		case 3:
			clear();
			add(nomi, qty, numProdotti);
			break;
		case 4:
			clear();
			show(nomi, qty, numProdotti);
			break;
		case 5:
			cout << "Not yet implemented!" << endl;
			/* code */
			break;
		case 6:
			cout << "Arrivedeci!" << endl;
			break;
		default:
			cout << "Scelta non valida." << endl;
			break;
		}

	} while (scelta != 6);

	system("pause");
	return 0;
}