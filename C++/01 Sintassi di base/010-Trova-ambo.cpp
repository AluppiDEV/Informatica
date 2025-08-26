#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main()
{

    int primoNumero = 0, secondoNumero = 0;
    srand(time(0));
    bool indovinatoPrimo = false, indovinatoSecondo = false;

    cout << "Benvenuto!" << endl;
    cout << "Inserisci il primo numero che vuoi giocare " << endl;
    cin >> primoNumero;
    cout << "Inserisci il secondo numero che vuoi giocare " << endl;
    cin >> secondoNumero;

    for (int i = 0; i < 10; i++)
    {

        int numeroCasuale = (rand() % 90 + 1);

        cout << "E' uscito il numero " << numeroCasuale << endl;

        if (numeroCasuale == primoNumero)
        {
            cout << "Hai indovinato il primo numero" << endl
                 << endl;
            indovinatoPrimo = true;
        }
        else if (numeroCasuale == secondoNumero)
        {
            cout << "Hai indovinato il primo numero" << endl
                 << endl;
            indovinatoSecondo = true;
        }
        else
        {
            cout << "Purtroppo non hai indovinato" << endl
                 << endl;
        }
    }

    if (indovinatoPrimo == true && indovinatoSecondo == true)
    {
        cout << "Bravo hai vinto con i numeri " << primoNumero << " e il " << secondoNumero << endl;
    }
    else
    {
        if (indovinatoPrimo == true)
        {
            cout << "Purtroppo non hai vino ma hai comunque indovinato il numero " << primoNumero << ", andra' meglio la prossima volta " << endl;
        }
        else if (indovinatoSecondo == true)
        {
            cout << "Purtroppo non hai vino ma hai comunque indovinato il numero " << secondoNumero << ", andra' meglio la prossima volta " << endl;
        }
        else
        {
            cout << "Purtroppo non hai vino andra meglio la prossima volta " << endl;
        }
    }

    system("pause");
    return 0;
}
