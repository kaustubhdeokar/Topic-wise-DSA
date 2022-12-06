import java.util.*;
//https://leetcode.com/problems/partition-equal-subset-sum/submissions/
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
        
        else{
            int[][] dp = new int[nums.length+1][sum/2+1];
            for(int i=0;i<=nums.length;i++){
                Arrays.fill(dp[i],-1);
            }
            knapsack(dp, nums, sum/2, nums.length);
            return dp[nums.length][sum/2]==1;
        }
    }
    
    public static int knapsack(int[][] dp, int[] nums, int sum, int n){
        
        if(sum==0)
            return 1;
        
        if(n==0 || sum<0)
            return 0;
        
        if(dp[n][sum]!=-1)
            return dp[n][sum];

        if(sum>=nums[n-1]){
            if(knapsack(dp, nums, sum-nums[n-1], n-1) == 1 || knapsack(dp, nums, sum, n-1)==1)
                dp[n][sum] = 1;
            else 
                dp[n][sum] = 0;

            return dp[n][sum];
        }

        else
            return dp[n][sum] = knapsack(dp, nums, sum, n-1);
        
    }

}
