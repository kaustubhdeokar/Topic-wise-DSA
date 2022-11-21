import java.util.*;

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
            int[][] dp = new int[nums.length+1][sum/2+1];

            for(int i=0;i<=sum/2;i++)
                dp[0][i] = 0;
            
            for(int i=0;i<=nums.length;i++)
                dp[i][0] = 1;
            
            knapsack(dp, nums, sum/2, nums.length);

            return dp[nums.length][sum/2]==1;
        }
    }
    
    public static int knapsack(int[][] dp, int[] nums, int sum, int n){
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(j>=nums[i-1]){
                    if(dp[i-1][j-nums[i-1]] == 1 || dp[i-1][j] ==1)
                        dp[i][j] = 1;
                    else 
                        dp[i][j] = 0;
                }
        
                else
                    dp[i][j] = dp[i-1][j];
        
            }
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
        return dp[n][sum];
    }

}
