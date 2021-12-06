#include <bits/stdc++.h>
using namespace std;

int main(){

  priority_queue<int,vector<int>,greater<int>>max;
  int t;
  cin>>t;
  while(t--){
    int in,n;
    cin>>n;
    int m=n*n;
    while(m--){
      cin>>in;
      max.push(in);
    }
    m=n*n;
    for(int i=0;i<m;i++){
      cout<<max.top();
      max.pop();
    }
  cout<<endl;
  }
  return 0;
}
