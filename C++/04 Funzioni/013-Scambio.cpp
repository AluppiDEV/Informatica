#include <iostream>
using namespace std;

void cambio(int &a, int &b);

void ordinamento(int &a, int &b, int &c);

int main()
{

	int alfa, beta, gamma;

	cout << "Inserisci tre valori\n: ";
	cin >> alfa;
	cout << ": ";
	cin >> beta;
	cout << ": ";
	cin >> gamma;

	cout << "Valori non in ordine " << alfa << ", " << beta << ", " << gamma << endl;

	ordinamento(alfa, beta, gamma);

	cout << "Valori in ordine " << alfa << ", " << beta << ", " << gamma << endl;

	system("pause");
	return 0;
}

void cambio(int &a, int &b)
{
	int temp;
	temp = a;
	a = b;
	b = temp;
}

void ordinamento(int &a, int &b, int &c)
{
	if (a > b)
		cambio(a, b);
	if (b > c)
		cambio(b, c);
	if (a > b)
		cambio(a, b);
}