package dp.knapsack;

import java.util.Arrays;

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

        int days = arr.length;
        int tasks = arr[0].length;
        int prevTask = tasks;
        int[][] memo = new int[days + 1][tasks + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        int result = calculateMaxPoints(memo, arr, days - 1, tasks, prevTask);
        for (int[] m : memo) {
            for (int m1 : m) {
                System.out.print(m1+" ");
            }
            System.out.println();
        }
        System.out.println(memo[days-1][prevTask]);
    }

    private int calculateMaxPoints(int[][] memo, int[][] arr, int days, int tasks, int prevTask) {

        if (memo[days][tasks] != -1) return memo[days][tasks];

        if (days == 0) {
            int max = -1;
            for (int t = 0; t < arr[0].length; t++) {
                max = Integer.max(max, arr[0][t]);
            }
            for (int t = 0; t < arr[0].length; t++) {
                memo[0][t] = max;
            }
            return max;
        } else {
            int res = -1;
            for (int t = 0; t < tasks; t++) {
                if (t != prevTask) {
                    int midRes = memo[days - 1][tasks] != -1 ?
                            memo[days - 1][tasks] : calculateMaxPoints(memo, arr, days - 1, tasks, t);
                    res = Integer.max(res, arr[days][t] + midRes);
                }
            }
            memo[days][prevTask] = res;
        }
        return memo[days][prevTask];
    }

}
