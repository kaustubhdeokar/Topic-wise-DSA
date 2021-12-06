#include<iostream>
#include<string>
using namespace std;

int verifyx(int *a,int n){
	int i,j,temp=1;
	for(i=0;i<n/2;i++)
	{
		for(j=0;j<n;j++)
		{
			if((bool(*(a+(i*n+j))==*(a+(n-i-1)*n+j)))==0)
			return 0;
		}
	}	
	if(temp==1)
	return 1;
	
}

int verifyy(int *a,int n){
	int i,j,temp=1;
	for(j=0;j<n/2;j++)
	{
		for(i=0;i<n;i++)
		{
				if(bool((*(a+i*n+j))==*(a+i*n+(n-j-1)))==0)
				return 0;
		}
	}
	if(temp==1)
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
			string c;
			cin>>c;
			for(j=0;j<n;j++)
			arr[i][j]=c[j];
		}
		x=verifyx(arr[0],n);
		y=verifyy(arr[0],n);
		int ans=0;
		ans=(x==1 && y==1)?1:0;
		if(ans==0)
		cout<<"NO";
		else
		cout<<"YES";
		cout<<endl;

		t--;
	}
return 0;
}
