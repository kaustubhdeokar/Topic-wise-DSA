#include<iostream>
#include<time.h>
#include<bits/stdc++.h>
using namespace std;

void print(int a[],int n)
{
    for(int i=0;i<n;i++){
        cout<<a[i]<<" ";
    }

}

int main(){

    int a[10],n;
    cin>>n;
    srand(time(nullptr));
    for(int i=0;i<10;i++){
        a[i]=rand()%10;
    }

    sort(a,a+n);//this works for integers.
   //assuming a is a string . then sort(a.begin(),a.end()) will work for the string a.

    print(a,n);

    return 0;
}
