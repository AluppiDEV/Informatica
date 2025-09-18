#include <iostream>
using namespace std;

bool analisi(int num);

int main() {

    system("cls");
    int numero;

    cout << "Inserisci il numero da controllare\n: ";
    cin >> numero;

    if (analisi(numero)) {
        cout << "Il numero " << numero << " e' primo!" << endl;
    } else {
        cout << "Il numero " << numero << " non e' primo!" << endl;
    }

    return 0;
}

bool analisi(int num) {
    if (num <= 1) {
        return false;
    }
    for (int i = 2; i <= num / 2; i++) {
        if (num % i == 0) {
            return false;
            break;
        }
    }
    return true; 
}