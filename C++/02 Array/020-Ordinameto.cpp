#include <iostream>
#define DIM 5
using namespace std;

int main()
{

    system("cls");
    int stringa[DIM] { 1, 2, 3, 4, 5 }, temp, tempi;
    string ordinamento;

    for (int i = 0; i < DIM; i++) {
        cout << stringa[i];
    }

    while (true) {
        cout << endl;
        cout << "Verso dove vuoi andare destra o sinistra. ";
        cin >> ordinamento;

        if (ordinamento == "dx") {
            temp = stringa[DIM - 1];
            for (int i = 0; i < DIM - 1; i++) {
                tempi = stringa[i + 1];
                stringa[i + 1] = stringa[0];
                stringa[0] = tempi;
            }
            stringa[0] = temp;
        } else if (ordinamento == "sx") {
            temp = stringa[0];
            for (int i = 0; i < DIM - 1; i++) {
                tempi = stringa[DIM - i - 2];
                stringa[DIM - i - 2] = stringa[DIM - 1];
                stringa[DIM - 1] = tempi;
            }
            stringa[DIM - 1] = temp;
        }

        for (int i = 0; i < DIM; i++) {
            cout << stringa[i];
        }
    }

    system("pause");
    return 0;
}