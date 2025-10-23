#include <iostream>
#include <luppi.h>
#define MAX 90

/*
*Registro Interventi di Soccorso
*Scrivi un programma in C che gestisca gli interventi effettuati dai mezzi di soccorso (ambulanza, vigili del fuoco, polizia).
*
*Ogni intervento deve essere rappresentato da una struttura (struct) contenente:
*
*	Codice intervento (intero)
*
*	Tipo di mezzo (stringa: "Ambulanza", "Vigili del Fuoco", "Polizia")
*
*	Ora dell'intervento (stringa nel formato HH:MM)
*
*	Luogo (stringa)
*
*	Esito (stringa: "Risolto", "In corso", "Non risolto")
*
*Il programma deve:
*
*	Permettere all'utente di inserire un numero variabile di interventi.
*
*	Ordinare gli interventi in base all'ora (ordine crescente).
*
*	Consentire la ricerca di un intervento dato il codice tramite ricerca binaria.
*
*	Visualizzare la lista ordinata degli interventi e l'esito della ricerca.
*
*	Filtraggio per tipo di mezzo, permettendo all’utente di visualizzare solo gli interventi di "Ambulanza", "Vigili del Fuoco" o "Polizia".
*
*	Statistiche sugli interventi, mostrando il numero totale di interventi per ogni tipo di mezzo.
*/

struct Soccorso {
	/* data */
	int id;
	string department;
	string time;
	string location;
	string state;
};

void addIntrevent(Soccorso intervento[], int& n);

void sortInterventiByTime(Soccorso intervento[], int n);

void sortInterventiByID(Soccorso intervento[], int n);

void showInterventi(Soccorso intervento[], int n);

void searchInterventi(Soccorso intervento[], int n);

void showInterventiByDepartment(Soccorso intervento[], int n);

void showStatistics(Soccorso intervento[], int n);

int main() {

	Soccorso interventi[MAX];
	int scelta;
	int nInterventi = 0;

	do {

		clear();

		showMenu({"___MENU___"},
		{
			"Aggiungi interventi",
			"Ordina gli interventi in base all'ora",
			"Ricerca un intervento",
			"Visualizza tutti gli interventi",
			"Visualizza gli interventi di un dipartimento",
			"Mostra statistiche sugli interventi"
		}, &scelta);

		switch (scelta) {
		case 1:
			addIntrevent(interventi, nInterventi);
			break;

		case 2:
			sortInterventiByTime(interventi, nInterventi);
			showInterventi(interventi, nInterventi);
			pausa();
			break;

		case 3:
			sortInterventiByID(interventi, nInterventi);
			showInterventi(interventi, nInterventi);
			searchInterventi(interventi, nInterventi);
			pausa();
			break;

		case 4:
			if (nInterventi == 0) {
				"Nessun intervento presente";
			}else {
				showInterventi(interventi, nInterventi);
			}
			pausa();
			break;

		case 5:
			showInterventiByDepartment(interventi, nInterventi);
			pausa();
			break;

		case 6:
			showStatistics(interventi, nInterventi);
			pausa();
			break;
		
		case 7:
			cout<<"Arrivederci"<<endl;
			break;
		default:
			cout<<"Comando non presente!"<<endl;
			break;
		}
	}  while (scelta != 7);

}

void addIntrevent(Soccorso intervento[], int& n) {
	int ToAdd = 0;
	cout<<"Quanti interventi desideri aggiungere\n: ";
	cin>>ToAdd;
	for	(size_t i=0 ; i<ToAdd ; i++) {

		int scelta;
		bool unique;
		do {
			unique = true;
			intervento[n].id = rand() % 90 + 10; // Genera un ID casuale tra 10 e 99
			for (int j = 0; j < n; j++) {
				if (intervento[n].id == intervento[j].id) {
					unique = false;
					break;
				}
			}
		} while (!unique);

		showMenu({"Inserisci il dipartimento di appartenenza: "},
		{
			"Ambulanza",
			"Pompieri",
			"Polizia"
		}, &scelta);
		intervento[n].department = (scelta == 1 ? "Ambulanza" : (scelta == 2 ? "Pompieri" : "Polizia"));


		cout<<"Inserisci l'orario\n: ";
		cin>>intervento[n].time;

		cout<<"Inserisci il luogo dell'avvenimento\n: ";
		cin>>intervento[n].location;

		showMenu({"Stato di avanzamento: "},
		{
			"Risolto",
			"in corso",
			"Non risolto"
		}, &scelta);
		intervento[n].state = (scelta == 1 ? "Risolto" : (scelta == 2 ? "In corso" : "Non risolto"));

		n++;
		updateAnimation(2);
	}
	
}

