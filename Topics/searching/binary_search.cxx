#include<iostream>
#include<bits/stdc++.h> 
using namespace std;

int search(int a[],int n,int j){
    int mid,start=0,end=n;
    while(start<end){
        mid=(start+end)/2;
        if(a[mid]==j)
        return mid;
        else if(a[mid]>j){
            end=mid;
        }
        else{
            start=mid;
        }
    }
	return -1;
}


int main(){
    int n,i,q,j,ans;
    cin>>n;
    int a[n];
    for(i=0;i<n;i++)
    cin>>a[i];
	sort(a,a+n);
    cin>>q;
  for(i=0;i<q;i++)
    {
        cin>>j;
        ans=search(a,n,j);
        cout<<ans+1<<endl;
   }
    return 0;
}
