//this program includes the description of type of operator and the find of string

#include<iostream>
#include<typeinfo>
using namespace std;




int main(){

    int a=10;
    int a1[1]={1};
    float b=12;
    float b1[2]={2,1};
    string s="asds";
    string t=typeid(a).name(); 
    
    size_t f=t.find("i");
    if(f!=string::npos)
    cout<<"found";
//    
    
    return 0;
}
