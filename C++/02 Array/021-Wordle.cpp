#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 5
#define MAX_GEN 10
using namespace std;

int main(){
	system("cls");

	const string green = "\033[32m";
	const string orange = "\033[38;5;208m";
	const string reset = "\033[0m";

	int risultato[DIM]={1,3,2,5,4};
	bool corretto[DIM]={false}, semi[DIM]={false};
	char risposta[DIM+1];

	while (true) {
		cout<<"Inserisci la sequenza di 5 numeri per provare ad indovinare. ";
		cin>>risposta;

		for (int i=0 ; i<DIM ; i++) {
			risposta[i] -= 48;
		}

		for (int i=0 ; i<DIM ; i++) {
			if (risultato[i] == risposta[i]) {
				corretto[i] = true;
				cout << green << risultato[i] << reset;
			}
			for (int j=0 ; j<DIM ; j++) {
				if (!corretto[i]) {
					if (risposta[i] == risultato[j]) {
						semi[i] = true;
						cout << orange << risultato[j] << reset;
					}
				}
			}
			if (!corretto [i] and !semi[i]) {
				cout<<int(risposta[i]);
			}

		}
		cout<<endl;
	}

	system("pause");
	return 0;
}