package dp.grid;

public class MinFallingSum {

    public int minFallingPathSum(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int min = Integer.MAX_VALUE;
                int newCol;
                for (newCol = c - 1; newCol <= c + 1; newCol++) {
                    if (valid(r - 1, newCol, rows, cols)) min = Integer.min(min, matrix[r - 1][newCol]);
                }
                matrix[r][c] += min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int c = 0; c < cols; c++) {
            min = Integer.min(min, matrix[rows - 1][c]);
        }

        return min;

    }

    public boolean valid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }


    public static void main(String[] args) {
        MinFallingSum minSum = new MinFallingSum();
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int sum = minSum.minFallingPathSum(matrix);
        System.out.println("sum:"+sum);
    }
}
