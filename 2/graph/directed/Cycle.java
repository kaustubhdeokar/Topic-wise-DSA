package graph.directed;

import graph.Graph;

import java.util.ArrayList;

public class Cycle {

    public static void main(String[] args) {

        int[][] arr = {{1}, {0, 3}, {0}, {1}};
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.createGraph(arr);
        System.out.println("Has cycle :" + detectCycle(graph));
    }

    private static boolean detectCycle(ArrayList<ArrayList<Integer>> graph) {
        int[] visited = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i] == 0) {
                int[] recStack = new int[graph.size()];
                if (traverse(graph, visited, recStack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean traverse(ArrayList<ArrayList<Integer>> list, int[] visited, int[] recStack, int vertex) {

        visited[vertex] = 1;
        recStack[vertex] = 1;

        for (int adj : list.get(vertex)) {

            if (visited[adj] == 0) {
                if (traverse(list, visited, recStack, adj))
                    return true;
            } else if (recStack[adj] == 1) {
                return true;
            }
        }
        recStack[vertex] = 0;
        return false;
    }
}
