#include <iostream>
using namespace std;

int main()
{

    int numeroStudenti, numeroGiorni, postiPulman, numeroPulman, postiVuoti;

    float prezzoGiornata, costoPulman, quotaPulman, numeroGratuita, quotaHotelGiorno, quotaHotelTotale;

    cout << "Scrivi quanti studenti partecipano ";
    cin >> numeroStudenti;

    cout << "Scrivi quanti posti ha il pulman ";
    cin >> postiPulman;

    cout << "Scrivi quanti giorni dura la gita ";
    cin >> numeroGiorni;

    cout << "Scrivi quanto costa l'hotel giornalmente ";
    cin >> prezzoGiornata;

    cout << "Scrivi quanto costa il pulman ";
    cin >> costoPulman;

    numeroPulman = (numeroStudenti + postiPulman - 1) / postiPulman;

    postiVuoti = (numeroPulman * postiPulman) - numeroStudenti;

    quotaPulman = costoPulman / numeroStudenti;

    numeroGratuita = numeroStudenti / 15;

    quotaHotelGiorno = prezzoGiornata * (numeroStudenti - numeroGratuita) / numeroStudenti;

    quotaHotelTotale = quotaHotelGiorno * numeroStudenti;

    cout << " " << endl;

    cout << "Numero di pulman necessari: " << numeroPulman << endl;

    cout << "Numero di posti vuoti: " << postiVuoti << endl;

    cout << "Quota individuale per il pulman: " << quotaPulman << endl;

    cout << "Numero di gratuita': " << numeroGratuita << endl;

    cout << "Quota individuale per l'hotel al giorno: " << quotaHotelGiorno << endl;

    cout << "Quota totale dell'hotel per l'intero periodo: " << quotaHotelTotale << endl;

    return 0;
}