package backtracking;

public class NQueens {

    public static void main(String[] args) {


        int queensToPlace = 5;
        int[][] matrix = new int[5][5];

        int ans = nQueens(matrix, 0); // starting can be on any cell in the first row.
        System.out.println(ans);
    }

    public static int nQueens(int[][] matrix, int row) {
        int count = 0;
        if (row == matrix.length) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return count + 1;
        }

        for (int i = 0; i < matrix.length; i++) {

            if (isValidCell(matrix, row, i)) {
                matrix[row][i] = 1;
                count += nQueens(matrix, row + 1);
                matrix[row][i] = 0;
            }

        }

        return count;

    }

    public static boolean isValidCell(int[][] matrix, int row, int col) {

        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
            return false; //limit check.

        //horizontal - don't need this, as every queen is on a new row.
//        for (int i = 0; i < col; i++) {
//            if (matrix[row][i] == 1)
//                return false;
//        }

        for (int j = 0; j < row; j++) {
            if (matrix[j][col] == 1)
                return false;
        }

        //00 01 02
        //10 11 12
        //20 21 22

        //left diagonally up.
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[i].length) {
            if (matrix[i][j] == 1)
                return false;
            i -= 1;
            j -= 1;
        }
//       left diagonally down - don't need this, check for already placed queens.
//
//        i = row + 1;
//        j = col - 1;
//
//        while (i > 0 && j > 0 && i < matrix.length && j < matrix[i].length) {
//            if (matrix[i][j] == 1)
//                return false;
//            i += 1;
//            j -= 1;
//        }

//       right diagonally down- don't need this, check for already placed queens.
//        i = row + 1;
//        j = col + 1;
//        while (i > 0 && j > 0 && i < matrix.length && j < matrix[i].length) {
//            if (matrix[i][j] == 1)
//                return false;
//            i += 1;
//            j += 1;
//        }
//       right diagonally up.

        i = row - 1;
        j = col + 1;
        while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[i].length) {
            if (matrix[i][j] == 1)
                return false;
            i -= 1;
            j += 1;
        }

        return true;

    }


}
