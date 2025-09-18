#include <iostream>
#include <luppi.h>
#include <vector>
using namespace std;

int ricerca(int arr[], int dim, int x);

int ricercaRicorsiva(int arr[], int start, int end, int x);

void stampaArray(int arr[], int dim) {
	for (int i = 0; i < dim; i++) {
		cout << arr[i] << " ";
	}
	cout << endl;
}

int main() {
	
	int arr[] = {1,2,3,5,6,8,9,11,15};
	int dim = sizeof(arr)/sizeof(arr[0]);
	int x;

	stampaArray(arr, dim);

	cout<<"Inserisci il numero da cercare\n: ";
	cin >> x;

	int scelta = 0;
	vector<string>scelte = {"Ricerca Iterativa", "Ricerca Ricorsiva"};
	showMenu(scelte, scelta);

	switch (scelta) {
		case 1: {
			int indice = ricerca(arr, dim, x);
			if (indice == -1) {
				cout<<"Il numero non "<<e<<" stato trovato"<<endl;
			}
			else {
				cout<<"Il numero si trova nell'indice: "<<indice<<endl;
			}
			break;
		}
		case 2: {
			int indiceRicorsivo = ricercaRicorsiva(arr, 0, dim, x);
			if (indiceRicorsivo == -1) {
				cout<<"Il numero non "<<e<<" stato trovato"<<endl;
			}
			else {
				cout<<"Il numero si trova nell'indice: "<<indiceRicorsivo<<endl;
			}
			break;
		}
		}
	
	return 0;
}

int ricerca(int arr[], int dim, int x) {
	int start = 0, end = dim, mid = (start+end)/2;

	while (start < end) {
		if (arr[mid] == x) {
			return mid;
		}
		else if (arr[mid] < x) {
			start = mid+1;
		}
		else {
			end = mid-1;
		}
		mid = (start+end)/2;
	}
	return -1;

}

int ricercaRicorsiva(int arr[], int start, int end, int x) {
	int mid = (start+end)/2;

	if (arr[mid] == x) {
		return mid;
	}
	else if (start >= end) {
		return -1;
	}
	else if (arr[mid] < x) {
		return ricercaRicorsiva(arr, mid+1, end, x);
	}
	else {
		return ricercaRicorsiva(arr, start, mid-1, x);
	}

}