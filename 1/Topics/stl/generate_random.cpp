#include<iostream>
#include<time.h>
#include<bits/stdc++.h>
using namespace std;


int main(){

 //srand is for generating the seed . //it simply tells from where to start.
    srand(time(nullptr));
    for(int i=0;i<10;i++){
        cout<<rand()%10<<" ";
    }

    return 0;
}
