#include <iostream>
#include <cstdlib>
#include <ctime>
#define ROW 4
#define COL 7
using namespace std;
char apice_numero = static_cast<char>(248), e = static_cast<char>(138), a = static_cast<char>(133);

int main() {

	system("cls");
	int temp[ROW+3][COL+3], somma, max, min, scelta, indice = -1;
	//? in row+1/+2/+3 e col+1/+2/+3 sono memorizzate le medie delle città e dei giorni
	string citta[ROW], ricerca;
	bool accettato = false;

	for (int i=0 ; i<ROW ; i++) {
		cout<<"Inserisci il nome per la "<<i+1<<apice_numero<<" citt"<<a<<" ";
		cin>>citta[i];

		//! Cacolo media, minima e massima per citta
		somma = 0;
		max = INT_MIN;
		min = INT_MAX;
		for (int j=0 ; j<COL ; j++) {
			temp[i][j] = rand() % 10 + 16;
			cout<<"Inserisci la "<<j+1<<apice_numero<<" temperatura per la citt"<<a<<" "<<citta[i]<<" ";
			cout<<" "<<temp[i][j]<<endl;
			//* somma per citta
			somma += temp[i][j];
			//* max per citta
			if (temp[i][j] > max) {
				max = temp[i][j];
			}
			//* min per citta
			if (temp[i][j] < min) {
				min = temp[i][j];
			}
		}
		temp[i][COL+1] = somma / COL;
		temp[i][COL+2] = max;
		temp[i][COL+3] = min;
	}

	for (int i=0 ; i<ROW ; i++) {
		//! Cacolo media, minima e massima per giorni
		somma = 0;
		max = INT_MIN;
		min = INT_MAX;
		for (int j=0 ; j<COL ; j++) {
			//* somma per gioni
			somma += temp[j][i];
			//* max per giorni
			if (temp[j][i] > max) {
				max = temp[j][i];
			}
			//* min per giorni
			if (temp[j][i] < min) {
				min = temp[j][i];
			}
		}
		temp[ROW+1][i] = somma / ROW;
		temp[ROW+2][i] = max;
		temp[ROW+3][i] = min;
		
	}

	cout<<"Cosa ti intaressa sapere?"<<endl;
	cout<<"'1' se vuoi sapere la media per una citta' a scelta" <<endl;
	cout<<"'2' se vuoi sapere la media per un giorno a scelta" <<endl;
	cout<<"'3' se vuoi sapere la temperatura massima per una citta' a scelta" <<endl;
	cout<<"'4' se vuoi sapere la temperatura massima per un giorno a scelta" <<endl;
	cout<<"'5' se vuoi sapere la temperatura minima per una citta' a scelta" <<endl;
	cout<<"'6' se vuoi sapere la temperatura minima per un giorno a scelta" <<endl;
	cout<<": " ;
	cin>>scelta;
	
	switch (scelta) {
		case 1:
			while (!accettato) {
				cout<<"di che citt"<<a<<" vuoi la temperatua media? ";
				cin>>ricerca;
				
				for (int i=0 ; i<ROW ; i++) {
					if (ricerca == citta[i]) {
						indice = i;
					}
				}
				
				if (indice != -1) {
					accettato = true;
				}
			
			}
			accettato = false;
			
			cout<<"la temperatura media di "<<citta[indice]<<" "<<e<<" "<<temp[indice][COL+1]<<apice_numero<<" gradi"<<endl;
			break;
			
		case 2:
			while (!accettato) {
				cout<<"di che giorno vuoi la temperatua media? ";
				cin>>scelta;
				
				if (scelta <= 7 && scelta >= 1) {
					indice = scelta - 1;
				}
				
				if (scelta != -1) {
					accettato = true;
				}
			
			}
			accettato = false;
			
			cout<<"la temperatura media media del "<<scelta<<apice_numero<<" giorno, "<<e<<" "<<temp[ROW+1][indice]<<" gradi"<<endl;
			break;

		case 3:
			while (!accettato) {
				cout<<"di che citt"<<a<<" vuoi la temperatua massima? ";
				cin>>ricerca;
				
				for (int i=0 ; i<ROW ; i++) {
					if (ricerca == citta[i]) {
						indice = i;
					}
				}
				
				if (indice != -1) {
					accettato = true;
				}
			
			}
			accettato = false;
			
			cout<<"la temperatura massima di "<<citta[indice]<<" "<<e<<" "<<temp[indice][COL+2]<<apice_numero<<" gradi"<<endl;
			break;

		case 4:
			while (!accettato) {
				cout<<"di che giorno vuoi la temperatua massima? ";
				cin>>scelta;
				
				if (scelta <= 7 && scelta >= 1) {
					indice = scelta - 1;
				}
				
				if (scelta != ROW+1) {
					accettato = true;
				}
			
			}
			accettato = false;
			
			cout<<"la temperatura media massima del " <<scelta<<apice_numero<<" giorno, "<<e<<" "<<temp[ROW+2][indice]<<" gradi"<<endl;
			break;

		case 5:
			while (!accettato) {
				cout<<"di che citt"<<a<<" vuoi la temperatua minima? ";
				cin>>ricerca;
				
				for (int i=0 ; i<ROW ; i++) {
					if (ricerca == citta[i]) {
						indice = i;
					}
				}
				
				if (indice != -1) {
					accettato = true;
				}
			
			}
			accettato = false;
			
			cout<<"la temperatura massima di "<<citta[indice]<<" "<<e<<" "<<temp[indice][COL+3]<<apice_numero<<" gradi"<<endl;
			break;

		case 6:
			while (!accettato) {
				cout<<"di che giorno vuoi la temperatua minima? ";
				cin>>scelta;
				
				if (scelta <= 7 && scelta >= 1) {
					indice = scelta - 1;
				}
				
				if (scelta != ROW+1) {
					accettato = true;
				}
			
			}
			accettato = false;
			
			cout<<"la temperatura media massima del " <<scelta<<apice_numero<<" giorno, "<<e<<" "<<temp[ROW+3][indice]<<" gradi"<<endl;
			break;

		default: 
			accettato = false;
			cout<<"Impossibile eseguire, comando non trovato.";
			break;
	}


	system("pause");
	return 0;
}