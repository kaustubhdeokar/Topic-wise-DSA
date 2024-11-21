package dp.problems;

import java.util.Arrays;

public class CherryPick {

    public int cherryPickup(int[][] grid) {
        //to traverse twice, from bottom to up.
        //if grid[0][0] || grid[n-1][n-1] == -1 return 0;

        int n = grid.length;
        int val = 0;

        int r = n - 1;
        int c = n - 1;
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        boolean[] reachedTop = {false};
        val += traverse(grid, dp, r, c, n, reachedTop);
        if(!reachedTop[0]){
            return 0;
        }

        System.out.println("val:" + val);
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        r = 0;
        c = 0;
        val += traverseFromStart(grid, dp, r, c, n);

        return val;
    }

    public int traverse(int[][] grid, int[][] dp, int r, int c, int n, boolean[] reachedTop) {
        if (c < 0 || r < 0) return 0;

        if(r==0 && c==0) reachedTop[0] = true;

        if (dp[r][c] != -1) {
            return grid[r][c];
        }

        if (isCellValid(r, c, n, grid)) {
            int curr = grid[r][c];

            int left = traverse(grid, dp, r, c - 1, n, reachedTop);
            int up = traverse(grid, dp, r - 1, c, n, reachedTop);

            grid[r][c] = 0;
            if (curr > 0) {
                dp[r][c] = 1 + up + left;
            } else {
                dp[r][c] = up + left;
            }

            return dp[r][c];
        }

        return 0;
    }

    public int traverseFromStart(int[][] grid, int[][] dp, int r, int c, int n) {
        if (c == n || r == n) return 0;
        if(dp[r][c]!=-1) return dp[r][c];

        if (isCellValid(r, c, n, grid)) {
            int curr = grid[r][c];
            int up = traverseFromStart(grid, dp, r + 1, c, n);
            int left = traverseFromStart(grid, dp, r, c + 1, n);

            if (curr == 1) {
                dp[r][c] = 1 + up + left;
                grid[r][c] = 0;
            } else {
                dp[r][c] = up + left;
            }
            return dp[r][c];
        }
        return 0;
    }

    public boolean isCellValid(int r, int c, int n, int[][] grid) {
        return r >= 0 && c >= 0 && r < n && c < n && grid[r][c] >= 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        CherryPick cherryPick = new CherryPick();
        cherryPick.cherryPickup(grid);

    }

}
