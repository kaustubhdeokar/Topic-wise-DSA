package dp;

import java.util.Arrays;

public class EditDistance {

    public int editDistance(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        return editDistanceRecursively(s1, s2, m - 1, n - 1);

    }

    public int editDistanceDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        return editDistanceDP(s1, s2, m, n, dp);
    }

    private int editDistanceDP(String s1, String s2, int m, int n, int[][] dp) {

        if (m == 0) {
            dp[m][n] = n;
        } else if (n == 0) {
            dp[m][n] = m;
        } else if (dp[m][n] == Integer.MAX_VALUE) {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                dp[m][n] = editDistanceDP(s1, s2, m - 1, n - 1, dp);
            } else {
                dp[m][n] = 1 + Integer.min(editDistanceDP(s1, s2, m, n - 1, dp),
                        Integer.min(editDistanceDP(s1, s2, m - 1, n, dp),
                                editDistanceDP(s1, s2, m - 1, n - 1, dp)));
            }
        }
        return dp[m][n];
    }

    private int editDistanceRecursively(String s1, String s2, int m, int n) {

        if (m == 0)
            return n+1;
        if (n == 0)
            return m+1;

        if (s1.charAt(m) == s2.charAt(n)) {
            return editDistanceRecursively(s1, s2, m - 1, n - 1);
        } else {
            return 1 + Integer.min(editDistanceRecursively(s1, s2, m - 1, n), //delete case
                    Integer.min(editDistanceRecursively(s1, s2, m, n - 1), //insert
                            editDistanceRecursively(s1, s2, m - 1, n - 1) //replace
                    ));
        }
    }

    public static void main(String[] args) {

        EditDistance editDistance = new EditDistance();
        int dist = editDistance.editDistance("horse", "ros");
        int distDp = editDistance.editDistanceDP("horse", "ros");
        System.out.println("distance: " + dist);
        System.out.println("distance dp: " + distDp);
    }

}
