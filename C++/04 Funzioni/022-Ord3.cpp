#include <iostream>
using namespace std;
void merge(int arr[], int start, int mid, int end) {
	int* b = new int[end - start + 1];
	int i = start, j = mid + 1, k = 0;
	while (i <= mid && j <= end) {
		if (arr[i] <= arr[j]) {
			b[k] = arr[i];
			++i;
		} else {
			b[k] = arr[j];
			++j;
		}
		++k;
	}

	while (i <= mid) {
		b[k] = arr[i];
		++i;
		++k;
	}

	while (j < end) {
		b[k] = arr[j];
		++j;
		++k;
	}

	for (int i = start; i <= end; i++) {
		arr[i] = b[i - start];
	}
	delete[] b;
	
}

void mergeSort(int arr[], int start, int end) {
	if (start < end) {
		int mid = start + (end - start) / 2;

		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);

		merge(arr, start, mid, end);
	}
}

int main() {
	int arr[] = {12, 11, 13, 5, 6, 7};
	int arr_size = sizeof(arr) / sizeof(arr[0]);

	cout << "Given array is \n";
	for (int i = 0; i < arr_size; i++)
		cout << arr[i] << " ";
	cout << endl;

	mergeSort(arr, 0, arr_size - 1);

	cout << "\nSorted array is \n";
	for (int i = 0; i < arr_size; i++)
		cout << arr[i] << " ";
	cout << endl;
	return 0;
}
