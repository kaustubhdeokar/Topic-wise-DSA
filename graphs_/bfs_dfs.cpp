#include<iostream>
using namespace std;

int parent(int i){return (i-1)/2;}
int left(int i){return (2*i)+1;}
int right(int i){return (2*i)+2;}
void swap(int *x,int *y){
	int temp=*x;
	*x=*y;
	*y=temp;
}
void heapify(int arr[],int n){
    
    for(int i=0;i<n;i++){
		int j=i;
		while(j!=0)
		{
			if(arr[parent(j)]>arr[j])
			swap(&arr[parent(j)],&arr[j]);
			j=parent(j);
		}
	}
    
    for(int i=0;i<n;i++)
    cout<<arr[i]<<" ";
    
}




int main(){

    int *arr,n;
    cin>>n;
    arr=new int[n];
    for(int i=0;i<n;i++)
    cin>>arr[i];
    heapify(arr,n);
    return 0;
}
