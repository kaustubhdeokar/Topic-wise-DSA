package dp.mcm;

import java.util.Arrays;

public class PallindromePartitioning {

    public static void main(String[] args) {

        String s = "abbaea";
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        System.out.println(partition(memo, s, 0, s.length() - 1));

        for (int[] arr : memo) {
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    private static int partition(int[][] memo, String s, int i, int j) {

        if (i > j) return -1;
        if (i == j) return memo[i][j] = 0;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int max = Integer.MIN_VALUE;
        if (isPallindrome(s, i, j)) {
            max = Integer.max(max, j - i + 1);
            memo[i][j] = max;
        }
        for (int k = i; k < j; k++) {
            memo[i][j] = calcMax(max, partition(memo, s, i, k), partition(memo, s, k + 1, j));
            if (memo[i][j] > max) {
                max = memo[i][j];
            }
        }
        return max;
    }

    private static int partition(String s, int i, int j) {

        int max = Integer.MIN_VALUE;
        if (isPallindrome(s, i, j)) {
            return j - i + 1;
        }
        for (int k = i + 1; k < j; k++) {
            max = calcMax(max, partition(s, i, k), partition(s, k + 1, j));
        }
        return max;
    }

    private static boolean isPallindrome(String s, int i, int j) {

        int len = (i + j + 1);
        for (int i1 = i; i1 < len / 2; i1++) {
            if (s.charAt(i1) != s.charAt(len - i1 - 1)) {
                return false;
            }
        }
        System.out.println(s.substring(i,j+1));
        return true;
    }

    public static int calcMax(Integer... arr) {
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > max) max = a;
        }
        return max;
    }

}
