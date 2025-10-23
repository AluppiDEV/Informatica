#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 5
using namespace std;

int main() {
    system("cls");

    int arr[DIM];
    int temp;

    for (int i=0 ; i<DIM ; i++) {
        arr[i] = rand() % 100 + 1;
    }
    

    cout << "Ordinamento iniziale dell'array\n";
    for (int i=0 ; i<DIM; i++) {
        cout << arr[i] << " ";
    }
    cout<<endl<<endl;
    
    for (int i=0 ; i<DIM-1; i++) {
        for (int j=i+1 ; j<DIM ; j++) {
            if (arr[i] > arr[j]) {
                swap(arr[j], arr[i]);
            }
        }
    }
    
    cout << "Ordinamento finale dell'array\n";
    for (int i=0 ; i<DIM; i++) {
        cout << arr[i] << " ";
    }
    cout<<endl<<endl;

    system("pause");
    return 0;
}