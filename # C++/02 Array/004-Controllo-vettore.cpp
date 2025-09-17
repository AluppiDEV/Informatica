#include <iostream>
#define DIM 10
using namespace std;

int main() {

    int arr[DIM], i, numero;

    //? scorre fino a quando non raggiunge la fine del vettore
    while (i<DIM) {
        bool esiste=false;

        cout<<"Scrivi il valore che vuoi inserire ";
        cin>>numero;

        //? controllo se il numero è già presente
        for (int j=0 ; j<i ; j++) {
            if (arr[j] == numero) {
                esiste=true;
            }
        }

        //? se il numero non è presente lo aggiunge all'array
        if (!esiste) {
            arr[i] = numero;
            cout<<"Inserimento avvenuto con successo "<<endl;
            i++;
        } else {
            cout<<"Numero gia inserito, perfavore inserirlo di nuovo "<<endl;
        }

    }

    cout<<"Vettore finale: ";
    for (int i=0 ; i<DIM ; i++) {
        cout<<arr[i]<<" ";
    }
    cout<<endl;

    system("pause");
    return 0;
}