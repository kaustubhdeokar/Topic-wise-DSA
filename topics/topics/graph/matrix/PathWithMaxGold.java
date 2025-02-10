package graph.matrix;

public class PathWithMaxGold {

    public static void main(String[] args) {
        PathWithMaxGold path = new PathWithMaxGold();
        int[][] graph = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        path.getMaximumGold(graph);
    }

    public int getMaximumGold(int[][] graph) {

        int maxVal = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {

                if (graph[i][j] != 0) {
                    int val = traverse(graph, i, j);
                    //System.out.println("i:" + i + " j:" + j + " val:" + val);
                    maxVal = Integer.max(maxVal, val);
                }

            }
        }
        return maxVal;
    }

    public int traverse(int[][] graph, int i, int j) {

        if (checkValidity(graph, i, j)) {
            int val = graph[i][j];

            int temp = graph[i][j];
            graph[i][j] -= temp;

            int down = traverse(graph, i + 1, j);
            int up = traverse(graph, i - 1, j);
            int right = traverse(graph, i, j + 1);
            int left = traverse(graph, i, j - 1);

            graph[i][j] += temp;

            return val + getMax(down, up, right, left); // this is important that we take max of any one direction.
            // as it states in the question we cannot go back from the path.
        }

        return 0;
    }

    public static int getMax(int a, int b, int c, int d) {
        return Integer.max(a, Integer.max(b, Integer.max(c, d)));
    }

    public static boolean checkValidity(int[][] graph, int i, int j) {
        return i >= 0 && i < graph.length && j >= 0 && j < graph[i].length &&
                graph[i][j] != 0;
    }
}
