#include<bits/stdc++.h>
using namespace std;

int partition(int *arr,int start,int end){
  
  int pivot=arr[end];
  int pindex=start;
  for(int i=start;i<end;i++)
  {
    if(arr[i]<=pivot){
      swap(arr[i],arr[pindex]);
      pindex+=1;
    }
  }
  swap(arr[pindex],arr[end]);
  return pindex;
}

void print(int arr[],int n){
  for(int i=0;i<n;i++)
  cout<<arr[i]<<" ";
  cout<<endl;
}

void quicksort(int *arr,int start,int end){
  if(start>=end)
  return;
  else{
    int k=partition(arr,start,end);
    quicksort(arr,start,k-1);
    quicksort(arr,k+1,end);
  }
}

int main()
{
  int arr[]={4,3,1,2,6,9,8};
  int n=7;
  quicksort(arr,0,n-1);
  print(arr,n);
  return 0;
}


