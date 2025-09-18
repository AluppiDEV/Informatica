#include <iostream>
using namespace std;
/**
 ** Funzione per la realizzazione del menu
 */

void showMenu(string arr[], int size)
{
	cout << "MENU" << endl;
	for (int i = 0; i < size; i++)
	{
		cout << i + 1 << ". " << arr[i] << endl;
	}
	cout << "Scegli un'opzione: ";
}