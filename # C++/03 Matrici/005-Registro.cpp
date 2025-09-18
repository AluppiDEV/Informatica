/*
In una matrice sono memorizzati i giorni d'assenza per ciascun alunno della classe e per ogni giorno del mese. 
In un array sono invece caricati i nomi degli alunni della classe. Scrivere un programma che carichi la matrice e calcoli:
a. il totale delle assenze per ciascun alunno;
b. il totale delle assenze per l'alunno il cui nominativo è fornito da input, segnalare in modo
opportuno se il nominativo e' errato;
c. il nome dell'alunno che ha il maggior numero di assenze nel mese;
d. il nome dell'alunno che ha il minor numero di assenze nel mese.
*/

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <algorithm>
using namespace std;

int main() {

	system("cls");
	string nomi[] = {
        "Alessandro", "Andrea", "Antonio", "Carlo", "Davide", "Diego", "Edoardo", "Enrico", "Fabio", "Federico",
        "Filippo", "Francesco", "Gabriele", "Giovanni", "Giorgio", "Giuseppe", "Jacopo", "Leonardo", "Lorenzo", "Luca",
        "Marco", "Mario", "Matteo", "Michele", "Nicola", "Paolo", "Pietro", "Riccardo", "Roberto", "Samuele",
        "Saverio", "Sergio", "Simone", "Stefano", "Tommaso", "Valerio", "Vincenzo", "Alessandro", "Claudio", "Domenico",
        "Giulio", "Emanuele", "Cristian", "Daniele", "Raffaele", "Maurizio", "Salvatore", "Fabrizio", "Alessio", "Vittorio",
        "Alessandra", "Alice", "Angela", "Anna", "Arianna", "Beatrice", "Benedetta", "Bianca", "Camilla", "Carla",
        "Chiara", "Claudia", "Cristina", "Daniela", "Debora", "Elena", "Elisa", "Elisabetta", "Emma", "Federica",
        "Francesca", "Gabriella", "Gaia", "Giada", "Giorgia", "Giulia", "Irene", "Laura", "Lavinia", "Letizia",
        "Linda", "Lisa", "Lucia", "Lucrezia", "Maddalena", "Maria", "Marta", "Martina", "Michela", "Monica",
        "Noemi", "Paola", "Patrizia", "Roberta", "Sabrina", "Serena", "Silvia", "Simona", "Sofia", "Valentina"
    };

	srand(time(0));
	int ROW, temp;
	const int COL = 31;

	cout<<"Quanti alunni ci sono in classe? ";
	cin>>ROW;

	bool registro[ROW][COL];
	int assenze[ROW]={0};
	string alunni[ROW];

	for (int i=0 ; i<ROW ; i++) {
		alunni[i] = nomi[rand() % 100];
		for (int j=0 ; j<COL ; j++) {
			temp = rand() % 100;
			if (temp < 75) {
				registro[i][j] = 0;
			} else {
				registro[i][j] = 1;
				assenze[i]++;
			}
		}
	}

	//! Assenze totali
	for (int i=0 ; i<ROW ; i++) {
		cout<<"Le assenze di "<<alunni[i]<<" sono: "<<assenze[i]<<endl;
	}

	//! Assenze alunno
	string ricerca;
	bool accettato = false;
	int indice;
	while (!accettato) {
		cout<<"\nDi chi vuoi sapere le assenze? ";
		cin>>ricerca;

		for (int i=0 ; i<ROW ; i++) {
			if (ricerca == alunni[i]) {
				indice = i;
				accettato = true;
			}
		}

		if (!accettato) {
			cout<<"Non e' stato trovato nessun "<<ricerca<<"! riprova! \n";
		}
	}
	accettato = false;

	cout<<"Le assenze di "<<alunni[indice]<<" sono "<<assenze[indice]<<endl<<endl;

	//! Calcolo massimo minimo
	int massimo = -1, iMassimo = -1;
	int minimo = 30, iMinimo = -1;
    for (int i=1 ; i<ROW ; i++) {
        if (assenze[i] > massimo) {
            massimo = assenze[i];
			iMassimo = i;
        }
		if (assenze[i] < minimo) {
            minimo = assenze[i];
			iMinimo = i;
        }
    }
	cout<<"Altre informazioni generalia: "<<endl;
    cout<<"Il maggior numero di assenze e': "<<massimo<<" fatte da "<<alunni[iMassimo]<<endl;
    cout<<"Il minor numero di assenze e': "<<minimo<<" fatte da "<<alunni[iMinimo]<<endl;


	system("pause");
	return 0;
}