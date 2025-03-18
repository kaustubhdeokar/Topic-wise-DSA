package dp.lis;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 11, 1, 16, 8};

        //curr index = 0 prev taken -1
        //if nums[index]>=nums[prev+1]
        //take or not take
        //else
        //not take

        //take 10 -> prev = 0
        //not take 10 -> prev = -1

        int prev = -1;
        int n = 0;
        int count = 0;
        int[][] memo = new int[nums.length][nums.length + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
        System.out.println(lisMemo(memo, nums, n, prev));

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

    private static int lisMemo(int[][] memo, int[] nums, int i, int prev) {
        if (i == nums.length) {
            //System.out.println("count:" + count);
            return 0;
        }

        if (memo[i][prev + 1] != -1) {
            //System.out.println("got for i:" + i + " prev:" + (prev + 1));
            return memo[i][prev + 1];
        }

        if (prev == -1 || nums[prev] < nums[i]) {
            //max(take , not take).
            int ans = memo[i][prev + 1] = Integer.max(1 + lisMemo(memo, nums, i + 1, i), lisMemo(memo, nums, i + 1, prev));
            //System.out.println("calculated for i:"+i+" prev:"+(prev+1));
            return ans;
        } else {
            int ans = memo[i][prev + 1] = lisMemo(memo, nums, i + 1, prev);
            //System.out.println("calculated for i:"+i+" prev:"+(prev+1));
            return ans;
        }
    }

    private static int lisDp(int[] nums, int i, int prev) {

        int[][] dp = new int[nums.length + 1][nums.length + 1];
        return 0;

    }

}
