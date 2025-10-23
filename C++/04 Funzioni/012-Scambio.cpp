#include <iostream>
using namespace std;

void cambio(int &a, int &b);

int main()
{

	int alfa, beta;

	cout << "Inserisci due valori\n: ";
	cin >> alfa;
	cout << ": ";
	cin >> beta;

	cout << "Valori prima del cambio:\nalfa = " << alfa << "\nbeta = " << beta << endl;

	cambio(alfa, beta);

	cout << "Valori dopo il cambio:\nalfa = " << alfa << "\nbeta = " << beta << endl;

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