package graph.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {

        NumberOfDistinctIslands num = new NumberOfDistinctIslands();
        int[][] graph = new int[][]{
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        num.numberOfDistinctIslands(graph);
    }

    private boolean validCell(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public void calculateGroupDetails(int[][] graph, int currRow, int currCol, ArrayList<int[]> path) {

        if (validCell(graph.length, graph[0].length, currRow, currCol)) {
            if (graph[currRow][currCol] != 1) return;
            graph[currRow][currCol] = 2;
            path.add(new int[]{currRow, currCol});
            calculateGroupDetails(graph, currRow + 1, currCol, path);
            calculateGroupDetails(graph, currRow, currCol - 1, path);
            calculateGroupDetails(graph, currRow, currCol + 1, path);
        }
    }

    public int numberOfDistinctIslands(int[][] graph) {

        // bfs on r,c=1 (store the cells subtracted from the base row and base col)
        // store them in a set and return the count

        int rows = graph.length;
        int cols = graph[0].length;

        Set<String> distinctGroups = new HashSet<>();
        for (int baseRow = 0; baseRow < rows; baseRow++) {
            for (int baseCol = 0; baseCol < cols; baseCol++) {
                if (graph[baseRow][baseCol] == 1) {
                    ArrayList<int[]> path = new ArrayList<>();
                    calculateGroupDetails(graph, baseRow, baseCol, path);
                    StringBuilder str = new StringBuilder();
                    for (int[] p : path) {
                        str.append(p[0] - baseRow).append(p[1] - baseCol);
                    }
                    distinctGroups.add(str.toString());
                }
            }
        }

        for (String s : distinctGroups) {
            System.out.println(s);
        }
        return 0;
    }

}
