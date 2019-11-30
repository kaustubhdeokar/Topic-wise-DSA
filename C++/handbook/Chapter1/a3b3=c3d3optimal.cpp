#include<iostream>
#include<bits/stdc++.h>
using namespace std;



int main(){

    int a,b,c,d;
    
    map<int,pair<int,int>>m;
    
    for(a=1;a<10;a++){
        for(b=1;b<10;b++){
            m[pow(a,3)+pow(b,3)]=make_pair(a,b);
        }
    }

    

for(int c=1;c<10;c++){
    for(int d=1;d<10;d++){
        if(m.find(pow(c,3)+pow(d,3))!=m.end())
        
    }
}

 return 0;
}

