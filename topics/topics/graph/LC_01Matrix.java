package graph;


import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

public class LC_01Matrix {

    public static void main(String[] args) {

        LC_01Matrix lc01Matrix = new LC_01Matrix();
        int[][] mat = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        lc01Matrix.updateMatrix(mat);

    }

    public int[][] updateMatrix(int[][] mat) {

        // start with all 0's and put them in a priority queue.
        // bfs to all 0's possible ->

        Comparator<int[]> distRowCol = (c1, c2) -> Integer.compare(c1[0], c1[0]);
        Queue<int[]> q = new ArrayDeque<>();
        int r = mat.length;
        int c = mat[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{0, i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        traverse(mat, q);
        return mat;
    }

    public void traverse(int[][] mat, Queue<int[]> q) {

        int rows = mat.length;
        int cols = mat[0].length;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] top = q.remove();
                int dist = top[0];
                int r = top[1];
                int c = top[2];

                if (isValid(r + 1, c, rows, cols) && dist + 1 < mat[r + 1][c]) {
                    mat[r + 1][c] = dist + 1;
                    q.add(new int[]{dist + 1, r + 1, c});
                }
                if (isValid(r - 1, c, rows, cols) && dist + 1 < mat[r - 1][c]) {
                    mat[r - 1][c] = dist + 1;
                    q.add(new int[]{dist + 1, r - 1, c});

                }
                if (isValid(r, c + 1, rows, cols) && dist + 1 < mat[r][c + 1]) {
                    mat[r][c + 1] = dist + 1;
                    q.add(new int[]{dist + 1, r, c + 1});
                }
                if (isValid(r, c - 1, rows, cols) && dist + 1 < mat[r][c - 1]) {
                    mat[r][c - 1] = dist + 1;
                    q.add(new int[]{dist + 1, r, c - 1});
                }
            }
        }
    }

    public boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }
}
