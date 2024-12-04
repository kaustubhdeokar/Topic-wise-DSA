package dp.problems;

public class MinFallingSum {

    //todo: using top-to-bottom dp.

    public int minFallingPathSum(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int r=1;r<rows;r++){
            for(int c=0;c<cols;c++){
                int min = Integer.MAX_VALUE;
                if(c>0){
                    min = Integer.min(min, matrix[r-1][c-1]);
                }
                if(c<=cols-2){
                    min = Integer.min(min, matrix[r-1][c+1]);
                }
                min = Integer.min(min, matrix[r-1][c]);
                matrix[r][c] += min;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int c=0;c<cols;c++){
            min = Integer.min(min, matrix[rows-1][c]);
        }

        return min;

    }

    public static void main(String[] args) {

    }
}
