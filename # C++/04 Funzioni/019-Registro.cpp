#include <iostream>
#include <string>
#include "019-my_function.h"
#define DIM 30
#define opz 3
using namespace std;

/*
Con menu per scegliere se ordinamento crescente o decrescente
*/

int main(int argc, char const *argv[]){

    int scelta, Nstudenti=5;
    float voti[DIM]{10,3,5,7,8};
    string opzioni[opz], nomi[DIM]{"pippo", "topolino", "ntturbino", "albero", "frodo"};
    opzioni[0] = "Stampa in ordine crescente";
    opzioni[1] = "Stampa in ordine decrescente";
    opzioni[2] = "Esci";
    
    //cout<<"Inserisci il numero di studenti: ";
    //cin>>Nstudenti;

    //aggiuntaVoti(nomi, voti, Nstudenti);
    
    do{
    	system("cls");
        menu(opzioni, opz, scelta);
		
		system("cls");
        switch (scelta){
        case 1:
            ascBubbleSort(voti, Nstudenti, nomi);
            break;
        case 2:
			descBubbleSort(voti, Nstudenti, nomi);
            break;
        case 3:
            cout<<"Arrivederci!\n";
            break;
        default:
            cout<<"Comando non capito!\n";
            break;
        }
		
		system("pause");
    }while(scelta != 3);

    return 0;
}
