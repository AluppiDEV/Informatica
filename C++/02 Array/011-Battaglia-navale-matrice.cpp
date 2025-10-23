#include <iostream>
#include <cstdlib>
#define DIM 10
#define NBARECHE 10
using namespace std;

int main() {

    string scelta;
    bool gioca=true;

    int matrix[DIM][DIM]
    {
        1,1,0,0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,0,0,0,
        0,0,0,0,1,0,0,0,0,0,
        0,0,0,0,1,0,0,0,0,0,
        0,0,0,0,1,0,0,0,0,0,
        0,0,0,0,1,0,0,0,0,0,
        0,0,0,0,0,0,0,0,0,0,
        0,0,0,0,1,0,0,0,0,0,
        0,0,0,0,1,0,0,0,0,0,
        0,0,0,0,0,0,0,0,0,0,
    };
    /*
    for (int i=0 ; i<DIM ; i++) {
        for (int j=0 ; j<DIM ; j++) {
            matrix[i][j] = 0;
        }
    }
    */

    //! Verifica stamp matrice
    /*
    for (int i=0 ; i<DIM; i++) {
        cout<<"row ["<<i<<"] :";
        for (int j=0 ; j<DIM ; j++) {
            cout<<matrix[i][j]<<" ";
        }
        cout << "\n";
    }
    system("pause");
    */

    char giocata[DIM][DIM];
    for (int i=0 ; i<DIM ; i++) {
        for (int j=0 ; j<DIM ; j++) {
            giocata[i][j] = 63;
        }
    }

    int colpo[2]{0,0}, exit=0;

    cout<<"Benvenuto su battaglia navale, vuoi giocare? ";
    cin>>scelta;
    cout<<endl;

    if (scelta=="no") {
        gioca=false;
    } else {
        gioca=true;
    }

    //! stampa iniziale 
    for (int i=0 ; i<DIM; i++) {
        cout<<"row ["<<i<<"] : ";
        for (int j=0 ; j<DIM ; j++) {
            cout<<giocata[i][j]<<" ";
        }
        cout << "\n";
    }

    while (gioca) {

        cout<<endl;
        cout<<"Dove vuoi colpire (verticale)? ";
        cin>>colpo[0];
        cout<<"Dove vuoi colpire (orizontale)? ";
        cin>>colpo[1];
        cout<<endl;

        bool trovatoAcqua;
        int valoreCasella = matrix[colpo[0]-1][colpo[1]-1];
        int barche=0;

        if (valoreCasella==0) {

            //! pulizia messaggi precedenti
            system("cls");

            //! acqua
            cout<<"Peccato hai colpito acqua."<<endl;
            giocata[colpo[0]-1][colpo[1]-1] = 126;

            //! stampa matrice
            for (int i=0 ; i<DIM; i++) {
                cout<<"row ["<<i<<"] :";
                for (int j=0 ; j<DIM ; j++) {
                    cout<<giocata[i][j]<<" ";
                }
                cout << "\n";
            }

        } else if (valoreCasella==1) {

            int i=0;
            exit++;
            giocata[colpo[0]-1][colpo[1]-1] = 157;
            matrix[colpo[0]-1][colpo[1]-1] = 2;

            //! controlli verticali
            //* sopra
            i=colpo[0]-1;
            while (matrix[i][colpo[1]-1]!=0) {
                i++;
                if (matrix[i][colpo[1]-1]==0) {
                    trovatoAcqua=true;
                } else if (matrix[i][colpo[1]-1]==1) {
                    barche++;
                }
            }
            //* sotto
            i=colpo[0]-1;
            while (matrix[i][colpo[1]-1]!=0) {
                i--;
                if (matrix[i][colpo[1]-1]==0) {
                    trovatoAcqua=true;
                } else if (matrix[i][colpo[1]-1]==1) {
                    barche++;
                }
            }
            //! controlli orizzontali
            //* destra
            i=colpo[1]-1;
            while (matrix[colpo[0]-1][i]!=0) {
                i++;
                if (matrix[colpo[0]-1][i]==0) {
                    trovatoAcqua=true;
                } else if (matrix[colpo[0]-1][i]==1) {
                    barche++;
                }
            }
            //* sinistra
            i=colpo[1]-1;
            while (matrix[colpo[0]-1][i]!=0) {
                i--;
                if (matrix[colpo[0]-1][i]==0) {
                    trovatoAcqua=true;
                } else if (matrix[colpo[0]-1][i]==1) {
                    barche++;
                }
            }

            if (barche>0) {

                //! pulizia messaggi precedenti
                system("cls");

                //! barca colpita
                cout<<"Complimenti hai colpito una barca!"<<endl;

                //! stampa matrice
                for (int i=0 ; i<DIM; i++) {
                    cout<<"row ["<<i<<"] :";
                    for (int j=0 ; j<DIM ; j++) {
                        cout<<giocata[i][j]<<" ";
                    }
                    cout << "\n";
                }
            } else {

                //! pulizia messaggi precedenti
                system("cls");

                //! barca affondata
                cout<<"Complimenti hai colpito e affondato una barca!"<<endl;

                //! stampa matrice
                for (int i=0 ; i<DIM; i++) {
                    cout<<"row ["<<i<<"] :";
                    for (int j=0 ; j<DIM ; j++) {
                        cout<<giocata[i][j]<<" ";
                    }
                    cout << "\n";
                }
            }
        }

        if (exit==NBARECHE) {
            cout<<"Complimenti hai completato tutta la griglia! \n Ecco la soluzione finale: \n";
            for (int i=0 ; i<DIM; i++) {
                cout<<"row ["<<i<<"] :";
                for (int j=0 ; j<DIM ; j++) {
                    cout<<matrix[i][j]<<" ";
                }
                cout << "\n";
            }
        }

    }


    system("pause");
    return 0;
}