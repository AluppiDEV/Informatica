#include <iostream>
using namespace std;

int main() {
    int litriDamigiana, numeroBottiglia, numeroBottiglione, numeroDamigiana, speseTrasporto;
    float totalePrezzo, litriBottiglia, litriBottigliona, prezzoLitro, prezzoBottiglia, prezzoBottiglione, prezzoDamigiana, sconto, totaleLitri;

    speseTrasporto= 2;
    litriBottiglia=0.75;
    litriBottigliona=1.5;
    litriDamigiana=20;

    cout<<"salve"<<endl;
    cout<<"Scrivi qua di seguito il numero di bottiglie che vuoi acquistare."<<endl;
    cin>>numeroBottiglia;
    prezzoBottiglia=(numeroBottiglia*0.75)*1.2;

    cout<<"Scrivi qua di seguito il numero di bottglioni che vuoi acquistare."<<endl;
    cin>>numeroBottiglione;
    prezzoBottiglione=(numeroBottiglione*0.75)*1.2;

    cout<<"Scrivi qua di seguito il numero di damigiane che vuoi acquistare."<<endl;
    cin>>numeroDamigiana;
    prezzoDamigiana=(numeroDamigiana*0.75)*1.2;

    totaleLitri=(numeroBottiglia*litriBottiglia)+(numeroBottiglione*litriBottigliona)+(numeroDamigiana*litriDamigiana);

    if ( totaleLitri > 50 ) {
        cout<<"Avendo superato i 50 litri hai diritto ad uno sconto del 10\%"<<endl;
        sconto=0.10;
    } else {
        sconto=0;
    }

    totalePrezzo=(prezzoBottiglia+prezzoBottiglione+prezzoDamigiana+speseTrasporto)-((prezzoBottiglia+prezzoBottiglione+prezzoDamigiana+speseTrasporto)*sconto);

    cout<< "Il totale che dovrai pagare e': "<<totalePrezzo<<" - EURO che comprende anche le spese di trasporto.";

    return 0;
}
