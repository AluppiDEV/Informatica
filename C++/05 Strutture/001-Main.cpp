#include <iostream>
#define DIM 2
using namespace std;

struct defStudent
{
	string nome;
	string cognome;
	int voto;
	bool religione;
};

void inserisciDati(defStudent &a);

int main()
{

	defStudent classe[DIM];

	for (int i = 0; i < DIM; i++)
	{
		inserisciDati(classe[i]);
	}

	for (int i = 0; i < DIM; i++)
	{
		cout << "Nome: " << classe[i].nome << ", Cognome: " << classe[i].cognome << ", Voto: " << classe[i].voto << ", Religione: " << (classe[i].religione ? "Si'" : "No") << endl;
	}

	return 0;
}

void inserisciDati(defStudent &a)
{
	cout << "Inserisci il nome: ";
	cin >> a.nome;

	cout << "Inserisci il cognome: ";
	cin >> a.cognome;

	cout << "Inserisci il voto: ";
	cin >> a.voto;

	cout << "Inserisci la religione (1 per S" << "i" << ", 0 per No): ";
	cin >> a.religione;
}