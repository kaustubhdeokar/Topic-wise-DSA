package string.problems;

import java.util.HashMap;

/*
leetcode pod = 22nov
    so the question is to find max number of equal rows after any number of columns are flipped.
    so two rows can only be equal, if before flipping they have the same pattern.
    0 - 1
    1 - 0
    so it's a question about finding max repeating pattern.

 */

public class FlipsColsForMaxEqualRows {


    public int maxEqualRowsAfterFlips(int[][] matrix) {

        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder str = new StringBuilder();
            int prev = -1;
            for (int j = 0; j < matrix[0].length; j++) {
                if (prev == -1 || prev == matrix[i][j]) {
                    str.append("-");
                } else {
                    str.append("|-");
                }
                prev = matrix[i][j];
            }
            map.merge(str.toString(), 1, Integer::sum);
            System.out.println(map);
        }
        System.out.println(map);
        return result + 1;

    }

    public static void main(String[] args) {
        FlipsColsForMaxEqualRows flipsColsForMaxEqualRows = new FlipsColsForMaxEqualRows();
        int[][] matrix = {{1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}};
        System.out.println(flipsColsForMaxEqualRows.maxEqualRowsAfterFlips(matrix));
    }
}
