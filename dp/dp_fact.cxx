#include<iostream>
using namespace std;
#define ll long long int
#define mod 1000000007
ll fact[mod]={0};

void factorial(){
	fact[0]=1;
	fact[1]=1;
	for(int i=2;i<mod;i++)
		fact[i]=(1LL*((fact[i-1])%mod)*(i%mod))%mod;
}

int main(){
		int t;
		cin>>t;
		factorial();
		while(t--){
			int n;
			cin>>n;
			cout<<fact[n]<<endl;
		}
		return 0;
	}
