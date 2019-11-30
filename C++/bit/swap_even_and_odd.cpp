//swap and even and odd bits
//1010 -> 0101

#include<bits/stdc++.h>
#include <iostream>
using namespace std;

int main() {

    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        int k=ceil(log2(n));
        if(k&1==1)
        k/=2;
        k+=1;
        // cout<<"k is:"<<k<<endl;
        int mask=3;
        for(int i=0;i<k;i++)
        {
        if((n&mask)==mask || (n&mask)==0)
        n|=n;
        else
        n^=mask;
        mask=mask<<2;
        }
        cout<<n<<endl;        
    }
}

