package leetcode.leetcodeJun;

import java.util.*;
//https://leetcode.com/contest/weekly-contest-348/problems/sum-of-matrix-after-queries/

public class SumOfMatrixAfterQueries {

    static class RowColMappedToValueTime {
        int value;
        int time;

        int rowCol;

        public RowColMappedToValueTime(int rowCol, int value, int time) {
            this.rowCol = rowCol;
            this.value = value;
            this.time = time;
        }

    }

    public static void main(String[] args) {

        int n = 3;
        int[][] queries = {{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}};
        System.out.println("ans:" + approach1(n, queries));
        System.out.println("ans:" + approach2(n, queries));
    }

    /**
     * Here additionally we can not construct the final matrix, but calculate results from
     * 1. how many rows or columns are empty at that point of time.
     * 2. add to result (empty rows * value) or (empty cols* value)
     * a. in case of rows , reduce empty row for x to 0 and for reduce all cols by 1.
     * b. vice versa in cols, reduce empty cols for y to 0 and for all rows by 1.
     *
     * @return
     */
    private static long approach2(int n, int[][] queries) {

        int[] rows = new int[n];
        Arrays.fill(rows, n);
        int[] cols = new int[n];
        Arrays.fill(cols, n);
        long sum = 0;

        for (int i = queries.length - 1; i >= 0; i--) {

            int[] currQuery = queries[i];

            int rowCol = currQuery[1];
            int value = currQuery[2];

            if (currQuery[0] == 0) {

                if (rows[rowCol] >= 1) {
                    sum += value * rows[rowCol];
                    rows[rowCol] = 0;
                    for (int j = 0; j < n; j++) {
                        cols[j] -= 1;
                    }
                }

            } else {

                if (cols[rowCol] >= 1) {
                    sum += value * cols[rowCol];
                    cols[rowCol] = 0;
                    for (int j = 0; j < n; j++) {
                        rows[j] -= 1;
                    }
                }

            }


        }

        return sum;
        //rows , cols will contain updated value.


    }

    /**
     * Maintaining the last updated value for row and column and then constructing matrix according to the values.
     */
    private static long approach1(int n, int[][] queries) {

        ArrayList<RowColMappedToValueTime> rowList = new ArrayList<>(n);
        ArrayList<RowColMappedToValueTime> colList = new ArrayList<>(n);

        int time = 0;

        for (int[] curr : queries) {

            int rowCol = curr[1];
            int value = curr[2];

            if (curr[0] == 0) {
                rowList.add(new RowColMappedToValueTime(rowCol, value, time));
            } else {
                colList.add(new RowColMappedToValueTime(rowCol, value, time));
            }
            time += 1;
        }

        Comparator<RowColMappedToValueTime> comparator = (c1, c2) -> Integer.compare(c1.time, c2.time);
        Collections.sort(rowList, comparator);
        Collections.sort(colList, comparator);

        int[][] matrix = new int[n][n];

        int rowCount = 0;
        int colCount = 0;

        while (rowCount < rowList.size() && colCount < colList.size()) {

            RowColMappedToValueTime rowValue = rowList.get(rowCount);
            RowColMappedToValueTime colValue = colList.get(colCount);

            if (rowValue.time < colValue.time) {
                int row = rowValue.rowCol;
                int value = rowValue.value;

                for (int i = 0; i < n; i++) {
                    matrix[row][i] = value;
                }
                rowCount += 1;
            } else {

                int col = colValue.rowCol;
                int value = colValue.value;

                for (int i = 0; i < n; i++) {
                    matrix[i][col] = value;
                }

                colCount += 1;
            }

        }

        while (rowCount < rowList.size()) {
            RowColMappedToValueTime rowValue = rowList.get(rowCount);
            int row = rowValue.rowCol;
            int value = rowValue.value;

            for (int i = 0; i < n; i++) {
                matrix[row][i] = value;
            }
            rowCount += 1;
        }

        while (colCount < colList.size()) {
            RowColMappedToValueTime colValue = colList.get(colCount);
            int col = colValue.rowCol;
            int value = colValue.value;

            for (int i = 0; i < n; i++) {
                matrix[i][col] = value;
            }

            colCount += 1;

        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

}
