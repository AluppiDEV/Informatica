#include <iostream>
using namespace std;

double add(double a, double b);

double subtract(double a, double b);

double multiply(double a, double b);

double divide(double a, double b);

int main()
{
    double num1, num2;
    char operation;

    cout << "Inserisci l'operazione da svolgere: ";

    cin >> num1 >> operation >> num2;

    double result;
    switch (operation)
    {
    case '+':
        result = add(num1, num2);
        break;
    case '-':
        result = subtract(num1, num2);
        break;
    case '*':
    case 'x':
        result = multiply(num1, num2);
        break;
    case '/':
        result = divide(num1, num2);
        break;
    default:
        cerr << "Operazione non valida!" << endl;
        return 1;
    }
    cout << "Risultato: " << result << endl;

    return 0;
}

double add(double a, double b)
{
    return a + b;
}

double subtract(double a, double b)
{
    return a - b;
}

double multiply(double a, double b)
{
    return a * b;
}

double divide(double a, double b)
{
    if (b == 0)
    {
        cout << "Divisione per zero non e' permessa." << endl;
        return 0;
    }
    else
        return a / b;
}