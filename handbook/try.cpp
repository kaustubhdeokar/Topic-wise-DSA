#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;
#define e 1e-9
int main(){
    string a="monkey";
    sort(a.begin(),a.end());
    cout<<"sorted string is:"<<a<<endl;
    int arr[]={4,2,5,3,5,8,3};
    int n=sizeof(arr)/sizeof(arr[0]);
    sort(arr,arr+n);
    for(auto x:arr){
        cout<<x<<" ";
    }
    return 0;
}