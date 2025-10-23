#include <iostream>
#define DIM 10
using namespace std;

int main() {

    int arr[DIM], numeroPari=0, nuemroDispari=0;

    for (int i=0 ; i<DIM ; i++) {
        cout<<"Inserisci il numero ";
        cin>>arr[i];
    }

    for (int i=0 ; i<DIM ; i++) {
        if (arr[i]%2 != 0 ) {
            nuemroDispari++;
        } else {
            numeroPari++;
        }
    }

    cout<<"La somma dei numeri pari e' "<<numeroPari<<" invece somma dei numeri dispari e' "<<nuemroDispari<<endl;

    system("pause");
    return 0;
}