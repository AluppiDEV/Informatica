#include <iostream>
using namespace std;

int main()
{

    string categoria;
    int i = 0, j = 0, numeroUomini = 0, numeroDonne = 0, numeroBambini = 0, numeroTotale = 0;

    do
    {

        do
        {
            if (i == 1)
            {
                cout << "Valore non valido inserire di nuovo " << endl;
            }
            i = 1;

            cout << "A che categoria appartieni (U = Uomo, D = Donna, B = Bambino), F per terminare ";
            cin >> categoria;

        } while (categoria != "U" && categoria != "D" && categoria != "B" && categoria != "F");

        if (categoria == "U")
        {
            numeroUomini++;
            numeroTotale++;
        }
        else if (categoria == "D")
        {
            numeroDonne++;
            numeroTotale++;
        }
        else if (categoria == "B")
        {
            numeroBambini++;
            numeroTotale++;
        }

        i = 0;
    } while (categoria != "F");

    cout << endl
         << "I partecipanti totali sono " << numeroTotale << endl;
    cout << endl
         << "I partecipanti uomini sono " << numeroUomini << endl;

    cout << "Uomini ";
    for (j = 0; j < numeroUomini; j++)
    {
        cout << "U";
    }

    cout << endl
         << "Le partecipanti donne sono " << numeroDonne << endl;

    cout << "Donne ";
    for (j = 0; j < numeroDonne; j++)
    {
        cout << "D";
    }

    cout << endl
         << "I partcipanti bambini sono " << numeroBambini << endl;

    cout << "Bambini ";
    for (j = 0; j < numeroBambini; j++)
    {
        cout << "B";
    }

    cout << endl;
    system("pause");
    return 0;
}