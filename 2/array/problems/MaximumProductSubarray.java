package array;

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
          
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        
        int minEndingHere = nums[0];
        int minSoFar = nums[0];
        
        for(int i=1;i<nums.length;i++){
            
            int tempMaxEndingHere = Math.max(minEndingHere*nums[i],Math.max(nums[i],maxEndingHere*nums[i]));
            
            int tempMinEndingHere = Math.min(minEndingHere*nums[i],Math.min(nums[i],maxEndingHere*nums[i]));
         
            maxEndingHere = tempMaxEndingHere;
            minEndingHere = tempMinEndingHere;
            
            maxSoFar = Math.max(maxSoFar,maxEndingHere);
            minSoFar = Math.min(minEndingHere,minSoFar);
            
        }
        
        return maxSoFar;
        
    }
}
