#include <iostream>
#include <cstdlib>
#include <ctime>
#define ROW 3
#define COL 4
using namespace std;

int main() {

	system("cls");

	srand(time(0));
	int mat[ROW][COL], trasposta[COL][ROW];

	for (int i=0 ; i<ROW ; i++) {
		for (int j=0; j<COL ; j++) {
			mat[i][j] = rand() % 5;
			cout<<mat[i][j]<<" ";
		}
		cout<<endl;
	}

	cout<<endl;

	for (int i=0 ; i<COL ; i++) {
		for (int j=0; j<ROW ; j++) {
			trasposta[i][j] = mat[j][i];
			cout<<trasposta[i][j]<<" ";
		}
		cout<<endl;
	}



	system("pause");
	return 0;
}