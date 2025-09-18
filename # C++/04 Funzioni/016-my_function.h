#include <iostream>
using namespace std;
char a = static_cast<char>(133), e = static_cast<char>(138);

void clear()
{
	system("cls");
}

void show(string names[], int amount[], int &numProducts)
{
	cout << "Ecco i prodotti disponibili:" << endl;
	for (int i = 0; i < numProducts; i++)
	{
		cout << i + 1 << ") " << names[i] << " - #" << amount[i] << endl;
	}
}

void slide(string names[], int amount[], int &numProducts, int index)
{
	for (int i = index; i < numProducts - 1; i++)
	{
		names[i] = names[i + 1];
		amount[i] = amount[i + 1];
	}
}

void search(int &choice, int &number)
{
	cout << "Seleziona prodotto\n: ";
	cin >> choice;
	cout << "Inserisci la quantit" << a << "\n: ";
	cin >> number;
}

void addProducts(string names[], int amount[], int &numProducts)
{
	cout << "Inserisci il nome del prodotto\n: ";
	cin >> names[numProducts];

	cout << "Inserisci la quatit" << a << " del prodotto\n: ";
	cin >> amount[numProducts];

	numProducts++;
	cout << "Prodotto inserito correttamente!" << endl;
}

void sell(string names[], int amount[], int &numProducts)
{
	int choice, number;
	show(names, amount, numProducts);
	search(choice, number);
	if (amount[choice - 1] - number <= 0)
	{
		cout << "Il prodotto " << e << " esaurito procedo con la rimozione.";
		slide(names, amount, numProducts, choice - 1);
		numProducts--;
	}
	else
	{
		amount[choice - 1] -= number;
	}
}

void add(string names[], int amount[], int &numProducts)
{
	int choice, number;
	show(names, amount, numProducts);
	search(choice, number);
	amount[choice - 1] += number;
}