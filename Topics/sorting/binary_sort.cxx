#include<iostream>
using namespace std;

int merge(int a[],int lo,int hi){
		int b[hi-lo+1],mid=(lo+hi)/2,start=0;
		int swaps=0;
		int lb=lo,ub=mid+1;
		while(lb<=mid && ub<=hi)
		{
			if(a[lb]>a[ub])
			{
				b[start]=a[ub];
				ub+=1;
				start+=1;
				swaps+=1;
			}
			else
			{
				b[start]=a[lb];
				lb+=1;
				start+=1;
			}
		}
		if(lb>mid)
		{
			while(ub<=hi){
				b[start]=a[ub];
				start+=1;
				ub+=1;
			}
		}
		else if(ub>hi)
		{
			while(lb<=mid){
				b[start]=a[lb];
				start+=1;
				lb+=1;
			}
		}
		int i;
	for(i=0;i<start;i++)
	{
		a[lo]=b[i];
		lo+=1;	
	}
	return swaps;
}

int mergesort(int a[],int lo,int hi){
	int x=0,y=0;
	
	if(lo<hi){
	int mid=(lo+hi)/2;
	mergesort(a,lo,mid);
	mergesort(a,mid+1,hi);
	x=merge(a,lo,hi);
	y+=x;
	}
	return y;
}
int main(){
	int i,n,ans;
	cin>>n;
	int a[n];
	for(i=0;i<n;i++)
	cin>>a[i];
	ans=mergesort(a,0,n);
	cout<<ans;
	return 0;
}
	
