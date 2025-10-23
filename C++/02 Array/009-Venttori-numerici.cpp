/*Dato un vettore numerico di N posizioni al primo elemento dispari stampare quanti valori diversi da
zero si sono incontrati, il numero dispari incontrato e la sua posizione nel vettore.*/
#include <iostream>
#define DIM 10
using namespace std;
char apice_numero = static_cast<char>(248), e_accentato = static_cast<char>(138);

int main() {

    int numeri[DIM], valori=0;

    for (int i=0 ; i<DIM ; i++) {
        cout<<"Inserici il "<<i+1<<apice_numero<<" numero nel vettore ";
        cin>>numeri[i];
    }

    int i=0;
    while (numeri[i]%2==0) {
        if (numeri[i]!=0) {
            valori++;
        }
        i++;
    }

    cout<<endl;

    if (numeri[i]%2!=0) {
        if (i==10) {
            cout<<"Non "<<e_accentato<<" stato trovto nessun valore dispari."<<endl;
        } else {
            cout<<"Sono stati incontrati "<<valori<<" valori diversi da 0 precdenti al numero dispari."<<endl;
            cout<<"Il valore dispari si trova nella cella numero: "<<i<<" ("<<i+1<<apice_numero<<" Inserimento)";
            cout<<" del vettore. In questa "<<e_accentato<<" contenuto il valore: "<<numeri[i]<<endl;
        }
    }
    cout<<endl;
    
    system("pause");
    return 0;
}