#include<iostream>
#define MESE 31
using namespace std;

int main() {

	system("cls");
	char apice_numero = static_cast<char>(248), e = static_cast<char>(138), a = static_cast<char>(133);
	bool disponibilit_1[MESE]={0}, disponibilit_2[MESE]={0};
	int ins_int, stampa=0;
	string ins;

	cout<<"Collega N"<<apice_numero<<"1"<<endl;
	ins = "";
	while (ins != "stop") {
		cout<<"Inserisci la tua disponibilit"<<a<<" per uscire digita 'stop'";
		cin>>ins;
		if (ins != "stop") {
			ins_int = stoi(ins);
			disponibilit_1[ins_int] = true;
		}
	}

	cout<<"Collega N"<<apice_numero<<"2"<<endl;
	ins = "";
	while (ins != "stop") {
		cout<<"Inserisci la tua disponibilit"<<a<<" per uscire digita 'stop'";
		cin>>ins;
		if (ins != "stop") {
			ins_int = stoi(ins);
			disponibilit_2[ins_int] = true;
		}
	}

	for (int i=0 ; i<MESE ; i++) {
		if (disponibilit_1[i] == disponibilit_2[i] && disponibilit_1[i] != 0) {
			stampa++;
			cout<<"Il giorno "<<i<<" avete entrambi disponibilit"<<a<<"."<<endl;
		}
	}
	if (stampa == 0) {
		cout<<"Nessun giorno in comune libero."<<endl;
	}

	system("pause");
	return 0;
}