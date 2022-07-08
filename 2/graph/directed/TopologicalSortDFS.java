package graph.directed;

import graph.Graph;

import java.util.ArrayList;

public class TopologicalSortDFS {

    public static void main(String[] args) {

        int[][] arr = {{2, 3}, {3, 4}, {3}, {}, {}};
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.createGraph(arr);
        int[] topoSortOrder = topoSort(arr.length, graph);

        for (int o : topoSortOrder) {
            System.out.print(o + " ");
        }
    }

    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph) {

        int[] res = new int[V];
        int[] visited = new int[V];
        int[] resCount = {0};
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(graph, visited, i, res, resCount);
            }
        }
        int len = res.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = res[i];
            res[i] = res[len - i - 1];
            res[len - i - 1] = temp;
        }
        return res;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int curr, int[] res, int[] resCount) {

        visited[curr] = 1;

        ArrayList<Integer> neigh = graph.get(curr);

        for (Integer n : neigh) {
            if (visited[n] == 0) {
                dfs(graph, visited, n, res, resCount);
            }

        }
        res[resCount[0]] = curr;
        resCount[0]++;
    }

}
