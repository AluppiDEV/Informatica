#include <iostream>
#include <string>
#include <luppi.h>

using namespace std;

struct Veicolo {
    string marca;
    string modello;
    int anno;
    float prezzo;
};

// Funzione per inserire i dati di un veicolo
void inserisciVeicolo(Veicolo &v);

// Funzione per stampare i dati di tutti i veicoli
void stampaVeicoli(const Veicolo veicoli[], int num);

// Funzione per trovare l'indice del veicolo più economico
int trovaVeicoloPiuEconomico(const Veicolo veicoli[], int num);

int main() {
    const int NUM_VEICOLI = 4;
    Veicolo veicoli[NUM_VEICOLI];
	int scelta;

	showMenu({"Aggiungi auto", "Stampa lista veicoli", "Ricerca piu economico"}, &scelta);

	switch (scelta) {
		case 1: 
			// Inserimento dati tramite funzione
			for (int i = 0; i < NUM_VEICOLI; i++) {
				cout << "\nInserisci dati per il veicolo " << i + 1 << ":\n";
				inserisciVeicolo(veicoli[i]);
			}
			break;
		case 2:	
			// Stampa veicoli
			stampaVeicoli(veicoli, NUM_VEICOLI);
			break;

		case 3:
			// Trova e stampa il veicolo più economico
			int indiceEconomico = trovaVeicoloPiuEconomico(veicoli, NUM_VEICOLI);
			cout << "\nIl veicolo piu economico "<<e<<": "
			<< veicoli[indiceEconomico].marca << " "
			<< veicoli[indiceEconomico].modello
			<< " (" << veicoli[indiceEconomico].prezzo << euro << endl;
			break;
		
	}
		return 0;
}

void inserisciVeicolo(Veicolo &v) {
    cout << "Inserisci marca: ";
    cin >> v.marca;
    cout << "Inserisci modello: ";
    cin >> v.modello;
    cout << "Inserisci anno di produzione: ";
    cin >> v.anno;
    cout << "Inserisci prezzo: ";
    cin >> v.prezzo;
}

void stampaVeicoli(const Veicolo veicoli[], int num) {
    cout << "\nLista veicoli:\n";
    for (int i = 0; i < num; i++) {
        cout << "Marca: " << veicoli[i].marca
             << ", Modello: " << veicoli[i].modello
             << ", Anno: " << veicoli[i].anno
             << ", Prezzo: " << veicoli[i].prezzo << euro << endl;
    }
}

int trovaVeicoloPiuEconomico(const Veicolo veicoli[], int num) {
    int indicePiuEconomico = 0;
    for (int i = 1; i < num; i++) {
        if (veicoli[i].prezzo < veicoli[indicePiuEconomico].prezzo) {
            indicePiuEconomico = i;
        }
    }
    return indicePiuEconomico;
}