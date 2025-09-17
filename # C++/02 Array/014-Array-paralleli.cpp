#include <iostream>
#define DIM 5
using namespace std;

int main() {
    
    string nomi[DIM];
    int voti[DIM], max=-999, min=999, indiceMin=-1, indiceMax=-1;

    for (int i=0 ; i<DIM ; i++) {
        cout<<"Inserisci il nome del "<<i+1<<" studente.";
        cin>>nomi[i];

        cout<<"Inserisci il voto del "<<i+1<<" studente.";
        cin>>voti[i];
    }

    cout<<endl;

    for (int i=0 ; i<DIM ; i++) {
        cout<<nomi[i]<<"\t"<<voti[i]<<endl;
    }

    for (int i=0 ; i<DIM ; i++) {
        if (voti[i]<min) {
            indiceMin=i;
            min=voti[i];
        } else if (voti[i]>max) {
            indiceMax=i;
            max=voti[i];
        }
    }

    cout<<endl;
    cout<<"Il voto piu' alto e' "<<voti[indiceMax]<<" preso da "<<nomi[indiceMax]<<endl;
    cout<<"Il voto piu' basso e' "<<voti[indiceMin]<<" preso da "<<nomi[indiceMin]<<endl;
    cout<<endl;


    system("pause");
    return 0;
}
