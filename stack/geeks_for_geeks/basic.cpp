#include<iostream>
using namespace std;
#include<bits/stdc++.h>

int main(){
    int option,i,x,n;
    cin>>n;
    int count=0;
    stack<int>s;
    stack<int>s1;
    for(i=0;i<n;i++){
        cin>>option;
        switch(option){
            case 1:
                cin>>x;
                s.push(x);
                count+=1;
                break;
            case 2:
                s.pop();
                count-=1;
                break;
            case 3:
                s1=s;
                int maxi=INT_MIN;
                while(!s1.empty())
                {   if(s1.top()>maxi)
                    {
                        maxi=s1.top();
                    }
                        s1.pop();
                }
                cout<<maxi<<endl;
                
                break;
        }   
    }
    return 0;
}