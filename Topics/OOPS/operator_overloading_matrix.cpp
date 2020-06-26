#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class List{
    
    int a[10][10];
    int n,m;
public:
    List(){
    }
    List(int n,int m){
      this->n=n;
      this->m=m;
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<m;j++)
            cin>>a[i][j];
      }      
    }
    List operator+(List l){
        List ans;
        ans.n=l.n;
        ans.m=l.m;
        for(int i=0;i<l.n;i++)
            for(int j=0;j<l.m;j++)
            ans.a[i][j]=a[i][j]+l.a[i][j];
        return ans;
    }
    void display(){
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            cout<<a[i][j]<<" ";
            cout<<endl;
        }
    }
};

int main(){
    int t;
    cin>>t;
    while(t--){
    int n,m;
    cin>>n>>m;
    List l1(n,m);
    List l2(n,m);
    List l3=l1+l2;
    l3.display();
    }
    return 0;
}
