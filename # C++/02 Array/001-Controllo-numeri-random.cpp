#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 10
using namespace std;

int main() {

    srand(time(0));

    int arr[DIM], numeroPari=0, nuemroDispari=0;

    for (int i=0 ; i<DIM ; i++) {
        arr[i] = rand() % 100 +1;
        cout<<"Il numero generato e' "<<arr[i]<<endl;
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