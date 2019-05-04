#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main(){
    int i,n;
    cin>>n;
    int arr[n],com[n];
    for(i=0;i<n;i++){
        cin>>arr[i];
        com[i]=i+1;
    }
    int a,b,temp,j,t=0,c=0;
    for(i=0;i<n;i++){
        if(t==0)
        {
            if(arr[i]!=com[i]){
                a=i;
                t=1;
            }
        }
        else if(t==1)
        {
            if(arr[i]!=com[i])
            {
                b=i;
                int a1=a,b1=b;
                i=n;
                
                for(j=a;j<=b-a;j++){
                    temp=arr[a1];
                    arr[a1]=arr[b1];
                    arr[b1]=temp;
                    a1+=1;
                    b-=1;
                }
                c+=1;
                t=0;
                i=0;
            }
        }

    }
    cout<<c;
    return 0;
}