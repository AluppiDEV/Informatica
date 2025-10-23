#include <iostream>
using namespace std;

void toUpperCase(char str[]);
void toLowerCase(char str[]);

int main()
{
    char input[100];
    int choice;

    cout << "Inserisci una parola o una frase: ";
    // cin.ignore();
    // cin.getline(input, 100);
    cin >> input;

    cout << "Scegli l'opzione:\n1. Converti in maiuscolo\n2. Converti in minuscolo\n: ";
    cin >> choice;

    switch (choice)
    {
    case 1:
        toUpperCase(input);
        cout << "Testo in maiuscolo: " << input << endl;
        break;

    case 2:
        toLowerCase(input);
        cout << "Testo in minuscolo: " << input << endl;
        break;

    default:
        cout << "Scelta non valida." << endl;
        break;
    }

    return 0;
}

void toUpperCase(char str[])
{
    for (int i = 0; str[i] != '\0'; i++)
    {
        if (str[i] >= 'a' && str[i] <= 'z')
        {
            str[i] -= ('a' - 'A');
        }
    }
}

void toLowerCase(char str[])
{
    for (int i = 0; str[i] != '\0'; i++)
    {
        if (str[i] >= 'A' && str[i] <= 'Z')
        {
            str[i] += ('a' - 'A');
        }
    }
}