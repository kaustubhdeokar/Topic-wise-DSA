# include<stdio.h> 
#include<iostream>
#define min(a,b) ((a<b)?a:b)
using namespace std;

int arr[100];

int climbStairs(int n) {
        
        arr[n-1]=climbStairs(n-1);
        arr[n-2]=climbStairs(n-2);
        arr[n]=min(arr[n-1],arr[n-2]);
        return arr[n];
   }

int main() 
{ 
	int n;
	cin>>n; 
	cout<<"ans:"<<climbStairs(n)<<endl;
	for(int i=0;i<10;i++)
	cout<<arr[i]<<" ";
	return 0; 
} 

