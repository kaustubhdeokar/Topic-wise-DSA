#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int main()
{
	int one[32]{0};
        int zero [32]{0};
        vector<int>nums;
        nums.push_back(2);   //0010
        nums.push_back(14);  //1110
        nums.push_back(4);   //0100
        for(int i=0;i<nums.size();i++)
        {
            int bt =0;
            while(bt<32 )
            {
                if(nums[i] & (1<<bt))
                    one[bt]++;
                else
                    zero[bt]++;
                bt++;
            }
        }
        int ans=0;
        for(int i=0;i<32;i++)
        {
            ans+=one[i]*zero[i];
        }
        cout<<ans;
  return 0;
}

