#include <stdio.h>
#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;
const int con = 0;

int function(vector<int> &v,int avg, int i)
{
    auto lower = lower_bound(v.begin(),v.end(),avg);
    auto localmax = 0;
    
    if (i < v.size()){
        for(size_t i=0; i<(v.size() - i); i++){
            localmax += v[i];
        }
    }
    
    while(lower < v.end()){
        localmax += *lower - avg;
        lower++;
    }
    
    return localmax;
}

int main(int argc, const char* argv[]){
  
    int t;
    cin >> t;
    cin.ignore();
    
    string s;
    while(t){
        map<char,int> m;
        getline(cin,s);
        auto l = s.size();
        for(auto &i:s){
            m[i]++;
        }
        vector<int> vec;
        for(auto it=m.begin(); it!= m.end(); it++){
            vec.push_back(it->second);
        }
        
        sort(vec.begin(),vec.end());
        auto localmax = l - vec.back();
        if(con)
        {
        for(auto &i: vec){
            cout << i << " ";
        }
        cout << endl;
        }
        for(auto i = 1;i<=26;i++)
        {
        if(l%i == 0)
        {
        auto avg = l/i;
        auto globalmax = function(vec, avg, i);
        if(con)
        {
            cout << "VC = " << i << " " << globalmax << " " << localmax << endl;
        }
        if(globalmax <= localmax)
        {
        localmax = globalmax;
        }
        else{
            break;
        }
        }
        }
        cout << localmax << endl;
        t--;
    }
    return 0;
}