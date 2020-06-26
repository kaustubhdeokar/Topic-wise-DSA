#include <iostream>
#include <climits>
using namespace std;
int main() {
	int t;
	cin>>t;
	while(t--){
	    int n;
	    cin>>n;
	    int arr[n];
	    int msf=INT_MIN,meh=0;
	    for(int i=0;i<n;i++){
	        cin>>arr[i];
	        meh+=arr[i];
	        if(msf<meh)
	        msf=meh;
	        if(meh<0)
	        meh=0;
	    }
	    cout<<msf<<endl;
	}
	return 0;
}
