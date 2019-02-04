#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char* argv[]){
    int t;
   cin >> t;
    while (t) {
        int n;
        cin >>n;
        uint64_t A_i;
        uint64_t min_requirements = 0;
        while(n){
            std::cin >> A_i;
            min_requirements += (A_i - 1);
            n--;
        }
        
        std::cout << min_requirements + 1 << std::endl;
        t--;
    }
    return 0;
}