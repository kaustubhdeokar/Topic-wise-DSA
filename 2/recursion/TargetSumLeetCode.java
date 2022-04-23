//https://leetcode.com/problems/target-sum/

  public int findTargetSumWays(int[] nums, int target) {
     
        int index = 0;
        return findTargetSumWays(nums, index, target);
        
    }
    
    public int findTargetSumWays(int[] nums,int index,int target){
        
        // System.out.println("index"+index+"target"+target);
        
        if(index >= nums.length && target!=0)
            return 0;
        if(index == nums.length && target == 0)
            return 1;
        
        int count = findTargetSumWays(nums,index+1,target-nums[index]);
        count += findTargetSumWays(nums,index+1,target+nums[index]);
        return count;
    }
