/*
Caricare una matrice 6x6 con valori interi random.

Calcolare:
somma della diagonale
qual è la riga e la colonna contenenti il valore più alto
qual è la colonna con la somma dei valori più alta
qual è la riga con la somma dei valori più bassa
*/
#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 6
using namespace std;

int main() {
	system("cls");

	srand(time(0));
	int mat[DIM][DIM], somma, max, diagonal, mRow, mCol;
	int x, y;

	for (int i=0 ; i<DIM ; i++) {
		for (int j=0 ; j<DIM ; j++) {
			mat[i][j] = rand() % 20;
			cout<<mat[i][j]<<"\t";
		}
		cout<<endl;
	}

	//! Calcolo diagonale
	somma = 0;
	for (int i=0 ; i<DIM ; i++) {
		somma += mat[i][i];
	}
	diagonal = somma;
	
	//! Calcolo coordinate valore maggiore
	max = INT_MIN;
	for (int i=0 ; i<DIM ; i++) {
		for (int j=0 ; j<DIM ; j++) {
			if (mat[i][j] > max) {
				max = mat[i][j];
				x = i;
				y = j;
			}
		}
	}

	//! Calcolo somma righe e colonne
	//* Righe
	max = INT_MIN;
	for (int i=0 ; i<DIM ; i++) {
		somma = 0;
		for (int j=0 ; j<DIM ; j++) {
			somma += mat[i][j];
		}
		if (somma > max) {
			max = somma;
			mRow = i;
		}
	}

	//* Colonne
	max = INT_MIN;
	for (int i=0 ; i<DIM ; i++) {
		somma = 0;
		for (int j=0 ; j<DIM ; j++) {
			somma += mat[j][i];
		}
		if (somma > max) {
			max = somma;
			mCol = i;
		}
	}

	cout<<endl;
	cout<<"Ecco cosa ho analizzato:"<<endl;
	cout<<"La somma della diagonale e': "<<diagonal<<endl;
	cout<<"Il valore piu' alto si trova a coordinate ("<<x<<";"<<y<<")"<<endl;
	cout<<"La riga con la somma maggiore e' la: "<<mRow<<endl;
	cout<<"La colonna con la somma maggiore e' la: "<<mCol<<endl;


	system("pause");
	return 0;
}