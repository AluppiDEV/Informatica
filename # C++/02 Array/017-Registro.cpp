#include <cstdlib>
#include <ctime>
#include <iostream>
#define DIM 20
using namespace std;

/*
Si ha un elenco di N studenti, formato da nome, classe, giudizio scritto, giudizio orale. Determinare:
 nome e classe dello studente con migliore giudizio scritto;
 nome e classe dello studente con peggiore giudizio scritto;
 nome e classe dello studente con migliore giudizio orale;
 nome e classe dello studente con peggiore giudizio orale;
 nome e classe dello studente con migliore giudizio globale;
 nome e classe dello studente con peggiore giudizio globale;
 percentuale dei promossi e dei respinti.
*/

int main(int argc, char const* argv[])
{
	system("cls");
    srand(time(0));

    string nome[DIM], nomeRand[]{"Alessandro", "Martina", "Federico", "Giulia", "Lorenzo", "Sofia", "Matteo", "Chiara", "Francesco", "Elena", "Marco", "Valentina", "Andrea", "Sara", "Davide", "Alice", "Simone", "Beatrice", "Luca", "Gaia"};
    string cognome[DIM], cognomeRand[]{"Rossi", "Bianchi", "Ferrari", "Esposito", "Ricci", "Mariani", "Galli", "Conti", "Fontana", "Santini", "Barbieri", "Lombardi", "Moretti", "Testa", "Giordano", "Greco", "De Luca", "Colombo", "Mancini", "Romano"};
	string classe[DIM], classeRand[]{"1A", "1B",  "2A", "2B",  "3A", "3B",  "4A", "4B",  "5A", "5B"};
    int select=0, mOr=0, mSc=0, mMe=0, pOr=10, pSc=10, pMe=10, indici[]{-1, -1, -1, -1, -1, -1};
	float nProm, nBoc;
	float votoOr[DIM], votoSc[DIM];
    float media[DIM];

	for (int i=0 ; i<DIM ; i++) {
		//! Genero i voti
		votoOr[i] = rand() % 10 + 1;
		votoSc[i] = rand() % 10 + 1;

		//! Genero i nomi
		select = rand() % DIM;
		nome[i] = nomeRand[select];

		//! Genero i cognomi
		select = rand() % DIM;
		cognome[i] = cognomeRand[select];

		//! Genero la classe
		select = rand() % 10;
		classe[i] = classeRand[select];

		//! Calcolo media
		media[i] = (votoOr[i] + votoSc[i]) / 2;

		//! Controllo voti orali
		if (votoOr[i]>mOr) {
			mOr = votoOr[i];
			indici[0] = i;
		} else if (votoOr[i]<pOr) {
			pOr = votoOr[i];
			indici[1] = i;
		}

		//! Controllo voti scritti
		if (votoSc[i]>mSc) {
			mSc = votoSc[i];
			indici[2] = i;
		} else if (votoSc[i]<pSc) {
			pSc = votoSc[i];
			indici[3] = i;
		}

		//! Controllo media
		if (media[i]>mMe) {
			mMe = media[i];
			indici[4] = i;
		} else if (media[i]<pMe) {
			pMe = media[i];
			indici[5] = i;
		}

		//! Controllo promossi/bocciati
		if (media[i]>=6) {
			nProm++;
		} else {
			nBoc++;
		}
	}
	
	cout<<"Studente con il migliore voto scritto: "<<endl;
	cout<<nome[indici[2]]<<" "<<cognome[indici[2]]<<" "<<classe[indici[2]]<<" -> Con valutazione scritta di: "<<votoSc[indici[2]]<<endl<<endl;

	cout<<"Studente con il peggiore voto scritto: "<<endl;
	cout<<nome[indici[3]]<<" "<<cognome[indici[3]]<<" "<<classe[indici[3]]<<" -> Con valutazione scritta di: "<<votoSc[indici[3]]<<endl<<endl;

	cout<<"Studente con il migliore voto orale: "<<endl;
	cout<<nome[indici[0]]<<" "<<cognome[indici[0]]<<" "<<classe[indici[0]]<<" -> Con valutazione orale di: "<<votoSc[indici[0]]<<endl<<endl;

	cout<<"Studente con il peggiore voto orale: "<<endl;
	cout<<nome[indici[1]]<<" "<<cognome[indici[1]]<<" "<<classe[indici[1]]<<" -> Con valutazione orale di: "<<votoSc[indici[1]]<<endl<<endl;

	cout<<"Studente con la migliore voto orale: "<<endl;
	cout<<nome[indici[4]]<<" "<<cognome[indici[4]]<<" "<<classe[indici[4]]<<" -> Con la media di: "<<votoSc[indici[4]]<<endl<<endl;

	cout<<"Studente con la peggiore media orale: "<<endl;
	cout<<nome[indici[5]]<<" "<<cognome[indici[5]]<<" "<<classe[indici[5]]<<" -> Con la media di: "<<votoSc[indici[5]]<<endl<<endl;

	cout<<"La percentuale dei promoddi e' "<<(nProm/DIM)*100<<"% mentre quello dei boccaiti e' "<<(nBoc/DIM)*100<<"%"<<endl<<endl;

	system("pause");
    return 0;
}
