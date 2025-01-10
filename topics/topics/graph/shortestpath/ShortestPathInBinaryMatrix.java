package graph.shortestpath;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
public class ShortestPathInBinaryMatrix {

    //there is also a way in which we can avoid using djikstra's here.
    //plain dfs will work here with shortest hops to the destination -> answer.

    //improvement: we don't need to track distances to reach a current node. it will be = current iteration (dfs)

    public static void main(String[] args) {

        ShortestPathInBinaryMatrix shortestPath = new ShortestPathInBinaryMatrix();
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        shortestPath.shortestPathBinaryMatrix(grid);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int len = grid.length;
        int rows = len;
        int cols = len;

        if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1)
            return -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) grid[i][j] = -1;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        grid[0][0] = -1;
        q.add(new int[]{0, 0});
        int count = 1;

        while (!q.isEmpty()) {

            int qSize = q.size();
            for(int size = 0; size < qSize; size++){

                int[] top = q.remove();
                int i = top[0];
                int j = top[1];

                if (i == len - 1 && j == len - 1) {
                    return count;
                }

                valid(i + 1, j - 1, len, q, grid);
                valid(i + 1, j, len, q, grid);
                valid(i + 1, j + 1, len, q, grid);

                valid(i, j + 1, len, q, grid);
                valid(i, j - 1, len, q, grid);

                valid(i - 1, j - 1, len, q, grid);
                valid(i - 1, j, len, q, grid);
                valid(i - 1, j + 1, len, q, grid);

            }

            count += 1;
            System.out.println("count:" + count);
        }

        return -1;

    }

    public void valid(int i, int j, int len, Queue<int[]> q,
                      int[][] grid) {

        if (i >= 0 && j >= 0 && i < len && j < len && grid[i][j] != -1) {
            grid[i][j] = -1;
            System.out.println("added:" + i + ":" + j);
            q.add(new int[]{i, j});
        }
    }
}
