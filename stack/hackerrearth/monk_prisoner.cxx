#include<iostream>
using namespace std;
int main(){
	int i,n,k,j;
	cin>>n;
	int arr[n]={0},y[n]={0};
	for(i=0;i<n;i++)
	cin>>arr[i];
	for(i=n-1;i>=0;i--)
	{
		j=i;
		k=j+1;
		if(j==n-1)
		y[j]=-1;
		else
		{
			if(y[k]==-1)
			{
				cout<<"Case1"<<endl;
				if(arr[j]>arr[k])
				y[j]=-1;
				else
				y[j]=k+1;
			}
			else
			{
				cout<<"Case2"<<endl;
				if(arr[j]>arr[k])
				{
					cout<<"Case2->2"<<endl;
				
					if(arr[j]>arr[y[k]-1])
					y[j]=-1;
					else
					y[j]=y[k];
				}
				else
				y[j]=k+1;
			}
		}
	}
	
	
		int x[n];
		for(i=0;i<n;i++)
		cout<<y[i]<<" ";
		cout<<endl;
		for(i=0;i<n;i++)
		{
		x[i]=n-y[n-i-1]+1;
		cout<<x[i]<<" ";
		}
	return 0;
}
