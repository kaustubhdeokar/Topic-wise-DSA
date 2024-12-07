package dp.knapsack;

public class SubsetPartition3 {
    public boolean canPartitionMemoization(int[] nums) {

        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;

        int[][] dp = new int[nums.length + 1][sum / 2 + 1];

        canPartitionMemoization(dp, nums, sum / 2, nums.length);

        for (int[] arr : dp) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

        return dp[nums.length][sum / 2] > 0;
    }

    private boolean canPartitionMemoization(int[][] memo, int[] nums, int sum, int n) {

        if (sum == 0) return true;
        if (n <= 0) return false;
        if (memo[n][sum] != -1) return memo[n][sum] == 1;

        if (sum >= nums[n - 1]) {
            memo[n][sum] = canPartitionMemoization(memo, nums, sum - nums[n - 1], n - 1) ||
                    canPartitionMemoization(memo, nums, sum, n - 1) ? 1 : 0;
        } else {
            memo[n][sum] = canPartitionMemoization(memo, nums, sum, n - 1) ? 1 : 0;
        }

        return memo[n][sum] == 1;
    }

    private boolean canPartitionRecursive(int[] nums, int n, int sum) {

        if (sum < 0 || n < 0) return false;
        if (sum == 0) return true;

        if (sum >= nums[n - 1]) {
            return canPartitionRecursive(nums, n - 1, sum - nums[n - 1]) || canPartitionRecursive(nums, n - 1, sum);
        } else {
            return canPartitionRecursive(nums, n - 1, sum);
        }
    }

    public boolean canPartitionRecursive(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        return canPartitionRecursive(nums, nums.length, sum / 2);
    }


    public static void main(String[] args) {
        int[] arr;
        SubsetPartition3 partition = new SubsetPartition3();

        arr = new int[]{1, 2, 3, 6};
        System.out.println(partition.canPartitionRecursive(arr));
        System.out.println(partition.canPartitionMemoization(arr));
    }
}
