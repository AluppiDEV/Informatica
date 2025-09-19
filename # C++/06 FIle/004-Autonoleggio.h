#include <fstream>
#include <iostream>
#include <luppi.h>

struct Autonoleggio {
    string targa;
    string marca;
    string modello;
    int annoImmatricolazione;
    bool available;
};

ifstream fileIn;
ofstream fileOut;

void openfile(int type)
{
    if (type == 0) {
        fileIn.open("autonoleggio.txt");
        fileIn.seekg(0, ios::beg);
    } else if (type == 1) {
        fileOut.open("autonoleggio.txt");
        fileOut.seekp(0, ios::beg);
    } else if (type == 2) {
        fileOut.open("autonoleggio.txt", ios::app);
        fileOut.seekp(0, ios::end);
    }
    if (!fileOut.is_open() && !fileIn.is_open()) {
        cerr << "Errore nell'apertura del file!" << endl;
    }
}

void closefile()
{
    if (fileIn.is_open()) {
        fileIn.close();
    }
    if (fileOut.is_open()) {
        fileOut.close();
    }
}

int getDim()
{
    openfile(0);
    int dim = 0;
    string line;
    while (getline(fileIn, line)) {
        dim++;
    }
    closefile();
    return dim;
}

void loadFromData(Autonoleggio catalogo[])
{
    int dim = getDim();
    openfile(0);
    for (int i = 0; i < dim; i++) {
        fileIn >> catalogo[i].targa;
        fileIn >> catalogo[i].marca;
        fileIn >> catalogo[i].modello;
        fileIn >> catalogo[i].annoImmatricolazione;
        fileIn >> catalogo[i].available;
    }
    closefile();
}

void addAuto(Autonoleggio catalogo[])
{
    int dim = getDim();
    openfile(2);
    cout << "Inserisci la targa: ";
    cin >> catalogo[dim].targa;
    cout << "Inserisci la marca: ";
    cin >> catalogo[dim].marca;
    cout << "Inserisci il modello: ";
    cin >> catalogo[dim].modello;
    cout << "Inserisci l'anno di immatricolazione: ";
    cin >> catalogo[dim].annoImmatricolazione;
    catalogo[dim].available = true;
    fileOut << endl
            << catalogo[dim].targa << " "
            << catalogo[dim].marca << " "
            << catalogo[dim].modello << " "
            << catalogo[dim].annoImmatricolazione << " "
            << catalogo[dim].available << endl;
    closefile();
}

void elencoAuto(Autonoleggio catalogo[])
{
    int dim = getDim();
    for (int i = 0; i < dim; i++) {
        cout << "Targa: " << catalogo[i].targa << endl;
        cout << "Marca: " << catalogo[i].marca << endl;
        cout << "Modello: " << catalogo[i].modello << endl;
        cout << "Anno di immatricolazione: " << catalogo[i].annoImmatricolazione << endl;
        cout << "Disponibile: " << (catalogo[i].available ? "Si" : "No") << endl;
        cout << endl;
    }
}

void elencoAutoDisponibili(Autonoleggio catalogo[])
{
    int dim = getDim();
    for (int i = 0; i < dim; i++) {
        if (catalogo[i].available) {
            cout << "Targa: " << catalogo[i].targa << endl;
            cout << "Marca: " << catalogo[i].marca << endl;
            cout << "Modello: " << catalogo[i].modello << endl;
            cout << "Anno di immatricolazione: " << catalogo[i].annoImmatricolazione << endl;
            cout << endl;
        }
    }
}

void cercaAuto(Autonoleggio catalogo[])
{
    string targa;
    cout << "Inserisci la targa dell'auto da cercare: ";
    cin >> targa;

    int dim = getDim();
    for (int i = 0; i < dim; i++) {
        if (catalogo[i].targa == targa) {
            catalogo[i].available = !catalogo[i].available;
            cout << "Auto trovata! Disponibilità modificata." << endl;
            return;
        }
    }
    cout << "Auto non trovata!" << endl;
}
