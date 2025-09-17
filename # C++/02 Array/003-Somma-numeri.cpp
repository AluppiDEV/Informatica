#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 20
using namespace std;

int main() {

    int arr[DIM], somma=0;

    srand(time(0));

    for (int i=0 ; i<DIM ; i++) {
        arr[i] = rand() % 10;
        cout<<arr[i]<<endl;
    }

    int i;
    while (arr[i] != 0 && i<DIM) {
        somma += arr[i];
        i++;
    }
    

    cout<<"La somma dei numeri precedenti allo 0 e' "<<somma<<endl;

    system("pause");
    return 0;
}