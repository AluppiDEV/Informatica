#include <fstream>
#include <iostream>
#include <luppi.h>
#include <string>
using namespace std;

struct Studente {
    string nome;
    string cognome;
    string media;
    string classe;
};

ifstream fileInput;
ofstream fileOutput;

void openFileInput()
{
    fileInput.open("data.txt");
    if (!fileInput.is_open()) {
        cerr << "Errore durate l'apertura del file!";
    }
}

void openFileOutput()
{
    fileOutput.open("data.txt");
    if (!fileOutput.is_open()) {
        cerr << "Errore durate l'apertura del file!";
    }
}

int getDim()
{
    openFileInput();
    int dim;
    string line;
    getline(fileInput, line);
    dim = stoi(line);
    fileInput.close();
    return dim;
}

void loadFromData(Studente alunno[])
{
    openFileInput();
    int dim;
    int word;
    string line, input;
    getline(fileInput, line);
    if (line.length() == 1) {
        dim = stoi(line);
        for (int i = 0; i < dim; i++) {
            line = "";
            word = 0;
            getline(fileInput, line);
            for (int j = 0; j < line.length() + 1; j++) {
                if (line[j] != ' ' && line[j] != '\0') {
                    input += line[j];
                } else {
                    word++;
                    switch (word) {
                    case 1:
                        alunno[i].nome = input;
                        break;
                    case 2:
                        alunno[i].cognome = input;
                        break;
                    case 3:
                        alunno[i].media = input;
                        break;
                    case 4:
                        alunno[i].classe = input;
                        break;
                    }
                    input = "";
                }
            }
        }
    }
    fileInput.close();
}

void showElenco(Studente alunno[])
{
    int dim = getDim();
    for (int i = 0; i < dim; i++) {
        cout << "Studente " << i + 1 << ": " << endl;
        cout << "Nome: " << alunno[i].nome << endl;
        cout << "Cognome: " << alunno[i].cognome << endl;
        cout << "Media: " << alunno[i].media << endl;
        cout << "Classe: " << alunno[i].classe << endl;
        cout << "--------------------------" << endl;
    }
}

void addStudent(Studente alunno[])
{
    int dim = getDim();
    cin.ignore();
    cout << "Inserisci il nome del nuovo studente: ";
    getline(cin, alunno[dim].nome);
    cout << "Inserisci il cognome del nuovo studente: ";
    getline(cin, alunno[dim].cognome);
    cout << "Inserisci la media del nuovo studente: ";
    getline(cin, alunno[dim].media);
    cout << "Inserisci la classe del nuovo studente: ";
    getline(cin, alunno[dim].classe);
    openFileOutput();
    fileOutput << dim + 1 << endl;
    for (int i = 0; i <= dim; i++) {
        fileOutput << alunno[i].nome << " "
                   << alunno[i].cognome << " "
                   << alunno[i].media << " "
                   << alunno[i].classe << endl;
    }
    fileOutput.close();
}

void searchStudentBySurname(Studente alunno[])
{
    int dim = getDim();
    string cognomeCercato;
    cin.ignore();
    cout << "Inserisci il cognome dello studente da cercare: ";
    getline(cin, cognomeCercato);

    bool found = false;
    for (int i = 0; i < dim; i++) {
        if (alunno[i].cognome == cognomeCercato) {
            cout << "Studente trovato:" << endl;
            cout << "Nome: " << alunno[i].nome << endl;
            cout << "Cognome: " << alunno[i].cognome << endl;
            cout << "Media: " << alunno[i].media << endl;
            cout << "Classe: " << alunno[i].classe << endl;
            found = true;
            break;
        }
    }

    if (!found) {
        cout << "Studente con cognome \"" << cognomeCercato << "\" non trovato." << endl;
    }
}

void modifyStudent(Studente alunno[])
{
    int dim = getDim();
    string cognomeCercato;
    cin.ignore();
    cout << "Inserisci il cognome dello studente da modificare: ";
    getline(cin, cognomeCercato);

    bool found = false;
    for (int i = 0; i < dim; i++) {
        if (alunno[i].cognome == cognomeCercato) {
            cout << "Studente trovato. Inserisci i nuovi dati:" << endl;
            cout << "Nome attuale: " << alunno[i].nome << ". Nuovo nome: ";
            getline(cin, alunno[i].nome);
            cout << "Cognome attuale: " << alunno[i].cognome << ". Nuovo cognome: ";
            getline(cin, alunno[i].cognome);
            cout << "Media attuale: " << alunno[i].media << ". Nuova media: ";
            getline(cin, alunno[i].media);
            cout << "Classe attuale: " << alunno[i].classe << ". Nuova classe: ";
            getline(cin, alunno[i].classe);

            openFileOutput();
            fileOutput << dim << endl;
            for (int j = 0; j < dim; j++) {
                fileOutput << alunno[j].nome << " "
                           << alunno[j].cognome << " "
                           << alunno[j].media << " "
                           << alunno[j].classe << endl;
            }
            fileOutput.close();

            found = true;
            updateAnimation(2);
            // cout << "Dati dello studente aggiornati con successo." << endl;
            break;
        }
    }

    if (!found) {
        cout << "Studente con cognome \"" << cognomeCercato << "\" non trovato." << endl;
    }
}

void deleteStudent(Studente alunno[])
{
    int dim = getDim();
    string cognomeCercato;
    cin.ignore();
    cout << "Inserisci il cognome dello studente da eliminare: ";
    getline(cin, cognomeCercato);

    bool found = false;
    for (int i = 0; i < dim; i++) {
        if (alunno[i].cognome == cognomeCercato) {
            found = true;
            for (int j = i; j < dim - 1; j++) {
                alunno[j] = alunno[j + 1];
            }
            dim--;
            break;
        }
    }

    if (found) {
        openFileOutput();
        fileOutput << dim << endl;
        for (int i = 0; i < dim; i++) {
            fileOutput << alunno[i].nome << " "
                       << alunno[i].cognome << " "
                       << alunno[i].media << " "
                       << alunno[i].classe << endl;
        }
        fileOutput.close();
        cout << "Studente eliminato con successo." << endl;
    } else {
        cout << "Studente con cognome \"" << cognomeCercato << "\" non trovato." << endl;
    }
}

void sortAndPrint(Studente alunno[], bool sortByMedia)
{
    int dim = getDim();

    // Sorting logic
    for (int i = 0; i < dim - 1; i++) {
        for (int j = i + 1; j < dim; j++) {
            if ((sortByMedia && alunno[i].media > alunno[j].media) || (!sortByMedia && alunno[i].nome > alunno[j].nome)) {
                Studente temp = alunno[i];
                alunno[i] = alunno[j];
                alunno[j] = temp;
            }
        }
    }

    // Print sorted list
    showElenco(alunno);
}