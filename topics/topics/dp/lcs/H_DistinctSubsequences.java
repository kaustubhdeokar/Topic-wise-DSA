package dp.lcs;

import java.util.Arrays;

public class H_DistinctSubsequences {

    public static void main(String[] args) {

        String s1 = "bag";
        String s2 = "babgbag";

        H_DistinctSubsequences subsequences = new H_DistinctSubsequences();
        StringBuilder cache = new StringBuilder();
        int result = subsequences.recursion(s1, s1.length(), s2, s2.length(), cache);
        System.out.println("res:" + result);

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
        cache = new StringBuilder();
        System.out.println(subsequences.recursion(memo, s1, s1.length(), s2, s2.length(), cache));
    }

    private int recursion(int[][] memo, String s1, int i, String s2, int j, StringBuilder res) {
        if (i <= 0) {
            System.out.println(res.toString());
            return 1;
        } else if (j <= 0) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            res.append(s1.charAt(i - 1));
            int res1 = recursion(memo, s1, i - 1, s2, j - 1, res);
            res.deleteCharAt(res.length() - 1);
            int res2 = recursion(memo, s1, i, s2, j - 1, res);
            return memo[i][j] = res1 + res2;
        } else {
            return memo[i][j] = recursion(memo, s1, i, s2, j - 1, res);
        }
    }


    private int recursion(String s1, int i, String s2, int j, StringBuilder res) {
        if (i <= 0) {
            System.out.println(res.toString());
            return 1;
        } else if (j <= 0) return 0;

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            res.append(s1.charAt(i - 1));
            int res1 = recursion(s1, i - 1, s2, j - 1, res);
            res.deleteCharAt(res.length() - 1);
            int res2 = recursion(s1, i, s2, j - 1, res);
            return res1 + res2;
        } else {
            return recursion(s1, i, s2, j - 1, res);
        }
    }

}
