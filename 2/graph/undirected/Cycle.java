package graph.undirected;

import graph.Graph;

import java.util.ArrayList;

public class Cycle {

    public static void main(String[] args) {

        int[][] arr = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.createGraph(arr);
        System.out.println("Has cycle :" + detectCycle(graph));
    }

    private static boolean detectCycle(ArrayList<ArrayList<Integer>> graph) {
        int[] visited = new int[graph.size()];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                if (traverse(graph, visited, i, -1))
                    return true;
            }
        }
        return false;
    }

    private static boolean traverse(ArrayList<ArrayList<Integer>> graph, int[] visited, int vertex, int parent) {

        ArrayList<Integer> adjacent = graph.get(vertex);
        visited[vertex] = 1;
        for (int i : adjacent) {
            if (visited[i] == 0)
                if (traverse(graph, visited, i, vertex))
                    return true;
            if (i != parent)
                return true;
        }
        return false;
    }

}
