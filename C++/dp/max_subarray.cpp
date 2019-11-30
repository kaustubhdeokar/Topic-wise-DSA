   int maxSubArray(vector<int>& nums) {
        
        long long global=-INT_MAX;
        long long local=0;
        for(int i=0;i<nums.size();i++){
            local+=nums[i];
            if(global<local)
                global=local;
            if(local<0)
                local=0;
            
        }
    return global;
    }
