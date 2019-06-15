#include<bits/stdc++.h>
#define ull unsigned long long
using namespace std;
#include <cstdint>


#define MOD 1000000007

ull fast(ull x,ull y){
	if(y==0)
	return 1;
	else if(y%2!=0)
	return (x*fast(x,y/2)*fast(x,y/2))%MOD;
	else
	return (fast(x,y/2)*fast(x,y/2))%MOD;
}

int main()
{
	ull t,m=1000000007;
	cin>>t;
	for(ull i=0;i<t;i++){
		ull ans=10,k;
		cin>>k;
		ans=(10LL*fast(2,k-1))%MOD;
		cout<<ans<<endl;

	}	

}
