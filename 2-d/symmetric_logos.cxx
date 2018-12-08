#include<iostream>
using namespace std;

int verifyx(int *a,int n){
	int i,j,temp=1;
	for(i=0;i<n/2;i++)
	{
		for(j=0;j<n;j++)
		{
			if(*(a+i*n+j)==(*(a+(n-i-1)*n+j)))
			temp=1;
			else
			{
			temp=0;
			break;
			}
		}
	}
	if(temp==0)
	{	
	return 0;
	cout<<"return 1";
	}
	else
	{
	return 1;
	cout<<"return 1";
	}
}

int verifyy(int *a,int n){
	int i,j,temp=1;
	for(j=0;j<n/2;j++)
	{
		for(i=0;i<n;i++)
		{
				if((*(a+i*n+j))==*(a+i*n+(n-j-1)))
				temp=1;
				else
				{
					temp=0;
					break;
				}
		}
	}
	if(temp==0)
		return 0;
		else
		return 1;
}

int main(){
	int t;
	cin>>t;
	while(t){
		int n,i,j,x,y;
		cin>>n;
		int arr[n][n];
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			cin>>arr[i][j];
		}
		x=verifyx(arr[0],n);
		y=verifyy(arr[0],n);
		if(x==1 && y==1)
		cout<<"YES";
		else
		cout<<"NO";
		cout<<endl;
		t--;
	}
return 0;
}
