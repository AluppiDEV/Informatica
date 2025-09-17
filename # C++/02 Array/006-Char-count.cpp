#include <iostream>
#define DIM 10
using namespace std;

int main(int argc, char** argv) {
    char ch[DIM]={""};
    int nPresenti[DIM]={'\0'};

    cout<<"Inserisci la parola che desideri controllare ";
    cin>>ch;

    for (int i=0 ; i<DIM ; i++) {
        for (int j=0 ; j<DIM ; j++) {
            if (ch[i] == ch[j]) {
                nPresenti[i]++;
            }
        }
    }

    for (int i=0 ; i<DIM ; i++) {
        if (ch[i] != ch[i-1] && ch[i] != '\0') {
            cout<<ch[i]<<" ";
            cout<<nPresenti[i]<<","<<endl;
        }
    }


    system("pause");
    return 0;
}