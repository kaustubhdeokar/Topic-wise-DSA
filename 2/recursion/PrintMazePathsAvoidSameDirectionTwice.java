//// to avoid movement in the same direction twice

//maze question with an additional thing. 

package backtracking;

import java.util.ArrayList;

public class PrintPathsInAMaze {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        PrintPathsInAMaze totalPaths = new PrintPathsInAMaze();
        //00 01 02
        //10 11 12
        //20 21 22
        ArrayList<String> list = totalPaths.paths(matrix, "", 0, 0, 2, 2);
        for (String s : list) {
            System.out.println(s);
        }

    }

    public ArrayList<String> paths(int[][] matrix, String path, int row, int col, int targetRow, int targetCol) {

        ArrayList<String> list = new ArrayList<>();
        if (row >= matrix.length || col >= matrix[row].length) {
            return list;
        }
        if (row == targetRow && col == targetCol) {
            list.add(path);
            return list;
        }
        if(path.length()!=0){
            if(path.charAt(path.length()-1)!='D') // to avoid movement in the same direction twice.)
                list.addAll(paths(matrix, path + "D", row + 1, col, targetRow, targetCol));
            if(path.charAt(path.length()-1)!='R')
                list.addAll(paths(matrix, path + "R", row, col + 1, targetRow, targetCol));

        }
        else {
            list.addAll(paths(matrix, path + "D", row + 1, col, targetRow, targetCol));
            list.addAll(paths(matrix, path + "R", row, col + 1, targetRow, targetCol));
        }
        return list;
    }

}
