#include<iostream>
using namespace std;

int bs(int a[],int lo,int hi,int key){
	int mid;
	while(lo<hi){
		mid=(lo+hi)/2;
		if(a[mid]==key)
			return mid;
		else if(a[mid]>key)
			bs(a,0,mid-1,key);
		else
			bs(a,mid+1,hi,key);
	}
	return -1;
}

void swap(int *a,int *b){
	int temp;
	temp=*a;
	*a=*b;
	*b=temp;
} 

int main(){
	int n,i,j,temp;
	cin>>n;
	int a[n];
	for(i=0;i<n;i++)
	cin>>a[i];
	for(i=0;i<n;i++)
	{
		temp=a[i];
		j=i;
		while(j>0 and temp<a[j-1])
		{
			a[j]=a[j-1];
			j-=1;
		}
		a[j]=temp;
	}
	for(i=0;i<n;i++)
	cout<<a[i];
	temp=bs(a,0,n,1);
	cout<<temp;
	return 0;
		
}
