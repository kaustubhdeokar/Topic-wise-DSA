//https://leetcode.com/problems/as-far-from-land-as-possible/


import java.util.ArrayDeque;
import java.util.ArrayList;

public class FarthestCell {

    public int maxDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    grid[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == -1) {

                    boolean[][] visited = new boolean[m][n];
                    ArrayDeque<Pair> queue = new ArrayDeque<>();
                    queue.push(new Pair(i + 1, j, 1));
                    queue.push(new Pair(i - 1, j, 1));
                    queue.push(new Pair(i, j + 1, 1));
                    queue.push(new Pair(i, j - 1, 1));

                    breathfirstsearch(grid, visited, queue);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        return 0;
    }

    class Pair {
        int xpos;
        int ypos;
        int count;

        public Pair(int xpos, int ypos, int count) {
            this.xpos = xpos;
            this.ypos = ypos;
            this.count = count;
        }
    }

    private void breathfirstsearch(int[][] grid, boolean[][] visited, ArrayDeque<Pair> queue) {


        while (!queue.isEmpty()) {

            Pair top = queue.pop();
            int x = top.xpos;
            int y = top.ypos;
            int count = top.count;


            if (boundaryCheck(x, y, grid) && !visited[x][y] && grid[x][y] != -1) {
                //grid[x][y] => -1 represents a 1 (land) (hence avoid)

                if (grid[x][y] == 0)
                    grid[x][y] = count;
                else
                    grid[x][y] = Integer.min(grid[x][y], count);

                queue.add(new Pair(x - 1, y, count + 1));
                queue.add(new Pair(x + 1, y, count + 1));
                queue.add(new Pair(x, y + 1, count + 1));
                queue.add(new Pair(x, y - 1, count + 1));
                visited[x][y] = true;
            }


        }

    }

    public boolean boundaryCheck(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public static void main(String[] args) {

        FarthestCell farthestCell = new FarthestCell();
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        farthestCell.maxDistance(matrix);

    }
}
