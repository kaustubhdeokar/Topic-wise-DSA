#include<iostream>
using namespace std;

int bs(int a[],int lo,int hi,int key){
	int mid;
	while(lo<hi){
		mid=(lo+hi)/2;
		if(a[mid]==key)
		return mid;
		else if(a[mid]>key)
		hi=mid;
		else
		lo=mid;
	
	}
	return -1;	
}

int main(){
	int n,k,i,j;
	cin>>n;
	int a[n],b[n];
	for(k=0;k<n;k++)
	{
		cin>>a[k];
		b[k]=a[k];
	}	
	int temp;
	for(i=0;i<n;i++)
	{
		temp=a[i];
		j=i;
		while(j>0 && temp<a[j-1])
		{
			a[j]=a[j-1];
			j-=1;
		}
		a[j]=temp;
	}
	int ans;
	
	for(k=0;k<n;k++)
	{
	ans=bs(a,0,n,b[k]);
	cout<<ans+1;
	}
	return 0;
		
}
