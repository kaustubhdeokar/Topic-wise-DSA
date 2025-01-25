package dp.lis;

import java.util.Arrays;

public class LISAtIndex {

    //longest increasing subsequence ending at index n

    public static void main(String[] args) {

        int[] nums = new int[]{5, 4, 11, 1, 16, 8};
        LISAtIndex lis = new LISAtIndex();
//        lis.memoization(nums);
        lis.bruteIndexing(nums);
    }

    private void bruteIndexing(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    seq[i] = prev;
                }
            }
        }

        int ans = -1;
        int ansInd = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                ansInd = i;
            }
        }

        System.out.println(ans + ":" + ansInd);
        System.out.print(nums[ansInd] + " ");
        while (true) {
            ansInd = seq[ansInd];
            System.out.print(nums[ansInd] + " ");
            if (seq[ansInd] == ansInd) break;
        }


    }

    public void memoization(int[] nums) {
        int next = nums.length;
        int curr = nums.length - 1;
        int[][] memo = new int[nums.length + 1][nums.length + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
        System.out.println(calculate(memo, nums, curr, next));
        for (int[] m : memo) {
            for (int i : m) {
                if (i == -1)
                    System.out.print("9 ");
                else
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private int calculate(int[][] memo, int[] nums, int curr, int next) {

        if (curr == 0) return 0;
        if (memo[curr][next] != -1) {
            return memo[curr][next];
        }

        if (next == nums.length || nums[next] > nums[curr]) {
            //take or not take
            return memo[curr][next] = Integer.max(1 + calculate(memo, nums, curr - 1, curr), calculate(memo, nums, curr - 1, next));
        } else {
            // not take.
            return memo[curr][next] = calculate(memo, nums, curr - 1, next);
        }

    }


}
