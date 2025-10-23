#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 10
using namespace std;

int main() {

    int arr[DIM];
    srand(time(0));

    for (int i=0 ; i<DIM ; i++) {
        arr[i] = rand() % 100 + 1;
    }

    for (int i=0 ; i<DIM ; i++) {
        cout<<arr[i]<<endl;
    }

    cout<<endl;

    for (int i=0 ; i<DIM ; i++) {
        cout<<arr[DIM-1-i]<<endl;
    }


    system("pause");
    return 0;
}