#include <iostream>

//! Ricerca dicotomca
using namespace std;
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

//! Ricerca ricorsiva
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