import java.util.*;
//https://leetcode.com/problems/partition-equal-subset-sum/submissions/
public class PartitionSumEqualSubsetBottomUp {
    
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
            boolean[][] dp = new boolean[nums.length+1][sum/2+1];

            for(int i=0;i<=sum/2;i++)
                dp[0][i] = false;
            
            for(int i=0;i<=nums.length;i++)
                dp[i][0] = true;
            
            knapsack(dp, nums, sum/2, nums.length);

            return dp[nums.length][sum/2];
        }
    }
    
    public static boolean knapsack(boolean[][] dp, int[] nums, int sum, int n){
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(j>=nums[i-1])
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                
                else
                    dp[i][j] = dp[i-1][j];
        
            }
        }

        return dp[n][sum];
    }

}