void sortInterventiByTime(Soccorso intervento[], int n) {
	bool swapped;
	for (int i = 0; i < n - 1; i++) {
		swapped = false;
		for (int j = 0; j < n - i - 1; j++) {
			if (intervento[j].time > intervento[j + 1].time) {
				Soccorso temp = intervento[j];
				intervento[j] = intervento[j + 1];
				intervento[j + 1] = temp;
				swapped = true;
			}
		}
		if (!swapped) {
			break;
		}
	}
}

void sortInterventiByID(Soccorso intervento[], int n) {
	bool swapped;
	for (int i = 0; i < n - 1; i++) {
		swapped = false;
		for (int j = 0; j < n - i - 1; j++) {
			if (intervento[j].id > intervento[j + 1].id) {
				Soccorso temp = intervento[j];
				intervento[j] = intervento[j + 1];
				intervento[j + 1] = temp;
				swapped = true;
			}
		}
		if (!swapped) {
			break;
		}
	}
}

void showInterventi(Soccorso intervento[], int n) {
	for (int i = 0; i < n; i++) {
		cout << "ID: " << intervento[i].id << ", "
			 << "Dipartimento: " << intervento[i].department << ", "
			 << "Ora: " << intervento[i].time << ", "
			 << "Luogo: " << intervento[i].location << ", "
			 << "Stato: " << intervento[i].state << endl;
	}
}

void searchInterventi(Soccorso intervento[], int n) {
	int id;
	cout << "Inserisci l'ID dell'intervento da cercare: ";
	cin >> id;

	int left = 0, right = n - 1;
	bool found = false;

	while (left <= right) {
		int mid = left + (right - left) / 2;

		if (intervento[mid].id == id) {
			cout << "Intervento trovato: " << endl;
			cout << "ID: " << intervento[mid].id << ", "
				 << "Dipartimento: " << intervento[mid].department << ", "
				 << "Ora: " << intervento[mid].time << ", "
				 << "Luogo: " << intervento[mid].location << ", "
				 << "Stato: " << intervento[mid].state << endl;
			found = true;
			break;
		}

		if (intervento[mid].id < id) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}

	if (!found) {
		cout << "Intervento con ID " << id << " non trovato." << endl;
	}
}


void showInterventiByDepartment(Soccorso intervento[], int n) {
	int scelta;
	showMenu({"Seleziona il dipartimento da visualizzare: "},
	{
		"Ambulanza",
		"Pompieri",
		"Polizia"
	}, &scelta);
	string department = (scelta == 1 ? "Ambulanza" : (scelta == 2 ? "Pompieri" : "Polizia"));

	for (int i = 0; i < n; i++) {
		if (intervento[i].department == department) {
			cout << "ID: " << intervento[i].id << ", "
				 << "Dipartimento: " << intervento[i].department << ", "
				 << "Ora: " << intervento[i].time << ", "
				 << "Luogo: " << intervento[i].location << ", "
				 << "Stato: " << intervento[i].state << endl;
		}
	}
}

void showStatistics(Soccorso intervento[], int n) {
	int risolto = 0, inCorso = 0, nonRisolto = 0;

	for (int i = 0; i < n; i++) {
		if (intervento[i].state == "Risolto") {
			risolto++;
		} else if (intervento[i].state == "In corso") {
			inCorso++;
		} else if (intervento[i].state == "Non risolto") {
			nonRisolto++;
		}
	}

	cout << "Statistiche degli interventi:" << endl;
	cout << "Risolto: " << risolto << endl;
	cout << "In corso: " << inCorso << endl;
	cout << "Non risolto: " << nonRisolto << endl;
}