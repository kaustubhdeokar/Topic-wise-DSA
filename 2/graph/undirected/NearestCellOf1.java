//https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

import java.util.ArrayDeque;

public class NearestCellOf1 {

    class NodeToDist {
        int i;
        int j;
        int dist;

        NodeToDist(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }

        public String toString() {
            return "i:" + i + " j:" + j + " d:" + dist;
        }
    }

    public int[][] nearest(int[][] grid) {

        int[][] result = new int[grid.length][grid[0].length];
        ArrayDeque<NodeToDist> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result[i][j] = 0;
                    q.add(new NodeToDist(i, j, 0));
                } else {
                    result[i][j] = -1;
                }
            }
        }

        bfs(q, grid, result);

        return result;

    }

    public void bfs(ArrayDeque<NodeToDist> q, int[][] grid, int[][] result) {

        while (!q.isEmpty()) {

            NodeToDist top = q.remove();

            int currI = top.i;
            int currJ = top.j;
            int currD = top.dist;

            if (valid(currI + 1, currJ, result)) {
                result[currI + 1][currJ] = currD + 1;
                q.add(new NodeToDist(currI + 1, currJ, currD + 1));
            }
            if (valid(currI - 1, currJ, result)) {
                result[currI - 1][currJ] = currD + 1;
                q.add(new NodeToDist(currI - 1, currJ, currD + 1));
            }
            if (valid(currI, currJ + 1, result)) {
                result[currI][currJ + 1] = currD + 1;
                q.add(new NodeToDist(currI, currJ + 1, currD + 1));
            }
            if (valid(currI, currJ - 1, result)) {
                result[currI][currJ - 1] = currD + 1;
                q.add(new NodeToDist(currI, currJ - 1, currD + 1));
            }


        }

    }

    public boolean valid(int i, int j, int[][] result) {
        return i >= 0 && i < result.length && j >= 0 && j < result[0].length && result[i][j] == -1;
    }

    public static void main(String[] args) {

        int[][] grid = {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}};
        NearestCellOf1 nearestCellOf1 = new NearestCellOf1();
        int[][] result = nearestCellOf1.nearest(grid);

        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

}
