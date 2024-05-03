package graph.rev;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph) {

        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, graph, visited, stack);
            }
        }

        ArrayList<ArrayList<Integer>> reverseGraph = createInvertedGraph(graph, V);

        return findStrongComponents(V, stack, reverseGraph);

    }

    private int findStrongComponents(int V, Stack<Integer> stack, ArrayList<ArrayList<Integer>> reverseGraph) {
        int[] visited;
        visited = new int[V];
        int components = 0;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (visited[top] == 0) {
                components += 1;
                dfs(top, reverseGraph, visited);
            }
        }
        return components;
    }

    private ArrayList<ArrayList<Integer>> createInvertedGraph(ArrayList<ArrayList<Integer>> graph, int V) {

        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int adj : graph.get(i)) {
                reverseGraph.get(adj).add(i);
            }
        }
        return reverseGraph;
    }

    public void dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        visited[curr] = 1;
        for (int adj : graph.get(curr)) {
            if (visited[adj] == 0) {
                dfs(adj, graph, visited);
            }
        }
    }

    public void dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited, Stack<Integer> stack) {
        dfs(curr, graph, visited);
        stack.add(curr);
    }
}
