#include <iostream>
#include <random>
using namespace std;

int main()
{

    random_device random;
    default_random_engine gen(random());
    uniform_int_distribution<> distribuzione(1, 100);
    int numeroDaIndovinare = distribuzione(gen);

    int tentativi = 0;
    int tentativo;
    bool indovinato = false;

    cout << "Benvenuto! Prova a indovinare il numero tra 1 e 100." << endl;

    do
    {
        cout << "Inserisci il tuo tentativo: ";
        cin >> tentativo;
        tentativi++;

        if (tentativo < numeroDaIndovinare)
        {
            cout << "Troppo basso!" << endl;
        }
        else if (tentativo > numeroDaIndovinare)
        {
            cout << "Troppo alto!" << endl;
        }
        else
        {
            cout << "Complimenti! Hai indovinato il numero " << numeroDaIndovinare
                 << " in " << tentativi << " tentativi." << endl;
            indovinato = true;
        }

    } while (!indovinato);

    system("pause");
    return 0;
}
