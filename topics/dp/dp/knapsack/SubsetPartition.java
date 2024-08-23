package dp.knapsack;

import java.util.Arrays;

public class SubsetPartition {
    public boolean canPartition(int[] nums) {

//        int sum = 0;
//        for (int n : nums) sum += n;
//
//        if (sum % 2 != 0) return false;
//
//        sum /= 2;
        int sum = 5;
        int[][] dp = new int[sum + 1][nums.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        canPartition(dp, nums, sum, nums.length - 1);


        return true;
    }

    public int canPartition(int[][] dp, int[] nums, int sum, int i) {

        if (sum == 0) return 1;

        if (i < 0 || sum < 0) return 0;


        if (dp[sum][i] != -1) return dp[sum][i];

        if (sum >= nums[i]) {
            dp[sum][i] = canPartition(dp, nums, sum - nums[i], i - 1) + canPartition(dp, nums, sum, i - 1);
        } else {
            dp[sum][i] = canPartition(dp, nums, sum, i - 1);
        }
        return dp[sum][i];
    }

    public static void main(String[] args) {
        int[] arr;
//        arr = new int[]{1, 5, 11, 5};
        SubsetPartition partition = new SubsetPartition();
//        System.out.println(partition.canPartition(arr));//true

        arr = new int[]{1, 2, 3, 5};
        System.out.println(partition.canPartition(arr));//false
//
//        arr = new int[]{1,1,1,1};
//        System.out.println(partition.canPartition(arr));//true
//
//        arr = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
//        System.out.println(partition.canPartition(arr));//true

    }
}
