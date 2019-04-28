#include<iostream>
#include<algorithm>
#include<iterator>
#include<bits/stdc++.h>
using namespace std;

int main(){
    
    int arr[10]={12,11,10,9,8,7,6,5,4,3};
    set<int> sarr(arr,arr+5);
    set<int>sarr2(arr+5,arr+sizeof(arr)/sizeof(arr[0]));

    set<int>sarr3;

    sarr3.insert(sarr.begin(),sarr.end());
    sarr3.insert(sarr2.begin(),sarr2.end());

    for(auto it=sarr3.begin();it!=sarr3.end();it++)
    cout<<*it;
    

    
    set<int>::reverse_iterator rit;
    for(auto rit=sarr.rbegin();rit!=sarr.rend();rit++){
        cout<<"reverse:"<<*rit<<" ";
    }
    
    set<int>s;
    s.insert(10);
    s.insert(20);
    s.insert(30);

    set<int>::iterator it;
    for(it=s.begin();it!=s.end();it++){
        cout<<*it<<endl;
    }

    set<int,greater<int>>s1;
    s1.insert(10);
    s1.insert(20);
    s1.insert(30);
    set<int,greater<int>>::iterator itt;
    for(itt=s1.begin();itt!=s1.end();itt++){
        cout<<*itt<<endl;
    }

    it=s.begin();
    cout<<"beginning of element:"<<*it;
    cout<<s1.size();

   return 0;
}
