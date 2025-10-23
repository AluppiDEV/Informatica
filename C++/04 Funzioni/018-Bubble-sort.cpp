#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 20
using namespace std;

int main() {
    system("cls");

    srand(time(0));
    int arr[DIM];
    int index;
    

    for (int i=0 ; i<DIM ; i++) {
        arr[i] = rand() % 100 + 1;
    }
    

    cout << "Ordinamento iniziale dell'array\n";
    for (int i=0 ; i<DIM; i++) {
        cout << arr[i] << " ";
    }
    cout<<endl<<endl;
    
	int n, scambi;
	do {
		n = 0;
		for (int i=0 ; i<DIM-1 ; i++) {
			if (arr[i] > arr[i+1]) {
				swap(arr[i], arr[i+1]);
				scambi++;
				n++;
			}
		}

	} while (n != 0);
    
    cout << "Ordinamento finale dell'array\n";
    for (int i=0 ; i<DIM; i++) {
        cout << arr[i] << " ";
    }
	cout<<endl<<scambi;
    cout<<endl<<endl;

    system("pause");
    return 0;
}