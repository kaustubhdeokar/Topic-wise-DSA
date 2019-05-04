#include<iostream>
using namespace std;

void merge(int A[ ] , int start, int mid, int end) 
{
	int p = start ,q = mid+1;

	int Arr[end-start+1] , k=0;

for(int i = start ;i <= end ;i++) {
    if(p > mid)      //checks if first part comes to an end or not .
       Arr[ k++ ] = A[ q++] ;

   else if ( q > end)   //checks if second part comes to an end or not
       Arr[ k++ ] = A[ p++ ];

   else if( A[ p ] < A[ q ])     //checks which part has smaller element.
      Arr[ k++ ] = A[ p++ ];

   else
      Arr[ k++ ] = A[ q++];
 }
  for (int p=0 ; p< k ;p ++) {
     A[ start++ ] = Arr[ p ] ;                          
  }
}

void mergesort(int a[],int lo,int hi){
	if(len(
	int mid=(lo+hi)/2;
	mergesort(a,lo,mid);
	mergesort(a,mid+1,hi);
	merge(a,lo,mid,hi);
}
int main(){
	int i,n;
	cin>>n;
	int a[n];
	for(i=0;i<n;i++)
	cin>>a[i];
	mergesort(a,0,n);
	for(i=0;i<n;i++)
	cout<<a[i];
	return 0;
}
	
