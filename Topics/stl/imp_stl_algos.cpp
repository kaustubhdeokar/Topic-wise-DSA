#include<iostream>
#include<time.h>
#include<bits/stdc++.h>
#include<typeinfo>
using namespace std;

void print(int a[],int n){
    for(int i=0;i<n;i++)
    cout<<a[i]<<" ";
    cout<<endl;
}


int main(){

    int a[7]={10, 20, 5, 23 ,42, 20, 15},n=7;

    vector<int> v(a,a+7);



    for(auto x:v){
        cout<<x<<" ";
    }

/*
   cin>>n;

   srand(time(nullptr));
taking the input 
   for(int i=0;i<10;i++){
       a[i]=rand()%10;
    }
printing
    print(a,n);
sorting 
    sort(a,a+n);
reverse
    reverse(a,a+n);
    print(a,n);
max element
    cout<<*max_element(a,a+n)<<endl;
min element
    cout<<*min_element(a,a+n)<<endl;
counting 

    cout<<count(a,a+n,10);
finding
    find(v.begin(),v.end(),10)!=v.end()?cout<<"yes":cout<<"no";
erasing unique
    sort(v.begin(),v.begin()+7);
    v.erase(unique(v.begin(),v.end()),v.end());
    //erase needs sorting.
//permutations
  next_permutation(vect.begin(), vect.end()); 

*/



    return 0;
}
