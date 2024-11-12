package dp.knapsack;

import java.util.*;

public class NinjaTraining {

    //a ninja can perform any of the three tasks at a given day.
    //ninja cannot perform the same tasks on consecutive days.
    //find maximum points the ninja can score following the above condition.

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        NinjaTraining ninjaTraining = new NinjaTraining();
        ninjaTraining.calculateMaximumPointsTaskDp(arr);
    }

    private void calculateMaximumPointsTaskDp(int[][] arr) {

        int nDays = arr.length;
        int nTasks = arr[0].length;

        int[][] dp = new int[nDays][nTasks + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int result = calculateMaxPoints(arr, dp, nDays - 1, nTasks, nTasks);
        System.out.println("result:"+result);
        for (int[] d : dp) {
            for (int d1 : d) {
                System.out.print(d1 + " ");
            }
            System.out.println();
        }
    }

    public int calculateMaxPoints(int[][] arr, int[][] dp, int nDays, int nTasks, int prevTask) {

        if (prevTask < nTasks && prevTask >= 0 && dp[nDays][prevTask] != -1) return dp[nDays][prevTask];

        int maxVal = 0;

        if (nDays == 0) {

            for (int t = 0; t < nTasks; t++) {
                if (arr[0][t] > maxVal) maxVal = arr[0][t];
            }
            for (int t = 0; t < nTasks; t++) dp[0][t] = maxVal;
        } else {
            for (int t = 0; t < nTasks; t++) {
                if (prevTask != t) {
                    int midRes = dp[nDays - 1][t] != -1 ?
                            dp[nDays - 1][t] : calculateMaxPoints(arr, dp, nDays - 1, nTasks, t);
                    maxVal = Integer.max(arr[nDays][t] + midRes, maxVal);
                }
            }
        }
        return dp[nDays][prevTask] = maxVal;

    }
}
