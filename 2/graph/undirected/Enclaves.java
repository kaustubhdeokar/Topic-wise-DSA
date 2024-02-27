import java.util.ArrayDeque;

public class Enclaves {

    class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override public String toString(){
            return "i:"+i+" j:"+j;
        }
    }

    public int numberOfEnclaves(int[][] grid) {

        ArrayDeque<Node> q = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                q.add(new Node(i, 0));
            }
            if (grid[i][rows - 1] == 1) {
                q.add(new Node(i, rows - 1));
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                q.add(new Node(0, i));
            }
            if (grid[rows - 1][i] == 1) {
                q.add(new Node(rows - 1, i));
            }
        }
        
        coverOnesReachableFromOnesOnBoundary(grid, q);

        int countOnes = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    countOnes += 1;
                }
            }
        }

        return countOnes;

    }

    public void coverOnesReachableFromOnesOnBoundary(int[][] grid, ArrayDeque<Node> q) {

        while (!q.isEmpty()) {
            Node top = q.remove();
            int i = top.i;
            int j = top.j;
            grid[i][j] = 2;

            if (valid(grid, i + 1, j)) {
                q.add(new Node(i + 1, j));
            }
            if (valid(grid, i - 1, j)) {
                q.add(new Node(i + 1, j));
            }
            if (valid(grid, i, j + 1)) {
                q.add(new Node(i, j + 1));
            }
            if (valid(grid, i, j - 1)) {
                q.add(new Node(i, j - 1));
            }
        }

    }

    public boolean valid(int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 } };

        Enclaves enclaves = new Enclaves();
        System.out.println(enclaves.numberOfEnclaves(grid));

    }
}
