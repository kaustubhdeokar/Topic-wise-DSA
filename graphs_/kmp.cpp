#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){

    string s;
    cin>>s;
    s.erase(remove(s.begin(),s.end(),' '));
    cout<<s;
    int n=s.size();
    vector<int> F(n);
    F[0]=0;
    int i,j;
    for(i=1;i<n;i++){
        j=F[i-1];
        while(j>0 && s[i]!=s[j]){
            j=s[j-1];
        }
        if(s[i]==s[j])
        j++;
        F[i]=j;
    }
    for(auto k=F.begin();k!=F.end();k++){
        cout<<*k<<" ";
    }
    return 0;

}