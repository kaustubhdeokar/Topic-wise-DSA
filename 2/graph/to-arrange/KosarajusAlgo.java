import java.util.LinkedList;
import java.util.Stack;

public class KosarajusAlgo {

    public static class Graph {

        static int vertices;
        static LinkedList<Integer>[] list;

        Graph(int vertices) {
            this.vertices = vertices;
            list = new LinkedList[vertices + 1];

            for (int i = 1; i <= vertices; i++)
                list[i] = new LinkedList<>();
        }

        public static void addEdge(int[][] edges) {

            for (int i = 0; i < edges.length; i++) {
                addEdge(edges[i][0], edges[i][1], false);
            }

        }

        public static void addEdge(int source, int destination, boolean isBidirectional) {
            list[source].add(destination);
            if (isBidirectional) {
                list[destination].add(source);
            }
        }

        //The theory is that the last vertex visited in the recursive DFS will be the mother vertex. T
        public void kosarajusAlgo() {
            boolean[] visited = new boolean[vertices + 1];
            int lastVertexVisited = -1;
            for (int i = 1; i <= vertices; i++) {
                if (!visited[i]) {
                    lastVertexVisited = dfsRecursive(i, visited);
                }
            }
            System.out.println("lastvertext visited is always the mother node, if there is any." + lastVertexVisited);
        }

        public static int dfsRecursive(int vertex, boolean[] visited) {

            Stack<Integer> stack = new Stack<>();
            stack.push(vertex);
            int lastVis = -1;
            while (!stack.isEmpty()) {
                Integer top = stack.pop();
                if (!visited[top]) {
                    for (Integer i : list[top]) {
                        dfsRecursive(i, visited);
                    }
                    visited[top] = true;
                    lastVis = top;
                }
            }

            return lastVis;
        }

    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {2, 3}, {1, 3}, {3, 4}, {2, 5}, {5, 6}, {6, 7}};
        KosarajusAlgo.Graph g = new Graph(7);
        g.addEdge(edges);
        g.kosarajusAlgo();

    }


}
