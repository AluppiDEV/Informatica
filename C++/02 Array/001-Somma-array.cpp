#include <iostream>
#define DIM 5
using namespace std;

int main() {

    int arr[DIM];
    int somma;

    for (int i=0 ; i<DIM ; i++) {
        cout<<"Inserisci il numero ";
        cin>>arr[i];
    }

    for (int i=0 ; i<DIM ; i++) {
        somma += arr[i];
    }

    cout<<"La somma totale dei numeri e' "<<somma;

    system("pause");
    return 0;
}