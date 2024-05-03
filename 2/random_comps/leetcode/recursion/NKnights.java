package recursion;

public class NKnights {

    public static void main(String[] args) {


        int knightsToPlace = 4;
        int[][] matrix = new int[knightsToPlace][knightsToPlace];
        nKnights(matrix, 0, 0, knightsToPlace);
    }


    public static void nKnights(int[][] matrix, int row, int col, int knightsToPlace) {
        if (knightsToPlace == 0) {
            displayBoard(matrix);
            return;
        }

        if (row == matrix.length - 1 && col == matrix.length)
            return;

        if (col == matrix[row].length) {
            nKnights(matrix, row + 1, 0, knightsToPlace);
            return;

        }

        if (isValidCellForKnight(matrix, row, col)) {
            matrix[row][col] = 1;
            nKnights(matrix, row, col + 1, knightsToPlace - 1);
            matrix[row][col] = 0;
        }
        nKnights(matrix, row, col + 1, knightsToPlace);


    }

    private static void displayBoard(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValidCellForKnight(int[][] matrix, int row, int col) {

        //right-2 up-1.
        if (col < matrix[row].length - 2 && row > 0) {
            if (matrix[row - 1][col + 2] == 1)
                return false;
        }
        //up-2 right-1.
        //matrix[row-2][col+1]
        if (row > 1 && col < matrix[row].length - 1) {
            if (matrix[row - 2][col + 1] == 1)
                return false;
        }
        //left-2 up-1
        //matrix[row-1][col-2]
        if (col > 1 && row > 0) {
            if (matrix[row - 1][col - 2] == 1)
                return false;
        }
        //up-2 left-1
        //matrix[row-2][col-1]
        if (col > 0 && row > 1) {
            if (matrix[row - 2][col - 1] == 1)
                return false;
        }

        return true;
    }

}
