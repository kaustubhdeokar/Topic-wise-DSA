#include <stdio.h>
#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
const int DEBUG_ARTBALAN = 0;
using namespace std;


int get_max_ops(std::vector<int> &distribution,int average, int variable_count)
{
    //[1 1 2 2 4 4],2,2
    auto lower_bound_average = std::lower_bound(distribution.begin(),distribution.end(),average);
    //2
    auto max_ops = 0;
    
    if (variable_count < distribution.size()){
        for(std::size_t i=0; i<(distribution.size() - variable_count); i++){
            max_ops += distribution[i];
        }
    }
    
    while(lower_bound_average < distribution.end()){
        max_ops += *lower_bound_average - average;
        lower_bound_average++;
    }
    
    return max_ops; 
}


int main(){
    int t;
    cin>>t;
    cin.ignore();
    string teststring;
    while(t--)
    {
    getline(cin,teststring);
    auto l=teststring.size();
    cout<<"teststring is:"<<teststring;
    map<char,int> m;

        for(auto &i:teststring){
            m[i]+=1;
        }
        cout<<endl;
    
    vector<int> v;
    for(auto it=m.begin();it!=m.begin();it++){
        v.push_back(it->second);
    }

    sort(v.begin(),v.end());
    auto max=l-v.back();

    if(DEBUG_ARTBALAN){
        for(auto &i: v){
                std::cout << i << " ";
            }
            std::cout << std::endl;
    }

    //abca
     for(auto variable_count = 2;variable_count<=26;variable_count++){
        

        if(l%variable_count==0){

            auto average=l/variable_count;
            auto max_ops_for_vc=get_max_ops(v,average,variable_count);
        }
         if(max_ops_for_vc <= max){
                    max = max_ops_for_vc;
                }
                else{
                    break;
                }
       

        }
        cout<<max<<endl;
        t-=1;

    }
    return 0;

}