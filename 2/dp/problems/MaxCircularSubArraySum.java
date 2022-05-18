class Solution {
    public int maxSubarraySumCircular(int[] nums) {
     
    
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int sum = nums[0];
        
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            
            maxEndingHere = Integer.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar = Integer.max(maxSoFar,maxEndingHere);
            
            minEndingHere = Integer.min(minEndingHere+nums[i],nums[i]);
            minSoFar = Integer.min(minSoFar,minEndingHere);
        }
        
        if(minSoFar == sum) //all negative nums
            return maxSoFar;
        else{
            // System.out.println("sum:"+sum+"min so far"+minSoFar);
            // System.out.println("maxsofar:"+maxSoFar);
            return Integer.max(maxSoFar,sum-minSoFar);
        }
        
    }
    
}
