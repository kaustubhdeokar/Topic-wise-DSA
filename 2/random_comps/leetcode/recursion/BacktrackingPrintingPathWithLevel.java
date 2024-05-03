package recursion;

import java.util.ArrayList;

public class PrintPathsInAMaze {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 0, 0}};
        PrintPathsInAMaze totalPaths = new PrintPathsInAMaze();
        //00 01 02
        //10 11 12
        int[][] levelmatrix = {{0, 0, 0}, {0, 0, 0}};

        ArrayList<String> list = totalPaths.paths(matrix, levelmatrix, "", 0, 0, 1, 2, 0);
    }

    public ArrayList<String> paths(int[][] matrix, int[][] levelmatrix, String path, int row, int col, int targetRow, int targetCol, int levelOfRecursion) {

        ArrayList<String> list = new ArrayList<>();
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) {
            return list;
        }

        if (row == targetRow && col == targetCol) {
            for (int i = 0; i < levelmatrix.length; i++) {
                for (int j = 0; j < levelmatrix[i].length; j++) {
                    System.out.print(levelmatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Path:" + path);
            list.add(path);
            return list;
        }

        if (matrix[row][col] == 1)
            return list;

        matrix[row][col] = 1;
        levelmatrix[row][col] = levelOfRecursion;


        list.addAll(paths(matrix, levelmatrix, path + "D", row + 1, col, targetRow, targetCol, levelOfRecursion + 1));
        list.addAll(paths(matrix, levelmatrix, path + "R", row, col + 1, targetRow, targetCol, levelOfRecursion + 1));
        list.addAll(paths(matrix, levelmatrix, path + "U", row - 1, col, targetRow, targetCol, levelOfRecursion + 1));
        list.addAll(paths(matrix, levelmatrix, path + "L", row, col - 1, targetRow, targetCol, levelOfRecursion + 1));

        matrix[row][col] = 0;
        levelmatrix[row][col] = 0;
        return list;
    }

}
