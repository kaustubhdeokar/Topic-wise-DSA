#include<bits/stdc++.h>
#include<iostream>
using namespace std;
#define C 4
#define R 4
void print(int arr[R][C],int i,int j,int rows,int cols){
	int p;
	if(i>=rows || j>=cols)
	return;
	for(int p=i;p<rows;p++)
	cout<<arr[i][p]<<" ";
	for(int p=i+1;p<cols;p++)
	cout<<arr[p][cols-1]<<" ";	
	if(rows-1!=i)
	{
		for(int p=cols-2;p>=j;p--)
		cout<<arr[rows-1][p]<<" ";
	}
	if(cols-1!=j)
	{
		for(int p=rows-2;p>i;p--)
		cout<<arr[p][j]<<" ";
	}
	print(arr,i+1,j+1,rows-1,cols-1);
}

int main(){

	 int a[R][C] = { { 1, 2, 3, 4 }, 
                    { 5, 6, 7, 8 }, 
                    { 9, 10, 11, 12 }, 
                    { 13, 14, 15, 16 } }; 
  
    print(a, 0, 0, R, C); 

	return 0;
}

