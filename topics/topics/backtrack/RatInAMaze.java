package backtrack;

import java.util.ArrayList;

public class RatInAMaze {

    public static void main(String[] args) {

        RatInAMaze ratInAMaze = new RatInAMaze();
        int[][] maze =
                {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};

        int n = maze.length;

        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        if (maze[0][0] != 0 && maze[n - 1][n - 1] != 0) {
            // Function call to get all valid paths
            ratInAMaze.findPath(0, 0, maze, n, result, currentPath);
        }

        System.out.println(result);
    }

    private void findPath(int i, int j, int[][] maze, int n, ArrayList<String> result, StringBuilder currentPath) {

        if (i == n - 1 && j == n - 1) {
            result.add(currentPath.toString());
            return;
        }

        String directions = "DULR";
        int[] xMoves = new int[]{1, -1, 0, 0};
        int[] yMoves = new int[]{0, 0, -1, 1};

        maze[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int nxtI = i + xMoves[k];
            int nxtJ = j + yMoves[k];

            if (isValid(nxtI, nxtJ, n, maze)) {

                currentPath.append(directions.charAt(k));
                findPath(nxtI, nxtJ, maze, n, result, currentPath);
                currentPath.deleteCharAt(currentPath.length() - 1);
            }
        }
        maze[i][j] = 1;
    }

    boolean isValid(int row, int col, int n, int[][] maze) {
        return row >= 0 && col >= 0 && row < n && col < n
                && maze[row][col] == 1;
    }

}
