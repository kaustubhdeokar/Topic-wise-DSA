package graph.matrix;

public class Enclaves {

    public int numEnclaves(int[][] grid) {
        //traverse the boundary - find all 1's.
            // as soon as 1 is found -> dfs on all 1's.
            // mark visited and traverse on neighbouring 1's.

        //count the remaining ones in the grid.

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int col = 0; col < cols; col++) {
            if (grid[0][col] == 1) {
                traverse(grid, visited, 0, col, rows, cols);
            }
            if (grid[rows - 1][col] == 1) {
                traverse(grid, visited, rows - 1, col, rows, cols);
            }
        }

        for (int row = 1; row < rows - 1; row++) {
            if (grid[row][0] == 1) {
                traverse(grid, visited, row, 0, rows, cols);
            }
            if (grid[row][cols - 1] == 1) {
                traverse(grid, visited, row, cols - 1, rows, cols);
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public void traverse(int[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {
        if (isValid(i, j, rows, cols) && grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            traverse(grid, visited, i + 1, j, rows, cols);
            traverse(grid, visited, i - 1, j, rows, cols);
            traverse(grid, visited, i, j + 1, rows, cols);
            traverse(grid, visited, i, j - 1, rows, cols);
        }
    }

    public boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }

    public static void main(String[] args) {

        Enclaves enclaves = new Enclaves();
        int[][] grid = new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int res = enclaves.numEnclaves(grid);
        System.out.println(res);


    }
}
