import java.util.*;

public class SubsetsWithSumK {
    
    public static void main(String[] args) {
    
        int[] nums = {1,5,11,5};
        // System.out.println("expected 2, got :"+ subsets(nums,11));
        // nums = new int[]{3,4,5,3,3};
        // System.out.println("expected 2, got :"+ subsets(nums,9));
        nums = new int[]{2,3,5,6,8,10};
        System.out.println("expected 3, got :"+ subsets(nums,10));

    }

    public static int subsets(int[] nums, int sum) {
        
        int[][] dp = new int[nums.length+1][sum+1];

        for(int i=0;i<=sum;i++)
            dp[0][i] = 0;
        
        for(int i=0;i<=nums.length;i++)
            dp[i][0] = 1;
        
        return knapsack(dp, nums, sum, nums.length);
    }
    
    public static int knapsack(int[][] dp, int[] nums, int sum, int n){
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }

}
