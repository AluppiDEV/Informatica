/*
vettore numeric di 50 element estratti a acaso tra 0 e 9,
di ogni valore calcolare la frequenza (quante volte è uscito) 
possibilmente in format grafico
*/

#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 50
#define MAX_RAND 10
using namespace std;

int main() {

	srand(time(0));

	int numeri[DIM], count[MAX_RAND]={0};

	for (int i=0 ; i<DIM ; i++) {
		numeri[i] = rand() % MAX_RAND;
		cout<<numeri[i]<<" ";
		count[numeri[i]]++;
	}

	for (int i=0 ; i<MAX_RAND ; i++) {
		cout<<endl<<"Frequenza del numero "<<i<<" ("<<count[i]<<" volte): ";
		for (int j=0 ; j<count[i] ; j++) {
			cout<<"#";
		}
	}

	cout<<endl;
	system("pause");
	return 0;
}