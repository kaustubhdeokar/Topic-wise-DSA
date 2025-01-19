package dp.lcs;

import java.util.Arrays;

public class CountPalindromicSubsequences {

    public static void main(String[] args) {
        String s1 = "aba";
        //for above string, palindromic subsequences are: a,b,a,aa,aba = 5
        CountPalindromicSubsequences cps = new CountPalindromicSubsequences();
        int i = 0;
        int j = s1.length() - 1;
        int[][] memo = new int[s1.length()][s1.length()];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        System.out.println(cps.countPS(memo, s1, i, j));
    }

    private int countPS(int[][] memo, String s, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = 1 + countPS(memo, s, i + 1, j) + countPS(memo, s, i, j - 1);
        } else {
            return memo[i][j] = countPS(memo, s, i + 1, j) + countPS(memo, s, i, j - 1) - countPS(memo, s, i + 1, j - 1);
        }
    }

}
