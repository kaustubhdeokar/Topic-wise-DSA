#include <iostream>
#include<bits/stdc++.h>
using namespace std;
#define min(a,b) ((a<b)?a:b)

int minnumber(int n){
    
    if((n&(n-1))==0) //power of 2.
    return log2(n);
    
    else if(n%2==0)  //if even and not a power of 2
    return 1+minnumber(n/2);
    
    else if(3||(n&2)==0) //number next to power of 2.
    return 1+minnumber(n-1);
    else
    return 1+minnumber(n+1); //odd numbers except above.
}

int main() {
	int t;
	cin>>t;
	while(t--){
	    int n;
	    cin>>n;
	    if(n==1)
	    cout<<0<<endl;
	    else
	    cout<<minnumber(n)<<endl;
	}
	return 0;
}
