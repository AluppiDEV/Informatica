#include <iostream>
#include <string>
char apice = static_cast<char>(248), a = static_cast<char>(133), e = static_cast<char>(138);
using namespace std;

// Funzione ricorsiva per verificare se una stringa è palindroma
bool isPalindrome(const string &str, int start, int end)
{
	// Caso base: se l'inizio è maggiore o uguale alla fine, la stringa è palindroma
	if (start >= end)
	{
		return true;
	}
	// Controlla se i caratteri alle estremità sono uguali
	if (str[start] != str[end])
	{
		return false;
	}
	// Richiama la funzione con i caratteri interni
	return isPalindrome(str, start + 1, end - 1);
}

int main()
{
	string str;
	cout << "Inserisci una stringa: ";
	cin >> str;

	// Verifica se la stringa è palindroma
	if (isPalindrome(str, 0, str.length() - 1))
	{
		cout << "La stringa " << e << " palindroma." << endl;
	}
	else
	{
		cout << "La stringa non " << e << " palindroma." << endl;
	}

	return 0;
}