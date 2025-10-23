#include <iostream>
#define ROW 4
#define COL 3
using namespace std;

int main() {
	
	int m[ROW][COL]={0};

	for (int i=0 ; i<ROW ; i++) {
		for (int j=0; j<COL ; j++) {
			cout<<m[i][j];
		}
		cout<<endl;
	}

	system("pause");
	return 0;
}