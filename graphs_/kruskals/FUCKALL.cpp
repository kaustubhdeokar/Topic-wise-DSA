#include <stdio.h>
#include <iostream>
using namespace std;
long int gcd(long int first, long int second) {
    if(second==0)
    return first;
    else
    gcd(second,first%second);    
}

int main(int argc, const char* argv[]){
    long int testcases,n,first,second,limit;
    cin >> testcases;
    while(testcases){
        cin >> n >> first >> second >> limit;
        auto lcm = first * (second/gcd(first, second));
        auto na = n/first;
        auto nb = n/second;
        auto bb = n/lcm;
        auto total = na +nb - 2 * bb;
        if(total >= limit)
            cout << "Win" <<endl;
        else
            cout << "Lose" << endl;       
        testcases--;
    }
}
