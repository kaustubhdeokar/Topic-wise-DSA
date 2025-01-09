package graph.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int result = rottingOranges.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println(result);
    }

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        //there can be multiple rotten oranges.
        //add all into a queue, so that bfs is used to find the shortest path to the fresh oranges.
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        return traverse(grid, q);

    }

    public int traverse(int[][] arr, Queue<int[]> q) {
        int rows = arr.length;
        int cols = arr[0].length;
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] top = q.remove();
                int i = top[0];
                int j = top[1];

                if (isValid(i + 1, j, rows, cols) && arr[i + 1][j] == 1) {
                    arr[i + 1][j] = 2;
                    q.add(new int[]{i + 1, j});
                }
                if (isValid(i, j + 1, rows, cols) && arr[i][j + 1] == 1) {
                    arr[i][j + 1] = 2;
                    q.add(new int[]{i, j + 1});
                }
                if (isValid(i - 1, j, rows, cols) && arr[i - 1][j] == 1) {
                    arr[i - 1][j] = 2;
                    q.add(new int[]{i - 1, j});
                }
                if (isValid(i, j - 1, rows, cols) && arr[i][j - 1] == 1) {
                    arr[i][j - 1] = 2;
                    q.add(new int[]{i, j - 1});
                }
                size -= 1;
            }
            time += 1;
        }
        return time;
    }

    public boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }

}
