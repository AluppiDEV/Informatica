#include <iostream>
#define DIM 10
using namespace std;

int main(int argc, char** argv) {
    char ch[DIM], lettera[2];
    int nPresenti=0;
    bool presente=false;

    cout<<"Inserisci la parola che desideri controllare ";
    cin>>ch;

    cout<<"Inserisci la lettera che vuoi controllare ";
    cin>>lettera;

    for (int i=0 ; i<DIM ; i++) {
        if (lettera[0] == ch[i]) {
            nPresenti++;
            presente=true;
            //cout<<"Lettera presente"<<endl;
        } else {
            //cout<<"Lettera non presente"<<endl;
        }
    }

    if (presente) {
        cout<<"La lettera "<<lettera<<" e' presente nella parola "<<ch<<" per "<<nPresenti<<" volte"<<endl;
    } else {
        cout<<"La lettera "<<lettera<<" non e' presente nella parola "<<ch<<endl;
    }

    system("pause");
    return 0;
}