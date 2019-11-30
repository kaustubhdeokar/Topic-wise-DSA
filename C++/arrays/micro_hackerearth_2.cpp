#include<iostream>
using namespace std;
int main(){
    int i,cases,smallest;
    cout<<"no of cases"<<endl;
    cin>>cases;
    while(cases--){
        int no,k;
        cin>>no>>k;
        int arr[no];
        for(i=0;i<no;i++)
            cin>>arr[i];
        for(i=0;i<no;i++)
            cout<<arr[i];
    cout<<k-arr[smallest]<<endl;
    }
    return 0;
}