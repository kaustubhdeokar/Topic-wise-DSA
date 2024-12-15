package graph;

public class FloydWarshall {
    private static final int INF = Integer.MAX_VALUE;

    private void calculate(int[][] graph) {

        int n = graph.length;
        for(int k=0; k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    graph[i][j] = Integer.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }


    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 } };

        FloydWarshall warshall = new FloydWarshall();
        warshall.calculate(graph);

    }


}
