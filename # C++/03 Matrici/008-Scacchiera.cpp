#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 4
using namespace std;

int main() {

	srand(time(0));
	int mat[DIM][DIM];
	bool scacchiera = true;

	while (true) {
		system("cls");
		
		for (int i=0 ; i<DIM ; i++) {
			for (int j=0 ; j<DIM ; j++) {
				mat[i][j] = rand() % 2;
				cout<<mat[i][j]<<" ";
				//! Controlli
				if (j != 0 && mat[i][j] == mat[i][j-1]) {
					scacchiera = false;
				}

				if (i != 0 && mat[i][j] == mat[i-1][j]) {
					scacchiera = false;
				}
			}
			cout<<endl;
		}

		if (scacchiera) {
			cout<<"La matrice e' una scacchiera"<<endl;
		} else {
			cout<<"La matrice non e' una scacchiera"<<endl;
		}

		system("pause");
	}

	
	system("pause");
	return 0;
}