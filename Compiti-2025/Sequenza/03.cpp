#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{

    float cateto, area, catetoBis;

    cout << "Inserisci il cateto\n : ";
    cin >> cateto;

    catetoBis = cateto * 3/5;
    area = catetoBis * cateto;
    
    cout << "L'area del triangolo e di: " << area << endl;
    
    return 0;
}
