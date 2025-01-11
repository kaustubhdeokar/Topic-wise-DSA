package dp.grid;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new
                UniquePaths();
        uniquePaths.uniquePaths(3,7);
    }

    public int uniquePaths(int m, int n) {

        if (m == 1 && n == 1) return 1;
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }

    public boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
