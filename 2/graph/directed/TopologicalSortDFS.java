package graph.directed;

import graph.Graph;
import graph.Pair;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

    public static void main(String[] args) {

        TopologicalSortDFS topoSort = new TopologicalSortDFS();

        int[][] arr = {{1, 4}, {2}, {3}, {}, {2, 5}, {3}};
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.createGraph(arr);
        Stack<Integer> stack = topoSort.topoSort(arr.length, graph);
        System.out.println("in reverse order.");
        for (int o : stack) {
            System.out.print(o + " ");
        }
    }

    public Stack<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> graph) {

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(graph, visited, i, stack);
            }
        }

        return stack;
    }



    public void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int curr, Stack<Integer> stack) {

        visited[curr] = 1;

        ArrayList<Integer> neigh = graph.get(curr);

        for (Integer n : neigh) {
            if (visited[n] == 0) {
                dfs(graph, visited, n, stack);
            }

        }
        stack.push(curr);
    }



}
