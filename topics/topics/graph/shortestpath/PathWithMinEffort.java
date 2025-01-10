package graph.shortestpath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//https://leetcode.com/problems/path-with-minimum-effort/
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
        int newI, newJ;
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int currI = curr[0];
            int currJ = curr[1];
            int currEffort = curr[2];
            System.out.println("i:" + currI + " j:" + currJ + " eff:" + currEffort);

            newI = currI + 1;
            newJ = currJ;
            if (valid(newI, newJ, rows, columns)) {
                addForNewCell(currI, currJ, newI, newJ, effort, heights, q);
            }

            newI = currI - 1;
            newJ = currJ;
            if (valid(newI, newJ, rows, columns)) {
                addForNewCell(currI, currJ, newI, newJ, effort, heights, q);
            }

            newI = currI;
            newJ = currJ + 1;
            if (valid(newI, newJ, rows, columns)) {
                addForNewCell(currI, currJ, newI, newJ, effort, heights, q);
            }

            newI = currI;
            newJ = currJ - 1;
            if (valid(newI, newJ, rows, columns)) {
                addForNewCell(currI, currJ, newI, newJ, effort, heights, q);
            }
        }
        return effort[rows - 1][columns - 1];
    }

    private void addForNewCell(int prevI, int prevJ, int newI, int newJ, int[][] effort, int[][] heights, PriorityQueue<int[]> q) {

        if (effort[newI][newJ] == Integer.MAX_VALUE ||
                (effort[newI][newJ] > Math.max(effort[prevI][prevJ], Math.abs(heights[prevI][prevJ] - heights[newI][newJ]))))
        {
            effort[newI][newJ] = Math.max(effort[prevI][prevJ], Math.abs(heights[prevI][prevJ] - heights[newI][newJ]));
            q.add(new int[]{newI, newJ, effort[newI][newJ]});

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
