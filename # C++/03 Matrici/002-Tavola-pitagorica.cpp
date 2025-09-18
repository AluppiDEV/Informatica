#include <iostream>
#define ROW 9
#define COL 10
using namespace std;

int main() {

	system("cls");
	int tavola[ROW][COL]={0};

	for (int i=0 ; i<ROW ; i++) {
		for (int j=0 ; j<COL ; j++) {
			tavola[i][j] = (i+1)*(j+1);
			cout<<tavola[i][j]<<"\t";
		}
		cout<<endl;
	}

	system("pause");
	return 0;
}