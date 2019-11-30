#include<iostream>
using namespace std;

void swap(long long int *a,long long int *b){
long long int temp;
temp=*a;
*a=*b;
*b=temp;
	
}
void quicksort(long long int a[],long long int size)
{
	if(size<2)
	return;
	long long int lo=0;
	long long int hi=size-1;
	long long int pivot=a[rand()%size];
	while(lo<hi){
		while(a[lo]<pivot)
		lo+=1;
		while(a[hi]>pivot)
		hi-=1;
		swap(&a[lo],&a[hi]);
	}
	quicksort(a,lo);
	quicksort(&a[lo+1],size-lo-1);
}
int main(){
	long long int n;
	cin>>n;
	long long int a[n],i;
	for(i=0;i<n;i++)
	cin>>a[i];
	quicksort(a,n);
	for(i=0;i<n;i++)
	cout<<a[i];
	return 0;
}
