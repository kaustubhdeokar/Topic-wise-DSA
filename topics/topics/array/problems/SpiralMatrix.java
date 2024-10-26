package array.problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {


        // row rowstart : c(colstart) to c(colend) -> rowstart+=1
        // col (colend): row (rowstart:rowend) -> colend-=1
        // row(rowend): col (colend:colstart): rowend-=1
        // col colstart: row(rowend:rowstart): colstart+=1

        int rowstart = 0;
        int rowend = matrix.length - 1;
        int colstart = 0;
        int colend = matrix[0].length - 1;
        List<Integer> answer = new ArrayList<>();
        while (rowstart <= rowend && colstart <= colend) {

            for (int col = colstart; col <= colend; col++) {
                answer.add(matrix[rowstart][col]);
            }
            rowstart += 1;

            for (int row = rowstart; row <= rowend; row++) {
                answer.add(matrix[row][colend]);
            }
            colend -= 1;

            if (rowstart > rowend || colstart > colend) {
                break;
            }

            for (int col = colend; col >= colstart; col--) {
                answer.add(matrix[rowend][col]);
            }
            rowend -= 1;

            for (int row = rowend; row >= rowstart; row--) {
                answer.add(matrix[row][colstart]);
            }
            colstart += 1;

        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> spiralOrderList = spiralMatrix.spiralOrder(matrix);
        System.out.println(spiralOrderList);


    }

}
