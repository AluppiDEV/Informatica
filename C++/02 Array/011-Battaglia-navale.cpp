#include <iostream>
#include <cstdlib>
#define DIM 30
#define SIZE 3
using namespace std;

int main() {

    string scelta;
    int line[DIM]{0,1,1,0,0,0,1,0,0,1,1,1,1,0,0,1,0,0,0,0,1,1,1,0,1,0,0,0,1,0};
    
    //! Lina finale 
    char soluction[DIM]{0,17,16,0,0,0,35,0,0,17,35,35,16,0,0,35,0,0,0,0,17,35,16,0,35,0,0,0,35,0};
    for (int i=0 ; i<DIM ; i++) {
        if (soluction[i]==0) {
            soluction[i]=126;
        } else if (soluction[i]==35) {
            soluction[i]=254;
        }
    }

    char giocata[DIM];
    for (int i=0 ; i<DIM ; i++) {
        giocata[i]=63;
    }
    int colpo=0, exit=0;
    bool gioca=true;

    cout<<"Benvenuto su battaglia navale, vuoi giocare? ";
    cin>>scelta;

    if (scelta=="no") {
        gioca=false;
    } else {
        gioca=true;
    }

    while (gioca) {

        do {
            cout<<"Dove vuoi colpire (1-30)? ";
            cin>>colpo;

            if (colpo>30) {
                cout<<"Colpo non valido, riprovare."<<endl;
            }
        }  while (colpo>30);

        if (line[colpo-1]==0) {
            //! Colpo in acqua
            cout<<"Peccato hai colpito acqua."<<endl;
            giocata[colpo-1]=126;
            
            //! Stampa la riga con le barche/acqua
            for (int i=0 ; i<DIM ; i++) {
                cout<<giocata[i]<<" ";
            }
            cout<<endl;

        } else if (line[colpo-1]==1) {
            exit++;
            
            line[colpo-1]=2;
            int i=colpo-1;
            bool trovatoAcqua;

            while (line[i]!=0 && line[i]!=1) {
                i++;
                if (line[i]==0) {
                    trovatoAcqua=true;
                } else if (line[i]==1) {
                    trovatoAcqua=false;
                }
            }

            if (!trovatoAcqua) {
                cout<<"Complimenti nave colpita."<<endl;
                giocata[colpo-1]=157;

                for (int i=0 ; i<DIM ; i++) {
                    cout<<giocata[i]<<" ";
                }
                cout<<endl<<endl;
            } else {
                i=colpo-1;
                while (line[i]!=0 && line[i]!=1) {
                    i--;
                    if (line[i]==0) {
                        trovatoAcqua=true;
                    } else if (line[i]==1) {
                        trovatoAcqua=false;
                    }
                }

                if (trovatoAcqua) {

                    cout<<"Complimenti nave colpita e affondata."<<endl;
                    giocata[colpo-1]=157;
                    line[colpo-1]=2;

                    for (int i=0 ; i<DIM ; i++) {
                        cout<<giocata[i]<<" ";
                    }
                    cout<<endl<<endl;
                } else {

                    cout<<"Complimenti nave colpita."<<endl;
                    giocata[colpo-1]=157;

                    for (int i=0 ; i<DIM ; i++) {
                        cout<<giocata[i]<<" ";
                    }
                    cout<<endl<<endl;
                }
            }
            
        }

        if (exit==13) {
            cout<<"Hai colpito e affondato tutte le barche, complimenti!"<<endl<<"Ecco la soluzione"<<endl;
            for (int i=0 ; i<DIM ; i++) {
                cout<<soluction[i]<<" ";
            }
            cout<<endl;
            gioca=false;
        }
    }


    system("pause");
    return 0;
}