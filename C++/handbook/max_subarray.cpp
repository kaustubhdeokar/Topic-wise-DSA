/* maximum subarray problem kadane's algorithm*/
#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main(){

    int array[8]={-1,2,4,-3,5,2,-5,2};
    int sum=0,best=INT_MIN,n=(sizeof(array)/sizeof(array[0]));
    for(int i=0;i<n;i++){
		sum+=array[i];
		if(sum>best)
		best=sum;
        if(sum<0)sum=0;
    }
    cout<<best;
    return 0;
}
