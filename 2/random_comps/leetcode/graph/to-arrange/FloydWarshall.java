public class FloydWarshall {

    public final static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {

        long[][] graph = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}};
        FloydWarshall floydWarshall = new FloydWarshall();
        graph = floydWarshall.computeShortestPaths(graph);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private long[][] computeShortestPaths(long[][] graph) {

        for (int currVertex = 0; currVertex < graph.length; currVertex++) {

            long[][] updatedGraph = graph;

            for (int j = 0; j < updatedGraph.length; j++) {
                for (int k = 0; k < updatedGraph[j].length; k++) {

                    if (j == currVertex || k == currVertex)
                        updatedGraph[j][k] = graph[j][k]; // leave the curr row & col

                    else if (j == k)
                        updatedGraph[j][k] = 0; // leave the row=col (0,0) (1,1)

                    else // currvertex as the mid, calculate min of ((source,destination) & (source,currVertex)+(currVertex,destination))
                        updatedGraph[j][k] = Long.min(updatedGraph[j][k], updatedGraph[j][currVertex] + updatedGraph[currVertex][k]);
                }
            }
            graph = updatedGraph;
        }
        return graph;

    }


}
