package graph;

public class NumOfEnclaves {

    public int numEnclaves(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int maxCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)
                    dfsToElimateBorderOnes(i, j, grid, visited);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    maxCount += 1;
            }
        }

        return maxCount;
    }

    public void dfsToElimateBorderOnes(int i, int j, int[][] grid, boolean[][] visited) {

        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {

            grid[i][j] = 0;

            dfsToElimateBorderOnes(i - 1, j, grid, visited);
            dfsToElimateBorderOnes(i + 1, j, grid, visited);
            dfsToElimateBorderOnes(i, j - 1, grid, visited);
            dfsToElimateBorderOnes(i, j + 1, grid, visited);
        }

    }

    public static void main(String[] args) {


        int[][] matrix = {{0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 0, 1, 1, 1}, {0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {0, 1, 1, 0, 0, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 1, 1, 1, 0, 1}, {0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};
        NumOfEnclaves numOfEnclaves = new NumOfEnclaves();
        numOfEnclaves.numEnclaves(matrix);


    }

}
