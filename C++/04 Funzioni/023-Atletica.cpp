#include <iostream>
#define MAX 20
using namespace std;


/*
Un'organizzazione sportiva deve ordinare i tempi di arrivo dei partecipanti a una gara di atletica per determinare la classifica finale.
Scrivi un programma in C++ che:

Chieda all'utente quanti partecipanti hanno completato la gara (massimo 20).
Permetta all'utente di inserire i tempi (in secondi, con valori decimali) e i numeri di pettorale degli atleti
Ordini i tempi in ordine crescente (dal più veloce al più lento) utilizzando una funzione di ordinamento.
Visualizzi la classifica finale
*/

class garaAtletica {
	public:
		void addTemp(int DIM, int runner[], float time[]) {
			for (int i=0; i<DIM; ++i) {
			cout<<"Inserisci il numero del "<<i+1<<" partecipante\n: ";
			cin>>runner[i];
			cout<<"Ora inserisci il tempo per il concorrente con il numero "<<runner[i]<<"\n: ";
			cin>>time[i];
			}
		}

		void BubbleSort(float arr[], int arr1[], int DIM){
			bool sentinella;
			int c=0;
	
			do{
				sentinella = false;
		
				for(int i=0; i<(DIM-1-c); i++){
					if(arr[i] > arr[i+1]){
						swap(arr[i], arr[i+1]);
						swap(arr1[i], arr1[i+1]);
						sentinella = true;
					}
				}

				c++;
			}while((c<(DIM-1))&&sentinella);
		}
};

int main() {
	
	garaAtletica funzioni;
	
	int nPartecipanti;
	
	cout<<"Quanti corridori hanno finito la gara?\n: ";
	cin>>nPartecipanti;
	
	int partecipanti[nPartecipanti];
	float tempi[nPartecipanti];
	
	funzioni.addTemp(nPartecipanti, partecipanti, tempi);
	funzioni.BubbleSort(tempi, partecipanti, nPartecipanti);
	
	cout<<"=== CLASSIFICA ==="<<endl;
	for (int i=0; i<nPartecipanti; ++i) {
		cout<<i+1<<". Pettorina: "<<partecipanti[i]<<" Tempo: "<<tempi[i]<<endl;
	}
}