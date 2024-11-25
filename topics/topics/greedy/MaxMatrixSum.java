package greedy;

public class MaxMatrixSum {

    /*
    we have to maximise the matrix sum.
    here the catch is two numbers can be multiplied by -1 at a time.
    * */
    public long maxMatrixSum(int[][] matrix) {

        long sum = 0;
        int minVal = Integer.MAX_VALUE;
        int negatives = 0;
        int zeroes = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]<0) negatives+=1;
                else if(matrix[i][j]==0) zeroes+=1;
                int abs = Math.abs(matrix[i][j]);
                minVal = Integer.min(minVal, abs);
                sum += abs;
            }
        }

        if(negatives%2!=0 && zeroes==0){
            sum -= 2*minVal;
        }
        return sum;
    }
}
