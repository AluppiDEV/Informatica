#include <iostream>
#include <cstdlib>
#include <ctime>
#include "sort.h"
#define DIM 5
using namespace std;

int main() {
	
	srand(time(0));
    int arr[DIM];
	
	while (true) {
		system("cls");
		int iterazioni = 0;
		
		for (int i=0 ; i<DIM ; i++) {
			arr[i] = rand() % 100 + 1;
		}
		
		int scelta;
		cout<<"1. Naive\n2. Selection\n3. Bubble\n: ";
		cin>>scelta;
		
    	cout << "Ordinamento iniziale dell'array\n";
    	for (int i=0 ; i<DIM; i++) {
			cout << arr[i] << " ";
    	}
    	cout<<endl<<endl;

		switch (scelta) {
			case 1:
				naiveSort(arr, DIM, &iterazioni);
				break;
			case 2:
				selectionSort(arr, DIM, &iterazioni);
				break;
			case 3:
				bubbleSort(arr, DIM, &iterazioni);
				break;
		}
	
    	cout << "Ordinamento finale dell'array\n";
    	for (int i=0 ; i<DIM; i++) {
			cout << arr[i] << " ";
    	}
		cout<<endl<<"Numero di scambi: "<<iterazioni;
    	cout<<endl<<endl;
		system("pause");
	}
	
	return 0;
}