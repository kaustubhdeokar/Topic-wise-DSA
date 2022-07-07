package graph.undirected;

import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestPathFromSource {

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {0, 2, 3}, {0, 1, 3}, {1, 2}};
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.createGraph(arr);
        shortestDistance(graph);

    }

    private static void shortestDistance(ArrayList<ArrayList<Integer>> graph) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] visited = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i] == 0) {
                dist[i] = 0;
                visited[i] = 1;
                traverse(graph, visited, i, dist);
            }
        }
        System.out.println("Distance from 0:");
        for (int i : dist) {
            System.out.print(i + " ");
        }
    }

    private static void traverse(ArrayList<ArrayList<Integer>> graph, int[] visited, int vertex, int[] dist) {

        visited[vertex] = 1;
        ArrayList<Integer> adjacent = graph.get(vertex);

        for (int adj : adjacent) {
            if (visited[adj] == 0) {
                dist[adj] = dist[vertex] + 1;
                traverse(graph, visited, adj, dist);
            } else {
                dist[adj] = Integer.min(dist[adj], dist[vertex] + 1);
            }
        }
    }

}
