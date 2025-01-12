package dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public static void main(String[] args) {

        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        int[] nums = new int[]{5,9,18,54,108,540,90,180,360,720};
        largestDivisibleSubset.largestDivisibleSubset(nums);

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int maxSizeSubset = -1;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if(maxSizeSubset < dp[i]){
                        maxSizeSubset = dp[i];
                    }
                    maxSizeSubset = Integer.max(maxSizeSubset, dp[i]);
                    hash[i] = j;
                }
            }
        }

        System.out.println(maxSizeSubset);

        return result;

    }
}
