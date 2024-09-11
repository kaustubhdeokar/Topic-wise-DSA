#include<cmath>
#include<bits/stdc++.h>
using namespace std;
//leetcode problem 11sep.

class Solution {
public:
    int minBitFlips(int start, int goal) {
        int startCeil = start==0 ? 0: ceil(log2(start));
        int goalCeil = goal ==0 ? 0: ceil(log2(goal));
        int greater = startCeil>goalCeil ? startCeil:goalCeil;
        int mask = 1;
        int diff = 0;

        for(int i=0;i<=greater;i++){
            if((mask&start)!=(mask&goal)){
                diff+=1;
            }
            mask = mask<<1;
        }
        return diff;
    }

};


int main() {
    Solution solution;

    int start = 10;
    int goal = 7;
    cout << "Minimum bit flips to convert " << start << " to " << goal << ": " << solution.minBitFlips(start, goal) << endl;

    start = 0;
    goal = 15;
    cout << "Minimum bit flips to convert " << start << " to " << goal << ": " << solution.minBitFlips(start, goal) << endl;

    return 0;
}