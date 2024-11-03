package dp.knapsack;

import java.util.*;

public class NinjaTraining {

    //a ninja can perform any of the three tasks at a given day.
    //ninja cannot perform the same tasks on consecutive days.
    //find maximum points the ninja can score following the above condition.

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        NinjaTraining ninjaTraining = new NinjaTraining();
//      ninjaTraining.calculateMaximumPointsTask(arr);

        ninjaTraining.calculateMaximumPointsTaskDp(arr);

    }

    private void calculateMaximumPointsTaskDp(int[][] arr) {

        int days = arr.length - 1;
        int previousTask = -1; //no task done yet.

        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        calcMaxPoints(dp, arr, days, previousTask);

        for (int[] d : dp) {
            for (int d1 : d) {
                System.out.print(d1 + " ");
            }
            System.out.println();
        }
    }

    private int calcMaxPoints(int[][] dp, int[][] arr, int day, int previousTask) {

        if (day < 0) return 0;

        int max = -1;
        int maxTask = -1;
        for (int task = 0; task < arr[day].length; task++) {
            if (task != previousTask) {
                if (dp[day][task] == -1) {
                    dp[day][task] = arr[day][task] + calcMaxPoints(dp, arr, day - 1, task);
                }
                if (dp[day][task] > max) {
                    max = Integer.max(max, dp[day][task]);
                    maxTask = task;
                }
            }
        }
        return dp[day][maxTask];

    }

    private void calculateMaximumPointsTask(int[][] arr) {

        int days = arr.length - 1;
        int previousTask = -1; //no task done yet.

        int result = calculateMaximumPointsForDaysWithPreviousTask(arr, days, previousTask);
        System.out.println(result);
    }

    private int calculateMaximumPointsForDaysWithPreviousTask(int[][] arr, int day, int previousTask) {

        if (day < 0) return 0;

        int max = -1;
        for (int task = 0; task < arr[day].length; task++) {
            if (task != previousTask) {
                int points = arr[day][task] + calculateMaximumPointsForDaysWithPreviousTask(arr, day - 1, task);
                max = Integer.max(max, points);
            }
        }

        return max;

    }


}
