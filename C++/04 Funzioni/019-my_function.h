#include <iostream>
using namespace std;

//--------------------------------------------------------------------------

void aggiuntaVoti(string nomi[], float voti[], int DIM){

    for(int i=0; i<DIM; i++){
		system("cls");
        cout<<"Inserisci il nome del " <<i+1 <<" studente: ";
        cin>>nomi[i];
        cout<<"Inserisci il voto di " <<nomi[i] <<": ";
        cin>>voti[i];
        cout<<"Voto aggiunto!\n";
        system("pause");
    }
}

//--------------------------------------------------------------------------

//menu'
void menu(string opzioni[], int Nopz, int& scelta){
	for(int i=0; i<Nopz; i++){
		cout<<i+1 <<". " <<opzioni[i] <<endl;
	}
	cout<<": ";
	cin>>scelta;
}

//--------------------------------------------------------------------------

void stampaClasse(float voti[], string nomi[], int DIM){
	cout<<"Ecco la classe ordinata per i voti in modo crescente: \n";
    for(int i=0; i<DIM; i++){
        cout<<i+1 <<") " <<nomi[i] <<" -> " <<voti[i] <<endl;
    }
}

//--------------------------------------------------------------------------
//sentinel bubble sort crescente
void ascBubbleSort(float voti[], int DIM, string nomi[]){
	bool sentinella;
	int c=0;
	
	do{
		sentinella = false;
		
		for(int i=0 ; i<(DIM-1-c) ; i++) {
			if(voti[i] > voti[i+1]) {
				swap(voti[i], voti[i+1]);
				swap(nomi[i], nomi[i+1]);
				sentinella = true;
				
			}
			if (!sentinella) {
				c++;
			}
		}

		c++;
	}while((c<(DIM-1)) && sentinella);
	
	stampaClasse(voti, nomi, DIM);
}

//--------------------------------------------------------------------------

//sentinel bubble sort decrescente
void descBubbleSort(float voti[], int DIM, string nomi[]){
	bool sentinella;
	int c=0;
	
	do{
		sentinella = false;
		
		for(int i=0; i<(DIM-1-c); i++){
			if(voti[i] < voti[i+1]){
				swap(voti[i], voti[i+1]);
				swap(nomi[i], nomi[i+1]);
				sentinella = true;
			}
		}

		c++;
	}while((c<(DIM-1)) && sentinella);
	
	stampaClasse(voti, nomi, DIM);
}