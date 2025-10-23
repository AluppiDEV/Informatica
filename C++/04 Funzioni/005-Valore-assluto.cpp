#include <iostream>
using namespace std;

double valoreAssoluto(double numero);

int main() {

    system("clear");
    double num;

    cout<<"Inserisci un numero: ";
    cin>>num;

    cout<<"Il valore assoluto di "<<num<<" e "<<valoreAssoluto(num)<<endl;

    return 0;
}

double valoreAssoluto(double numero) {
    if (numero < 0) {
        return -numero;
    }
    return numero;
}