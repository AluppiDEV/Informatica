#include <iostream>
#define DIM 8
using namespace std;

void myFunction(int arr[], int out[], int size);

int main() {
	int array1[DIM] = {1, 3, 7, 9, 2, 3, 4, 8};
	int array2[DIM];
	int dimensione = DIM;
	
	for(int i = 0; i < DIM; i++) {
		cout << array1[i] << " ";
	}
	cout << endl;
	
	myFunction(array1, array2, dimensione);

	for(int i = 0; i < DIM; i++) {
		cout << array2[i] << " ";
	}
	cout << endl;
	
	return 0;
}

void myFunction(int arr[], int out[], int size) {
	int i=0, j=size/2, k=0;
	while (i < size/2 && j < size) {
		if (arr[i] < arr[j]) {
			out[k] = arr[i];
			i++;
		} else {
			out[k] = arr[j];
			j++;
		}
		k++;
	}
	while (i < size/2) {
		out[k] = arr[i];
		i++;
		k++;
	}
	while (j < size) {
		out[k] = arr[j];
		j++;
		k++;
	}
	for (int i=0; i<size; i++) {
		arr[i] = out[i];
	}
}