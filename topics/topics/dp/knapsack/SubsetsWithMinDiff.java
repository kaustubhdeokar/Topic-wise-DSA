package dp.knapsack;

import java.util.Arrays;

public class SubsetsWithMinDiff {


    //----------------------recursive solution ----------------------
    private static int findMin(int[] arr) {

        int sumTotal = Arrays.stream(arr).sum();
        return subsetSum(arr, arr.length, 0, sumTotal);
    }


    private static int subsetSum(int[] arr, int length, int currSum, int sumTotal) {
        if (length == 0) {
            return Math.abs(currSum - (sumTotal - currSum));
        }
        return Math.min(subsetSum(arr, length - 1, currSum + arr[length - 1], sumTotal),
                subsetSum(arr, length - 1, currSum, sumTotal));

    }

    //---------------------- memoization solution ----------------------
    private static int findMinMemoization(int[] arr) {

        int sumTotal = Arrays.stream(arr).sum();
        int[][] memo = new int[arr.length + 1][sumTotal + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return subsetSum(memo, arr, arr.length, 0, sumTotal);
    }

    private static int subsetSum(int[][] dp, int[] arr, int length, int currSum, int sumTotal) {

        if (length == 0) {
            return Math.abs(currSum - (sumTotal - currSum));
        }

        if (dp[length][currSum] != -1) {
            return dp[length][currSum];
        }

        dp[length][currSum] = Math.min(subsetSum(arr, length - 1, currSum + arr[length - 1], sumTotal),
                subsetSum(arr, length - 1, currSum, sumTotal));

        return dp[length][currSum];
    }
    //S1+S2 = sumTotal
    //currSum = S1, S2 = sumTotal-S1. (min(s1-(sumtotal-s1))

    //---------------------- tabulation.



    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2, 1};
        System.out.println("The minimum difference of 2 sets is " + findMin(arr));
        System.out.println("The minimum difference of 2 sets is " + findMinMemoization(arr));

    }
}
