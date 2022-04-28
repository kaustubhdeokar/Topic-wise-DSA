import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ShortestPath {

    public static class Graph {
        static int vertices;
        static LinkedList<Integer>[] list;

        Graph(int vertices) {
            this.vertices = vertices;
            list = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++) {
                list[i] = new LinkedList<>();
            }
        }

        public void addEdge(int[][] edges) {
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

        public class NodePosition {
            int node;
            int position;

            NodePosition(int node, int pos) {
                this.node = node;
                this.position = pos;
            }
        }

        public void shortestPath() {

            Map<Integer, Integer> mapNodeToShortestPath = new HashMap<>();
            Stack<NodePosition> stack = new Stack<>();
            boolean[] visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    dfs(stack, visited, i, mapNodeToShortestPath);
                }
            }

            for (Map.Entry<Integer, Integer> entry : mapNodeToShortestPath.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }

        }

        public void dfs(Stack<NodePosition> stack, boolean[] visited, int source, Map<Integer, Integer> map) {


            if (map.get(source) == null) {
                stack.push(new NodePosition(source, 0));
                map.put(source, 0);
            }

            while (!stack.isEmpty()) {

                NodePosition top = stack.pop();
                int topNode = top.node;
                int topNodePos = top.position;

                if (!visited[topNode]) {
                    for (Integer i : list[topNode]) {
                        stack.push(new NodePosition(i, topNodePos + 1));

                        if (map.get(i)!=null && map.get(i) <= topNodePos)
                            continue;
                        map.put(i, topNodePos + 1);
                    }
                }
                visited[topNode] = true;

            }

        }


    }

    public static void main(String[] args) {

        int[][] edges = {{0, 1}, {1, 4}, {0, 2}, {2, 3}, {3, 4}, {3, 5}};
        ShortestPath.Graph g = new ShortestPath.Graph(6);
        g.addEdge(edges);
        g.shortestPath();
    }
}