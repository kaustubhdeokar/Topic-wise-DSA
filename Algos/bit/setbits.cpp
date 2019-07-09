#include <iostream>
using namespace std;

int hasevenbits(int n){
    int count=0;
    while(n>0){
        n=n&(n-1);
        count+=1;
    }
    return (count%2);
}

int main() {
	
	for(int i=1;i<10;i++)
	cout<<i<<hasevenbits(i)<<endl;
 	return 0;
}
