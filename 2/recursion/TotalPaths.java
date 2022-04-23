package backtracking;

public class TotalPaths {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};
        TotalPaths totalPaths = new TotalPaths();
        System.out.println(totalPaths.paths(matrix, 0, 0, 2, 2));

    }

    public int paths(int[][] matrix, int row, int col, int targetRow, int targetCol) {
        if (row >= matrix.length || col >= matrix[row].length) {
            return 0;
        }
        if (row == targetRow && col == targetCol) {
            return 1;
        }
        int numPaths = paths(matrix, row + 1, col, targetRow, targetCol);
        numPaths += paths(matrix, row, col + 1, targetRow, targetCol);
        return numPaths;
    }

}
