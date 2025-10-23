#include <iostream>
#include <sstream>
char apice = static_cast<char>(248), a = static_cast<char>(133), e = static_cast<char>(138);
using namespace std;

string sequence = "";

int somma(int num)
{
	if (num <= 1)
	{
		return num;
	}
	else
	{
		return somma(num - 2) + somma(num - 1);
	}
}

void generaSequenza(int num)
{
	for (int i = 1; i <= num; ++i)
	{
		sequence += to_string(somma(i)) + " - ";
	}
}

int main()
{
	int n;
	cout << "Inserisci gli n numeri da sommare: ";
	cin >> n;

	int risultato = somma(n);
	cout << "I " << n << " numeri sommati danno " << " " << e << " " << risultato << endl;
	generaSequenza(n);
	cout << "Sequenza: " << sequence << endl;

	return 0;
}