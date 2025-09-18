#include <iostream>
#include <cstdlib>
#include <ctime>
#define ROW 6
using namespace std;

int main() {

	system("cls");
	srand(time(0));
	int COL, vincenti[ROW][1];

	bool exit = false;
	int k=0;
	while (!exit) {
		int controllo = 0;
		vincenti[k][0] = rand() % 90 + 1;
		for (int i=0 ; i<k ; i++) {
			if (vincenti[i][0] != vincenti[k][0]) {
				controllo++;
			}
		}
		if (controllo == k) {
			k++;
		}
		if (k==ROW) {
			exit = true;
		}
	}
	//! COntrollo numeri
	for (int i=0 ; i<ROW ; i++) {
		cout<<vincenti[i][0]<<" ";
	}

	cout<<"Quante scommesse vuoi fare? ";
	cin>>COL;
	int scommesse[ROW][COL];

	for (int i=0 ; i<COL ; i++) {
		cout<<"Scommssa numero: "<<i+1<<endl;
		for (int j=0 ; j<ROW ; j++) {
			cout<<"Scommetti il "<<j+1<<" numero ";
			cin>>scommesse[j][i];
		}
	}

	cout<<"Risultati scommesse."<<endl;
	for (int i=0 ; i<COL ; i++) {
		int vincita = 0;
		cout<<"Per la scommssa numero: "<<i+1;
		for (int j=0 ; j<ROW ; j++) {
			if (vincenti[j][0] == scommesse[j][i]) {
				vincita++;
			}
		}
		cout<<" la vincita e' di: "<<vincita<<endl;
	}
	



}