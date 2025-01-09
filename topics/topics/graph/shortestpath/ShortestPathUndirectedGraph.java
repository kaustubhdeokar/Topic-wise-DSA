package graph.shortestpath;

import graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathUndirectedGraph {

    public static void main(String[] args) {

        int[][] graph = new int[][]{{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
        Graph graph1 = new Graph();
        int nodes = 9;
        ArrayList<ArrayList<Integer>> graphList = graph1.createGraph(graph, nodes, true);
        ShortestPathUndirectedGraph shortestPath = new ShortestPathUndirectedGraph();
        int[] distance = new int[nodes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int src = 0;
        distance[src] = 0;
        int[] res = shortestPath.calculate(graphList, nodes, src, distance);
        for (int r : res) {
            System.out.print(r + " ");
        }

    }

    private int[] calculate(ArrayList<ArrayList<Integer>> graph, int nodes, int src, int[] distance) {
        boolean[] visited = new boolean[nodes];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{src, 0});
        visited[src] = true;

        while (!q.isEmpty()) {
            int[] top = q.remove();
            int node = top[0];
            int dist = top[1];

            for (int neigh : graph.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(new int[]{neigh, dist + 1});
                    distance[neigh] = Integer.min(distance[neigh], dist + 1);
                }
            }
        }
        return distance;
    }


}
