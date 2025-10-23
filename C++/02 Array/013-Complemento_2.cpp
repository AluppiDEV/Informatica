#include <iostream>
#define DIM 8

/*
programma che acquisisce due vettori in input che contengano un umero binario di 8 bit, 
fare somma in complemento a 2 componendo il risultato in un terzo vettore.
*/
using namespace std;
int main() {
	
	int Num1[DIM]={0}, Num2[DIM]={0}, Somma[DIM]={0}, Nvalori=0,Vriporto[DIM]={0,0,0,0,0,0,0,1};
	bool riporto=false, negativo1=false, negativo2=false;
	
	for(int i=0; i<DIM; i++){
		cout<<"inserisci il " <<i+1 <<" valore del primo numero binario: ";
		cin>>Num1[i];
	}
	
	for(int i=0; i<DIM; i++){
		cout<<"inserisci il " <<i+1 <<" valore del secodno numero binario: ";
		cin>>Num2[i];
	}
	
	cout<<endl;
	//controlla se il primo numero inserito � negativo, in caso li converte in complemento a2
	if(Num1[0] == 1){
		negativo1=true;
		cout<<"il primo numero e' risulato negativo, ecco il numero in complemento a 2: ";
		for(int i=0; i<DIM; i++){
			switch(Num1[i]){
				case 1:
					Num1[i]=0;
					break;
				case 0:
					Num1[i]=1;
					break;
			}
			cout<<Num1[i];
		}
		cout<<endl;
	}
	
	//controlla se il secondo numero inserito � negativo, in caso li converte in complemento a2
	if(Num2[0] == 1){
		negativo2=true;
		cout<<"il secondo numero e' risulato negativo, ecco il numero in complemento a 2: ";
		for(int i=0; i<DIM; i++){
			switch(Num2[i]){
				case 1:
					Num2[i]=0;
					break;
				case 0:
					Num2[i]=1;
					break;
			}
			cout<<Num2[i];
		}
		cout<<endl;
	}
	
	cout<<"il risultato della somma e': ";
	for(int i=0; i<DIM; i++){
		if (riporto && i<DIM){
			Somma[DIM-1-i]+=1;
			riporto=false;
		} else if (riporto){
			Somma[DIM-1-i]+=1;
		}
		
		Somma[DIM-1-i]+=Num1[DIM-1-i]+Num2[DIM-1-i];
		
		switch(Somma[DIM-1-i]){
			case 2:
				Somma[DIM-1-i]=0;
				riporto=true;
				break;
			case 3: 
				Somma[DIM-1-i]=1;
				riporto=true;
				break;
		}
	}
	
	//stampo la somma
	for(int i=0; i<DIM; i++){
		cout<<Somma[i];
	}
	cout<<endl;
	
	//se i numeri erano negativi, aggiusto con la regola del complemento a 2
	cout<<"il risultato correto e': ";
	if(negativo1 && negativo2){
		
		
		for(int i=0; i<DIM; i++){
			if (riporto && i<DIM){
				Somma[DIM-1-i]+=1;
				riporto=false;
			} else if (riporto){
				Somma[DIM-1-i]+=1;
			}
		
			Somma[DIM-1-i]+=Vriporto[DIM-1-i];
		
			switch(Somma[DIM-1-i]){
			case 2:
					Somma[DIM-1-i]=0;
					riporto=true;
					break;
			case 3: 
					Somma[DIM-1-i]=1;
					riporto=true;
					break;
			}
		}
	
		for(int i=0; i<DIM; i++){
			cout<<Somma[i];
		}
		
	} else if (negativo1 || negativo2 && Somma[0]==1){
		
		for(int i=0; i<DIM; i++){
			switch(Somma[i]){
				case 1:
					Somma[i]=0;
					break;
				case 0:
					Somma[i]=1;
					break;
			}
			cout<<Somma[i];
		}
	}
	cout<<endl;

	system("pause");
	return 0;
}
