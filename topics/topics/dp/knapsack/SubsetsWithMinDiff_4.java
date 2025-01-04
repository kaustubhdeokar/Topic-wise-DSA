package dp.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithMinDiff_4 {

    public static void main(String[] args) {
        int[] arr = {-36, 36};
        System.out.println("The minimum difference is: " + findMin(arr));
        System.out.println("The minimum difference of 2 sets is " + minimumDifferenceMemo(arr));
    }

    private static int findMin(int[] arr) {
        int currSum = 0;
        int remSum = Arrays.stream(arr).sum();
        int itemsTaken = 0;
        return minimumDifference(arr, arr.length, itemsTaken, currSum, remSum);
    }

    private static int minimumDifference(int[] arr, int N, int itemsTaken, int currSum, int remSum) {
        if (N == 0) {
            return Math.abs(currSum - remSum);
        }
        int res1 = minimumDifference(arr, N - 1, itemsTaken + 1, currSum + arr[N - 1],
                remSum - arr[N - 1]);
        int res2 = minimumDifference(arr, N - 1, itemsTaken, currSum, remSum);
        return Integer.min(res1, res2);
    }

    //---------------------- memoization solution ----------------------
    public static int minimumDifferenceMemo(int[] arr) {

        int currSum = 0;
        int totalSum = Arrays.stream(arr).sum();

        int minPossibleSum = Arrays.stream(arr)
                .filter(x -> x < 0)
                .sum();

        int maxPossibleSum = Arrays.stream(arr)
                .filter(x -> x > 0)
                .sum();

        int offset = Math.abs(minPossibleSum);

        int cols = maxPossibleSum + offset;
        int n = arr.length;
        int[][] memo = new int[n + 1][cols + 1];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        minimumDifference(memo, arr, n, 0, currSum, totalSum, offset);

        int halfSplit = n / 2;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i <= cols; i++) {
            if (memo[n / 2][i] != -1) {
                minSum = Integer.min(minSum, memo[n / 2][i]);
            }
        }

        return minSum;
    }

    public static int minimumDifference(int[][] memo, int[] arr, int n, int itemsTaken, int currSum, int remSum, int offset) {
        if (n == 0) {
            if (itemsTaken == arr.length / 2)
                return Math.abs(currSum - remSum);
            else
                return Integer.MAX_VALUE;
        }

        int column = currSum + offset;

        if (memo[n][column] != -1) {
            return memo[n][column];
        }

        int a = minimumDifference(memo, arr, n - 1, itemsTaken + 1, currSum + arr[n - 1],
                remSum - arr[n - 1], offset);
        int b = minimumDifference(memo, arr, n - 1, itemsTaken, currSum, remSum, offset);

        return memo[n][column] = Integer.min(a, b);
    }


}
