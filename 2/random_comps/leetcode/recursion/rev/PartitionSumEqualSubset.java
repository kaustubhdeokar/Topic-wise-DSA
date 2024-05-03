package recursion.rev;//https://leetcode.com/problems/partition-equal-subset-sum/

public class PartitionSumEqualSubset {
    

    public static void main(String[] args) {
    
        int[] nums = {1,5,11,5};
        System.out.println("expected true, got :"+ canPartition(nums));
        nums = new int[]{3,4,5,3,3};
        System.out.println("expected true, got :"+ canPartition(nums));

    }

    public static boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        
        if(sum%2!=0)
            return false;
        
        else
            return knapsack(nums, sum/2, nums.length);
        
    }
    
    public static boolean knapsack(int[] nums, int sum, int n){
        
        if(sum==0)
            return true;
        
        if(n==0 || sum<0)
            return false;
        
        if(sum>=nums[n-1]){
            return knapsack(nums, sum-nums[n-1], n-1) || knapsack(nums, sum, n-1);
        }
        else
            return knapsack(nums, sum, n-1);
        
    }

}
