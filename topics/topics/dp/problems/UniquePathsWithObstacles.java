package dp.problems;

import java.util.Arrays;
import java.util.OptionalInt;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        UniquePathsWithObstacles obstacles = new UniquePathsWithObstacles();
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        int res = obstacles.uniquePathsWithObstacles(grid);
        System.out.println(res);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        OptionalInt min = Arrays.stream(obstacleGrid[0]).min();
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        if (m <= 1 && n <= 1) return 1;

        int[][] grid = new int[m][n];
        int i = 1;
        while (i < m) {
            while (i < m && obstacleGrid[i][0] == 0) {
                grid[i][0] = 1;
                i += 1;
            }
            while (i < m) {
                grid[i][0] = 0;
                i += 1;
            }
        }

        i = 1;
        while (i < n) {
            while (i < n && obstacleGrid[0][i] == 0) {
                grid[0][i] = 1;
                i += 1;
            }
            while (i < n) {
                grid[0][i] = 0;
                i += 1;
            }
        }

        for (i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) grid[i][j] = 0;
                else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }

        }

        return grid[m - 1][n - 1];
    }
}
