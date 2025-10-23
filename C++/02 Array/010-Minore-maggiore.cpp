#include <iostream>
#include <limits>
#define DIM 10
using namespace std;
char apice_numero = static_cast<char>(248), e_accentato = static_cast<char>(138);

int main()
{

    int arr[DIM]{0};
    int max = numeric_limits<int>::min();
    int min = numeric_limits<int>::max();
    int indiceMax, indiceMin;

    for (int i = 0; i < DIM; i++)
    {
        cout << "Inserisci il " << i + 1 << apice_numero << " della lista.";
        cin >> arr[i];
    }

    for (int i = 0; i < DIM; i++)
    {
        if (arr[i] > max)
        {
            max = arr[i];
            indiceMax = i;
        }
        else if (arr[i] < min)
        {
            min = arr[i];
            indiceMin = i;
        }
    }

    cout << endl;
    cout << "Il valorre massimo trovato " << e_accentato << " il " << max << " di indice " << indiceMax << " (" << indiceMax + 1 << apice_numero << " inserimento)" << endl;
    cout << "Il valorre massimo trovato " << e_accentato << " il " << min << " di indice " << indiceMin << " (" << indiceMin + 1 << apice_numero << " inserimento)" << endl;
    cout << endl;

    system("pause");
    return 0;
}