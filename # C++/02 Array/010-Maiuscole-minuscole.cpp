#include <iostream>
#define DIM 15
using namespace std;

int main() {

    char minuscole[DIM], maiuscole[DIM]{0};

    cout<<"Inserisci la parola che desideri trasformare in maiuscolo. ";
    cin>>minuscole;

    for (int i=0 ; i<DIM ; i++) {
        if (minuscole[i]>=97 and minuscole[i]<=122) {
            maiuscole[i]=minuscole[i]-32;
        } else {
            maiuscole[i]=minuscole[i];
        }
    }

    cout<<maiuscole<<endl;

    system("pause");
    return 0;
}