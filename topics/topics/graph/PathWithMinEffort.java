package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    public int minimumEffort(int rows, int columns, int[][] heights) {

        int[][] effort = new int[rows][columns];
        for (int[] eff : effort) {
            Arrays.fill(eff, Integer.MAX_VALUE);
        }

        Comparator<int[]> effortComp = (c1, c2) -> c1[2] - c2[2];
        PriorityQueue<int[]> q = new PriorityQueue<>(effortComp);

        effort[0][0] = 0;
        q.add(new int[]{0, 0, 0}); //i,j,effort.
        int ni, nj;
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            int eff = curr[2];
            System.out.println("i:" + i + " j:" + j + " eff:" + eff);

            ni = i + 1;
            nj = j;
            if (valid(ni, nj, rows, columns)) {
                addForNewCell(i, j, ni, nj, effort, heights, q);
            }

            ni = i - 1;
            nj = j;
            if (valid(ni, nj, rows, columns)) {
                addForNewCell(i, j, ni, nj, effort, heights, q);
            }

            ni = i;
            nj = j + 1;
            if (valid(ni, nj, rows, columns)) {
                addForNewCell(i, j, ni, nj, effort, heights, q);
            }

            ni = i;
            nj = j - 1;
            if (valid(ni, nj, rows, columns)) {
                addForNewCell(i, j, ni, nj, effort, heights, q);
            }
        }
        return effort[rows - 1][columns - 1];
    }

    private void addForNewCell(int i, int j, int ni, int nj, int[][] effort, int[][] heights, PriorityQueue<int[]> q) {

        if (effort[ni][nj] == Integer.MAX_VALUE || (effort[ni][nj] > Math.max(effort[i][j], Math.abs(heights[i][j] - heights[ni][nj]))))
        {
            effort[ni][nj] = Math.max(effort[i][j], Math.abs(heights[i][j] - heights[ni][nj]));
            q.add(new int[]{ni, nj, effort[ni][nj]});

        }
    }

    public boolean valid(int i, int j, int r, int c) {
        return i >= 0 && j >= 0 && i < r && j < c;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        PathWithMinEffort pathWithMinEffort = new PathWithMinEffort();
        int result = pathWithMinEffort.minimumEffort(arr.length, arr[0].length, arr);
        System.out.println(result);

    }
}
