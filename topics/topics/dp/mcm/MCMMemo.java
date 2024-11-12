package dp.mcm;

import java.util.Arrays;

public class MCMMemo {

    public int mcm(int[] arr, int[][] partition, int[][] dp, int i, int j) {

        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];


        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            dp[i][j] = mcm(arr, partition, dp, i, k) + mcm(arr, partition, dp, k + 1, j) + arr[i-1] * arr[k] * arr[j];
            if (dp[i][j] < min) {
                partition[i][j] = k;
                min = Integer.min(min, dp[i][j]);
            }
        }
        return min;
    }


    public static void main(String[] args) {

        //((A(BC))D) 0 0 1 1 3
        //(((AB)C)D) 0 0 1 2 3
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;
        int[][] memo = new int[n][n];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        int[][] partition = new int[n][n];
        MCMMemo mcm = new MCMMemo();
        System.out.println(mcm.mcm(arr, partition, memo, 1, arr.length - 1));


        for (int[] d : memo) {
            for (int d1 : d) {
                System.out.print(d1 + " ");
            }
            System.out.println();
        }

        for (int[] d : partition) {
            for (int d1 : d) {
                System.out.print(d1 + " ");
            }
            System.out.println();
        }

    }
}