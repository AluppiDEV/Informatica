#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 5
using namespace std;

int main() {

	srand(time(0));
	int mat[DIM][DIM], sommaUP=0, sommaDOWN=0;

	for (int i=0 ; i<DIM ; i++) {
		for (int j=0 ; j<DIM ; j++) {
			mat[i][j] = rand() % 5 + 1;
			cout<<mat[i][j]<<" ";
		}
		cout<<endl;
	}

	for (int i=0 ; i<DIM-1 ; i++) {

		for (int j=0 ; j<DIM ; j++) {

			if (i!=j) {

				if (j>i) {
					sommaUP += mat[i][j];
				} else {
					sommaDOWN += mat[i][j];
				}

			}

		}

	}


	cout<<"Somma sopra: "<<sommaUP<<endl;
	cout<<"Somma sotto: "<<sommaDOWN<<endl;
	if (sommaUP > sommaDOWN) {
		cout<<"La somma maggiore e' quella superiore"<<endl;
	} else {
		cout<<"La somma maggiore e' quella inferiore"<<endl;
	}
	
	system("pause");
	return 0;
}