#include <iostream>
#define DIM1 5
#define DIM2 4
using namespace std;

void myFunction(int arr1[], int ar2[], int arr[3]);

int main() {
	int array1[DIM1] = {1, 3, 4, 7, 9};
	int array2[DIM2] = {2, 3, 5, 8};
	int array3[DIM1 + DIM2];

	
	for(int i = 0; i < DIM1; i++) {
		cout << array1[i] << " ";
	}
	cout << endl;

	for(int i = 0; i < DIM2; i++) {
		cout << array2[i] << " ";
	}
	cout << endl;
	
	myFunction(array1, array2, array3);

	for(int i = 0; i < DIM1 + DIM2; i++) {
		cout << array3[i] << " ";
	}
	cout << endl;
	
	return 0;
}

void myFunction(int arr1[], int arr2[], int arr3[]) {
	int i=0, j=0, k=0;
	while (i <= DIM1 && j <= DIM2) {
		if (arr1[i] < arr2[j]) {
			arr3[k] = arr1[i];
			i++;
		} else {
			arr3[k] = arr2[j];
			j++;
		}
		k++;
	}
	while (i <= DIM1) {
		arr3[k] = arr1[i];
		i++;
		k++;
	}
	while (j <= DIM2) {
		arr3[k] = arr2[j];
		j++;
		k++;
	}
}