#include <fstream>
#include <iostream>
#include <luppi.h>

struct Libro {
    string titolo;
    string autore;
    int anno;
    float prezzo;
};

ifstream fileIn;
ofstream fileOut;

void openfile(int type)
{
    if (type == 0) {
        fileIn.open("libreria.txt");
        fileIn.seekg(0, ios::beg);
    } else if (type == 1) {
        fileOut.open("libreria.txt");
        fileOut.seekp(0, ios::beg);
    } else if (type == 2) {
        fileOut.open("libreria.txt", ios::app);
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

void loadFromData(Libro catalogo[])
{
    int dim = getDim();
    openfile(0);
    for (int i = 0; i < dim; i++) {
        fileIn >> catalogo[i].titolo;
        fileIn >> catalogo[i].autore;
        fileIn >> catalogo[i].anno;
        fileIn >> catalogo[i].prezzo;
    }
    closefile();
}

void addBook(Libro catalogo[])
{
    int dim = getDim();
    openfile(2);
    cout << "Inserisci il titolo: ";
    cin.ignore();
    getline(cin, catalogo[dim].titolo);
    cout << "Inserisci l'autore: ";
    getline(cin, catalogo[dim].autore);
    cout << "Inserisci l'anno di pubblicazione: ";
    cin >> catalogo[dim].anno;
    cout << "Inserisci il prezzo: ";
    cin >> catalogo[dim].prezzo;

    fileOut << catalogo[dim].titolo << " "
            << catalogo[dim].autore << " "
            << catalogo[dim].anno << " "
            << catalogo[dim].prezzo << endl;

    closefile();
}

void elencoBook(Libro catalogo[])
{
    int dim = getDim();
    for (int i = 0; i < dim; i++) {
        cout << "Titolo: " << catalogo[i].titolo << endl
             << "Autore: " << catalogo[i].autore << endl
             << "Anno di pubblicazione: " << catalogo[i].anno << endl
             << "Prezzo: " << catalogo[i].prezzo << euro << endl
             << endl;
    }
}

void cercaLibroDaAnno(Libro catalogo[])
{
    int annoRicerca;
    cout << "Inserisci l'anno da cui partire a cercare: ";
    cin >> annoRicerca;

    int dim = getDim();
    bool trovato = false;
    for (int i = 0; i < dim; i++) {
        if (catalogo[i].anno >= annoRicerca) {
            cout << "Libro trovato!" << endl;
            cout << "Titolo: " << catalogo[i].titolo << endl;
            cout << "Autore: " << catalogo[i].autore << endl;
            cout << "Anno di pubblicazione: " << catalogo[i].anno << endl;
            cout << "Prezzo: " << catalogo[i].prezzo << euro << endl;
            cout << endl;
            trovato = true;
        }
    }
    if (!trovato) {
        cout << "Nessun libro trovato a partire dall'anno specificato!" << endl;
    }
}
