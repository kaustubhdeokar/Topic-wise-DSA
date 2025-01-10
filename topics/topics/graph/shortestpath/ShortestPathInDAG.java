package graph.shortestpath;

import java.util.*;

public class ShortestPathInDAG {
    public static void main(String[] args) {
        /*

            nodes=6
            pathsLen = 7

            from, to, dist
            0 1 2
            0 4 1
            4 5 4
            4 2 2
            1 2 3
            2 3 6
            5 3 1
        */
    }

    public int[] shortestPath(int V, int E, int[][] edges) {

        List<List<List<Integer>>> graph = createDirectedGraph(V, edges);
//        System.out.println(graph);

        int[] visited = new int[V];
        Arrays.fill(visited, -1);

        Comparator<int[]> compareDistanceToNode = (c1, c2) -> (c1[0] - c2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>(compareDistanceToNode);
        q.add(new int[]{0, 0});
        visited[0] = 0;

        while (!q.isEmpty()) {
            int[] top = q.remove();
            int topDist = top[0];
            int topNode = top[1];

            List<List<Integer>> neighbours = graph.get(topNode);
            for (List<Integer> neighbour : neighbours) {
                int neighDist = neighbour.get(1);
                int neighNode = neighbour.get(0);

                if (visited[neighNode] == -1 || visited[neighNode] > topDist + neighDist) {
                    visited[neighNode] = topDist + neighDist;
                    q.add(new int[]{neighDist + topDist, neighNode});
                }
            }
        }

        return visited;

    }

    public List<List<List<Integer>>> createDirectedGraph(int V, int[][] edges) {

        List<List<List<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            List<Integer> neighbour = new ArrayList<>();
            int from = edge[0];
            int to = edge[1];
            int dist = edge[2];
            neighbour.add(to);
            neighbour.add(dist);
            graph.get(from).add(neighbour);
        }

        return graph;
    }
}
