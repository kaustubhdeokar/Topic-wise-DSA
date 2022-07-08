package graph.directed;

import graph.Graph;

import java.util.*;

public class TopologicalSortBFS {

    public static void main(String[] args) {
        int[][] arr = {{2, 3}, {3, 4}, {3}, {}, {}};
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.createGraph(arr);
        int[] topoSortOrder = topoSort(5, graph);

        for (int o : topoSortOrder) {
            System.out.print(o + " ");
        }
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        Map<Integer, Integer> mapNodeToDegree = new HashMap<>();
        int[] res = new int[V];
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> innerList = adj.get(i);

            for (int j = 0; j < innerList.size(); j++) {
                int key = innerList.get(j);
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

    private static void printOrder(ArrayDeque<Integer> queue, ArrayList<ArrayList<Integer>> graph,
                                   Map<Integer, Integer> mapNodeToDegree, int[] res) {
        int itr = 0;
        while (!queue.isEmpty()) {
            int top = queue.remove();
            res[itr++] = top;

            ArrayList<Integer> neighbours = graph.get(top);
            for (int adj : neighbours) {
                //noinspection ConstantConditions
                mapNodeToDegree.put(adj, mapNodeToDegree.get(adj) - 1);
                Integer value = mapNodeToDegree.get(adj);
                if (value.equals(0))
                    queue.add(adj);
            }
        }

    }



}
