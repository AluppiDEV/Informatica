#include <iostream>
#include <cstdlib>
#include <ctime>
#define DIM 30
using namespace std;

int main() {
    
	system("cls");
    srand(time(0));

    int tempGiorni[DIM], somma=0;
	float tempMedia;

    for (int i=0 ; i<DIM ; i++) {
        tempGiorni[i] = rand()% 51 -10;
    }

    for (int i=0 ; i<DIM ; i++) {
        somma+=tempGiorni[i];
    }
    tempMedia = somma/DIM;

    cout<<"La temperatura media e' di "<<tempMedia<<" gradi."<<endl;
    cout<<endl;

    cout<<"I giorni sotto la media sono:"<<endl<<"Giorno \t Temperatura"<<endl;
    for (int i=0 ; i<DIM ; i++) {
        if (tempGiorni[i]<tempMedia) {
            cout<<i+1<<"\t"<<tempGiorni[i]<<endl;
        }
    }

    cout<<endl;

    cout<<"I giorni sopra la media sono:"<<endl<<"Giorno \t Temperatura"<<endl;
    for (int i=0 ; i<DIM ; i++) {
        if (tempGiorni[i]>tempMedia) {
            cout<<i+1<<"\t"<<tempGiorni[i]<<endl;
        }
    }


    system("pause");
    return 0;
}