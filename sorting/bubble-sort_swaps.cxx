#include<iostream>
using namespace std;
int main(){
	int n,i,j,temp,swaps=0;
	cin>>n;
	int a[n];
	for(i=0;i<n;i++)
	cin>>a[i];
	for(i=0;i<n;i++){
	  for(j=0;j<n-i-1;j++){
		if(a[j]>a[j+1]){
			swaps+=1;
			temp=a[j];
			a[j]=a[j+1];
			a[j+1]=temp;
			}
		}
	}
	cout<<swaps;
	return 0;
}
