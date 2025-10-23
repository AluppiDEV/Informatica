#include <iostream>
#include <luppi.h>
#define MAX_PRODUCT 100
using namespace std;

struct Librerie {
	/* data */
	string title;
	string autor;
	int qty;
	bool available;
	int lent;
};

void pause() {system("pause");}
void aggiungiProdotto(Librerie libro[], int &nLibri);
void prendiInPrestito(Librerie libro[], int nLibri);
void restituisciLibro(Librerie libro[], int nLibri);
void showBook(Librerie libro[], int nLibri);
void ricercaLibro(Librerie libro[], int nLibri, string titolo);

int main() {

    system("cls");

	Librerie libro[MAX_PRODUCT];
	int scelta;
	int nLibri=0;
    
    do {
		showMenu({
			"Aggiungi prodotto",
			"Prendi in prestito un libro",
			"Restituisci un libro",
			"Visualizza tutti i libri presenti",
			"Ricerca libro per nome",
			"Esci"
		}, &scelta);
        
        switch(scelta) {
            case 1:
				/*Aggiungi prodotto*/
                aggiungiProdotto(libro, nLibri);
                break;
            case 2:
				/*Prendi in prestit*/
				prendiInPrestito(libro, nLibri);
				pause();
				break;
            case 3:
				/*Restituisc libro*/
				restituisciLibro(libro, nLibri);
				pause();
				break;
            case 4:
				/*Lista libri*/
				showBook(libro, nLibri);
				pause();
				break;
			case 5: {
				/*Ricerca libro per nome*/
				cout<<"Inserisci il nome del libro che vuoi cercare\n: ";
				string titolo;
				cin>>titolo;
				ricercaLibro(libro, nLibri, titolo);
				pause();
				break;
			}
			case 6:
				cout << "Arrivederci!\n";
				break;
            default:
                cout << "Scelta non valida!\n";
        }
    } while(scelta != 6);
    
	system("pause");
    return 0;
}

void aggiungiProdotto(Librerie libro[], int &nLibri) {
	if (nLibri >= MAX_PRODUCT) {
		cout << "Non è possibile aggiungere altri libri. Limite massimo raggiunto.\n";
		return;
	}

	cout << "Inserisci il titolo del libro: ";
	cin.ignore();
	getline(cin, libro[nLibri].title);

	cout << "Inserisci l'autore del libro: ";
	getline(cin, libro[nLibri].autor);

	cout << "Inserisci la quantit"<<a<<" di copie disponibili: ";
	cin >> libro[nLibri].qty;

	libro[nLibri].available = libro[nLibri].qty > 0;

	nLibri++;
	updateAnimation(3);
	cout << "Libro aggiunto con successo!\n";
}

void prendiInPrestito(Librerie libro[], int nLibri) {
	string titolo;
	cout << "Inserisci il titolo del libro che vuoi prendere in prestito: ";
	cin.ignore();
	getline(cin, titolo);

	for (int i = 0; i < nLibri; i++) {
		if (libro[i].title == titolo) {
			if (libro[i].lent < libro[i].qty) {
				libro[i].lent++;
				libro[i].available = libro[i].lent < libro[i].qty;
				cout << "Hai preso in prestito il libro: " << titolo << "\n";
				return;
			} else {
				cout << "Il libro non è disponibile al momento.\n";
				return;
			}
		}
	}
	cout << "Libro non trovato.\n";
}

void restituisciLibro(Librerie libro[], int nLibri) {
	string titolo;
	cout << "Inserisci il titolo del libro che vuoi restituire: ";
	cin.ignore();
	getline(cin, titolo);

	for (int i = 0; i < nLibri; i++) {
		if (libro[i].title == titolo) {
			if (libro[i].lent > 0) {
				libro[i].lent--;
				libro[i].available = true;
				cout << "Hai restituito il libro: " << titolo << "\n";
				return;
			} else {
				cout << "Non hai preso in prestito questo libro.\n";
				return;
			}
		}
	}
	cout << "Libro non trovato.\n";
}

void showBook(Librerie libro[], int nLibri) {
	for (int i=0 ; i<nLibri ; i++) {
		cout<<i+1<<". "<<libro[i].title<<" disponibile: "<<(libro[i].available ? "Si" : "No")<<endl;
	}
}

void ordinaLibri(Librerie libro[], int nLibri) {
	for (int i = 0; i < nLibri - 1; i++) {
		for (int j = i + 1; j < nLibri; j++) {
			if (libro[i].title > libro[j].title) {
				swap(libro[i], libro[j]);
			}
		}
	}
}

void ricercaLibro(Librerie libro[], int nLibri, string titolo) {
	ordinaLibri(libro, nLibri);
	int left = 0, right = nLibri - 1;
	while (left <= right) {
		int mid = left + (right - left) / 2;
		if (libro[mid].title == titolo) {
			cout << "Libro trovato: " << libro[mid].title << " di " << libro[mid].autor << " con " << libro[mid].qty-libro[mid].lent << " copie rimanenti "<<endl;
			return;
		}
		if (libro[mid].title < titolo) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
	cout << "Libro non trovato.\n";
}