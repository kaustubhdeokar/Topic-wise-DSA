import java.util.*;

/*
 
 for kahn's algorithm, 
we put a node in a queue if the indegree = 0 


if a cycle is present, it's indegree will never be 0, 
as we would never be able to process nodes being a part of cycle.


 */

public class TopologicalSortBFS {

    public static void main(String[] args) {
        int[][] arr = { { 2, 3 }, { 3, 4 }, { 3 }, {}, {} };
        int[] topoSortOrder = topoSort(5, arr);

        for (int o : topoSortOrder) {
            System.out.print(o + " ");
        }
    }

    static int[] topoSort(int V, int[][] adj) {

        Map<Integer, Integer> mapNodeToDegree = new HashMap<>();
        int[] res = new int[V];
        for (int i = 0; i < V; i++) {

            for (int key : adj[i]) {
                if (!mapNodeToDegree.containsKey(key)) {
                    mapNodeToDegree.put(key, 1);
                } else {
                    mapNodeToDegree.put(key, mapNodeToDegree.get(key) + 1);
                }
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!mapNodeToDegree.containsKey(i)) {
                mapNodeToDegree.put(i, 0);
                queue.add(i);
            }
        }

        printOrder(queue, adj, mapNodeToDegree, res);

        return res;

    }

    private static void printOrder(ArrayDeque<Integer> queue, int[][] graph,
            Map<Integer, Integer> mapNodeToDegree, int[] res) {
        int itr = 0;
        while (!queue.isEmpty()) {
            int top = queue.remove();
            res[itr++] = top;

            for (int adj : graph[top]) {
                // noinspection ConstantConditions
                mapNodeToDegree.put(adj, mapNodeToDegree.get(adj) - 1);
                Integer value = mapNodeToDegree.get(adj);
                if (value.equals(0))
                    queue.add(adj);
            }
        }

    }

}
