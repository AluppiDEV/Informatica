

#include <iostream>
#include <climits>
#define WEEK 7
using namespace std;

/*
1.Usa un array di 7 elementi per memorizzare le vendite giornaliere (tipo float).
2.Implementa le seguenti funzioni:
*/
void inserisciVendite(float vendite[], int giorni);
//* Permette all'utente di inserire le vendite per giorni (7) giorni.
void stampaVendite(float vendite[], int giorni);
//* Stampa le vendite giornaliere.
float calcolaVenditeTotali(float vendite[], int giorni);
//* Calcola e restituisce il totale delle vendite.
float trovaVenditaMassima(float vendite[], int giorni);
//* Trova e restituisce la vendita massima della settimana.
int contaGiorniSottoSoglia(float vendite[], int giorni, float soglia);
//* Conta i giorni in cui le vendite sono state inferiori a una soglia specificata dall'utente.
/*
3.Scrivi un menu principale che consenta all'utente di:

Inserire i dati delle vendite
Stampare le vendite giornaliere
Calcolare il totale delle vendite
Trovare la vendita massima
Contare i giorni con vendite sotto una soglia
Uscire dal programma
*/

void inserisciVendite(float vendite[], int giorni);

void stampaVendite(float vendite[], int giorni);

float calcolaVenditeTotali(float vendite[], int giorni);

float trovaVenditaMassima(float vendite[], int giorni);

int contaGiorniSottoSoglia(float vendite[], int giorni, float soglia);

int main(int argc, char **argv)
{

	int scelta, daysBelowThreshold;
	float vendite[WEEK], totVendite, maxVendite, soglia;

	do
	{
		cout << "1. Inserire i dati delle vendite\n2. Stampare le vendite giornaliere\n3. Calcolare il totale delle vendite\n";
		cout << "4. Trovare la vendita massima\n5. Contare i giorni con vendite sotto una soglia\n6. Uscire dal programma\n: ";
		cin >> scelta;

		system("cls");
		switch (scelta)
		{
		case 1:
			inserisciVendite(vendite, WEEK);
			break;
		case 2:
			stampaVendite(vendite, WEEK);
			break;
		case 3:
			totVendite = calcolaVenditeTotali(vendite, WEEK);
			cout << "Le vendite totali sono state: " << totVendite << endl;
			break;
		case 4:
			maxVendite = trovaVenditaMassima(vendite, WEEK);
			cout << "La vendita massima e' stata: " << maxVendite << endl;
			break;
		case 5:
			cout << "Imposta la soglia: ";
			cin >> soglia;
			daysBelowThreshold = contaGiorniSottoSoglia(vendite, WEEK, soglia);
			cout << "I giorni sotto alla soglia sono stati: " << daysBelowThreshold << endl;
			break;
		case 6:
			cout << "Arrivederci!\n";
			break;
		}

		system("pause");
		system("cls");
	} while (scelta != 6);

	return 0;
}

void inserisciVendite(float vendite[], int giorni)
{
	for (int i = 0; i < giorni; i++)
	{
		cout << "inserisci le vendite del " << i + 1 << " giorno: ";
		cin >> vendite[i];
	}
}

void stampaVendite(float vendite[], int giorni)
{
	for (int i = 0; i < giorni; i++)
	{
		cout << "Vendite del " << i + 1 << " giorno: " << vendite[i] << endl;
	}
}

float calcolaVenditeTotali(float vendite[], int giorni)
{
	float tot = 0;

	for (int i = 0; i < giorni; i++)
	{
		tot += vendite[i];
	}

	return tot;
}

float trovaVenditaMassima(float vendite[], int giorni)
{
	float Max = INT_MIN;

	for (int i = 0; i < giorni; i++)
	{
		if (vendite[i] > Max)
		{
			Max = vendite[i];
		}
	}

	return Max;
}

int contaGiorniSottoSoglia(float vendite[], int giorni, float soglia)
{
	int count = 0;

	for (int i = 0; i < giorni; i++)
	{
		if (vendite[i] < soglia)
		{
			count++;
		}
	}

	return count;
}