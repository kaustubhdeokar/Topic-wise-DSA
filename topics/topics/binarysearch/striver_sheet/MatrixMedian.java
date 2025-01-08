package binarysearch.striver_sheet;

//https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/
public class MatrixMedian {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {8, 9, 11, 12, 13},
                {21, 23, 25, 27, 29}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        MatrixMedian matrixMedian = new MatrixMedian();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][cols - 1]);
        }

        int required = rows * cols / 2;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int nums = matrixMedian.findUpperBound(matrix, mid);
            if(nums > required){
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }


    }


    private int findUpperBound(int[][] matrix, int num) {

        int count = 0;
        for (int r = 0; r < matrix.length; r++) {
            int start = 0;
            int end = matrix[r].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[r][mid] <= num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            count += start;
        }
        return count;
    }


}
