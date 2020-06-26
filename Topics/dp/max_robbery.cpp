#include<iostream>
#include<vector>
#define max(a,b) ((a>b)?a:b)
using namespace std;

	int maxrobbery(vector<int>&v){
		int n=v.size();
		int ppmax=0,pmax=0,cmax=0;
		for(int i=0;i<n;i++){
			cmax=pmax;
			cmax=max(cmax,v[i]+ppmax);
			ppmax=pmax;
			pmax=cmax;
			
		}
		return cmax;
	}

int main(){
		
	vector<int>v={2,1,1,2};
	cout<<maxrobbery(v);
	return 0;
}
	

