import java.util.LinkedList;
import java.util.Stack;

public class GraphIsATree {

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

        public static boolean isTree(GraphIsATree.Graph g) {

            int vertices = g.vertices;
            boolean[] visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    if (!dfs(i, visited))
                        return false;
                }
            }
            return true;
        }

        public static boolean dfs(int vertex, boolean[] visited) {

            Stack<Integer> stack = new Stack<>();
            stack.push(vertex);

            while (!stack.isEmpty()) {

                Integer top = stack.pop();

                if (!visited[top]) {
                    for (Integer i : list[top]) {
                        stack.push(i);
                    }
                } else {
                    //is a node is visited again, there are multiple parents to a single node,
                    //which is not the case in a tree.
                    System.out.println("top is visited" + top);
                    return false;
                }
                visited[top] = true;
            }

            return true;
        }

    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {2, 3}, {1, 3}, {3, 4}, {2, 5}, {5, 6}, {6, 7}};
        GraphIsATree.Graph g = new GraphIsATree.Graph(7);
        g.addEdge(edges);
        System.out.println(g.isTree(g));

    }


}
