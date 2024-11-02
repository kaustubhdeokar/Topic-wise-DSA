package graph;

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
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j + 1, 1});
                    q.add(new int[]{i, j - 1, 1});
                    q.add(new int[]{i + 1, j, 1});
                    q.add(new int[]{i - 1, j, 1});

                    traverse(grid, i, j, visited, q);
                }
            }
        }
        int maxTime = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (visited[i][j] == 0) {
                        return -1;
                    }
                    maxTime = Integer.max(maxTime, visited[i][j]);
                }
            }
        }
        return maxTime;

    }

    public void traverse(int[][] arr, int i, int j, int[][] visited, Queue<int[]> q) {
        int rows = arr.length;
        int cols = arr[0].length;

        while (!q.isEmpty()) {
            int[] top = q.remove();
            int topi = top[0];
            int topj = top[1];
            int time = top[2];

            if (isValid(topi, topj, rows, cols) && arr[topi][topj] == 1) {

                if (visited[topi][topj] == 0 || time < visited[topi][topj]) {
                    visited[topi][topj] = time;
                    q.add(new int[]{topi, topj + 1, time + 1});
                    q.add(new int[]{topi, topj - 1, time + 1});
                    q.add(new int[]{topi + 1, topj, time + 1});
                    q.add(new int[]{topi - 1, topj, time + 1});
                }
            }
        }

    }

    public boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }

}
