#include <iostream>
using namespace std;
int main() {
    int count=0,t;
    cin>>t;
    while(t>0){
        t=t&(t-1);
        count+=1;
    }
    cout<<count;
 	return 0;
}
