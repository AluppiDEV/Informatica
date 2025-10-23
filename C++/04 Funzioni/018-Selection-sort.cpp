#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 5
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
    
    for (int i=0 ; i<DIM-1; i++) {
        int min = INT_MAX;
        int index = i;
        for (int j=i ; j<DIM ; j++) {
            if (arr[j] < min) {
                min = arr[j];
                index = j;
            }
        }
        swap(arr[index], arr[i]);
    }
    
    cout << "Ordinamento finale dell'array\n";
    for (int i=0 ; i<DIM; i++) {
        cout << arr[i] << " ";
    }
    cout<<endl<<endl;

    system("pause");
    return 0;
}