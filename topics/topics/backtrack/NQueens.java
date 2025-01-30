package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {

    public static void main(String[] args) {
        NQueens q = new NQueens();
        System.out.println(q.solveNQueens(5));
    }

    public List<List<String>> solveNQueens(int n) {
        int N = n;
        int rows = n;
        int cols = n;
        return traverse(rows, cols, N);
    }

    public List<List<String>> traverse(int rows, int cols, int n) {
        List<int[]> visited = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        traverse(0, 0, rows, cols, n, visited, res);
        return res;

    }

    private List<String> createEntry(List<int[]> visited, int rows, int cols) {
        List<StringBuilder> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            StringBuilder column = new StringBuilder();
            for (int j = 0; j < cols; j++) column.append(".");
            result.add(column);
        }

        for (int[] vis : visited) {
            int i = vis[0];
            int j = vis[1];
            result.get(i).setCharAt(j, 'Q');
        }
        return result.stream().map(strBuilder -> strBuilder.toString()).collect(Collectors.toList());
    }

    public boolean traverse(int i, int j, int rows, int cols, int N, List<int[]> visited, List<List<String>> res) {

        if (N == 0) {
            res.add(createEntry(visited, rows, cols));
            return true;
        }

        if (i >= rows || j >= cols) return false;

        if (isSafe(i, j, rows, cols, visited)) {
            int[] next = nextMov(i, j, rows, cols);
            int nextI = next[0], nextJ = next[1];
            visited.add(new int[]{i, j});
            traverse(nextI, nextJ, rows, cols, N - 1, visited, res);
            visited.remove(visited.size() - 1);
            traverse(nextI, nextJ, rows, cols, N , visited, res);
        }
        else {
            int[] next = nextMov(i, j, rows, cols);
            int nextI = next[0], nextJ = next[1];
            traverse(nextI, nextJ, rows, cols, N, visited, res);
        }
        return false;
    }

    public boolean isSafe(int i, int j, int rows, int cols, List<int[]> visited) {
        //same row or col
        for (int[] vis : visited) {
            if (vis[0] == i) return false;
            if (vis[1] == j) return false;
            double slope = (Math.abs(j - vis[1]) / (1.0 * Math.abs(i - vis[0])));
            if (slope == 1.0) return false;
            //diagonal to any piece, slope != 1;
        }
        return true;
    }

    public int[] nextMov(int currI, int currJ, int rows, int cols) {
        int nextI = -1, nextJ = -1;
        if (currI == rows - 1) {
            nextI = 0;
            nextJ = currJ + 1;
        } else {
            nextI = currI + 1;
            nextJ = currJ;
        }
        return new int[]{nextI, nextJ};
    }

}

