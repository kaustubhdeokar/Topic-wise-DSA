//https://leetcode.com/problems/path-with-minimum-effort/submissions/

package graph.directed;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 */
public class MinEffortPathLeetcode {


    class EffortMatrix {
        int effort;
        int row;
        int col;

        EffortMatrix(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;
        int[][] visited = new int[rows][cols];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] efforts = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }

        PriorityQueue<EffortMatrix> q = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.effort, e2.effort));
        q.add(new EffortMatrix(0, 0, 0));
        return djikstrasForMinEffort(efforts, heights, visited, directions, q);

    }

    public int djikstrasForMinEffort(int[][] efforts, int[][] heights, int[][] visited, int[][] directions, PriorityQueue<EffortMatrix> q) {

        int rows = heights.length;
        int cols = heights[0].length;

        while (!q.isEmpty()) {

            EffortMatrix effortMatrix = q.remove();
            int effort = effortMatrix.effort;
            int row = effortMatrix.row;
            int col = effortMatrix.col;

            if (row == rows - 1 && col == cols - 1) {
                return effort;
            }

            while (!q.isEmpty() && visited[row][col] == 1) {
                effortMatrix = q.remove();
                row = effortMatrix.row;
                col = effortMatrix.col;
                effort = effortMatrix.effort;
            }

            visited[row][col] = 1;

            for (int i = 0; i < directions.length; i++) {

                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) 
                {
                    int newEffort = (Integer.max(effort, 
                    //submission mistake number 2, absolute diff should be taken to calculate effort from two cells. 
                    Math.abs(heights[newRow][newCol] - heights[row][col])));

                    if (newEffort < efforts[newRow][newCol]) {
                        // submission mistake one: update efforts matrix to keep least value alive.
                        efforts[newRow][newCol] = newEffort;
                        q.add(new EffortMatrix(newEffort, newRow, newCol));
                    }

                }
            }

        }

        return efforts[rows - 1][cols - 1]; // if it comes to this point, return the least calculated value for last cell.

    }

    public static void main(String[] args) {

        int[][] graph = {{10, 8}, {10, 8}, {1, 2}, {10, 3}, {1, 3}, {6, 3}, {5, 2}};
        MinEffortPathLeetcode minEffortPathLeetcode = new MinEffortPathLeetcode();
        System.out.println(minEffortPathLeetcode.minimumEffortPath(graph));

    }

}
