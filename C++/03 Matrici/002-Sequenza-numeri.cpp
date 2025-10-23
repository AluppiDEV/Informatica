#include <iostream>
#define ROW 5
#define COL 5
using namespace std;

int main() {

	system("cls");
	int m[ROW][COL]={0}, count=0;

	for (int i=0 ; i<ROW ; i++) {
		for (int j=0 ; j<COL ; j++) {
			count++;
			m[i][j] = count;
			cout<<"\t"<<m[i][j];
		}
		cout<<endl;
	}

	system("pause");
	return 0;
}