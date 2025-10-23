#include <iostream>
#include <luppi.h>
#define DIM /*30*/3
using namespace std;

struct Gara {
	string nome;
	string nazi;
	int pett;
	float t1;
	float t2;
	float tot;
};

void addData(Gara runner[]);
void addTemp(Gara runner[], bool scelta);
void bubbleSort(Gara runner[]);
void printReverseRanking(Gara runner[]);
void printRanking(Gara runner[]);

int main() {
	
	int scelta;
	Gara partecipanti[DIM];
	
	do {
		showMenu({
			"Inserisci i tempi per la prima manche.",
			"Visualizza l'ordine di partenza per la seconda manche.",
			"Inserisci i tempi per la seconda manche.",
			"Visionare la classifica finale.",
			"Ricerca il tempo di un concorrente.",
			"Calcola il tempo medio per eseguire la prova",
			"Esci."}, &scelta);
	
		switch (scelta) {
			case 1:
				/*tempi prima manche*/
				addData(partecipanti);
				addTemp(partecipanti, 0);
				updateAnimation(3);
				break;
			case 2:
				/*ordine partenza seconda manche*/
				bubbleSort(partecipanti);
				printReverseRanking(partecipanti);
				break;
			case 3:
				/*temp secnda manche*/
				addTemp(partecipanti, 1);
				updateAnimation(3);
				break;
			case 4:
				/*clasifica totale*/
				break;
			case 5:
				/*ricerca tempo*/
				break;
			case 6:
				/*tempo medio*/
				break;
			case 7:
				cout<<"Arrivederci.";
				break;
			default:
				cout<<"Scelta non valida riprova.";
				break;
		}
	} while (scelta != 7);
	
}

void addData(Gara runner[]) {
	for (size_t i=0 ; i<DIM ; i++) {
		cout<<"Inserisci il nome del concorrente\n: ";
		cin>>runner[i].nome;
		cout<<"Inserisci la nazionalit"<<a<<" del concorrente\n: ";
		cin>>runner[i].nazi;
		runner[i].pett = i+1;
		cout<<"Il numero di pettorina "<<e<<" "<<i+1<<endl;
	}	
}

void addTemp(Gara runner[], bool scelta) {
	for (size_t i=0 ; i<DIM ; i++) {
		cout<<"Inserici il tempo della "<<(!scelta ? "1" : "2")<<apice<<" manche.";
		cin>>(!scelta ? runner[i].t1 : runner[i].t2);
	}	
}

void bubbleSort(Gara runner[]) {
	bool swapped;
	for (size_t i = 0; i < DIM - 1; i++) {
		swapped = false;
		for (size_t j = 0; j < DIM - i - 1; j++) {
			if (runner[j].tot > runner[j + 1].tot) {
				Gara temp = runner[j];
				runner[j] = runner[j + 1];
				runner[j + 1] = temp;
				swapped = true;
			}
		}
		if (!swapped) {
			break;
		}
	}
}

void printReverseRanking(Gara runner[]) {
	for (int i = DIM - 1; i >= 0; i--) {
		cout << "Nome: " << runner[i].nome << ", Pettorale: " << runner[i].pett << ", Tempo prima manche: " << runner[i].t1 << endl;
	}
}

void printRanking(Gara runner[]) {
	for (int i = 0; i < DIM; i++) {
		cout << "Nome: " << runner[i].nome << ", Nazionalità: " << runner[i].nazi << ", Pettorale: " << runner[i].pett << ", Tempo totale: " << runner[i].tot << endl;
	}
}