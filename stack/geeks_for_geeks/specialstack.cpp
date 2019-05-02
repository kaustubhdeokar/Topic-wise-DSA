#include <iostream>
#include<bits/stdc++.h>
#include<set>
using namespace std;

//this is the optimised stack// where get min & get max is O(1) operation.

int main()
{

    stack<int>smain;
    stack<int>smin;
    int n,temp;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>temp;
        if(i==0)
        {
            smain.push(temp);
            smin.push(temp);
        }
        else{
            smain.push(temp);
            if(smin.top()<temp)
            smin.push(smin.top());
            else
            smin.push(temp);
        }
    }
    cout<<smin.top();


	return 0;
}
