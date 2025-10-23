#include <iostream>
using namespace std;

void input(int &a, int &b, int &c);

int main()
{

	int alfa, beta, gamma;

	input(alfa, beta, gamma);

	cout << "Ecco il valore di alfa: " << alfa << endl;
	cout << "Ecco il valore di beta: " << beta << endl;
	cout << "Ecco il valore di gamma: " << gamma << endl;
}

void input(int &a, int &b, int &c)
{
	cout << "Inserisci il valore di alfa\n: ";
	cin >> a;
	cout << "Inserisci il valore di beta\n: ";
	cin >> b;
	cout << "Inserisci il valore di gamma\n: ";
	cin >> c;
}