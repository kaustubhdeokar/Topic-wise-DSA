package graph.directed;

import graph.Graph;
import graph.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPath {

    public static void main(String[] args) {


        int[][] arr = {{0, 1, 2}, {0, 4, 1}, {1, 2, 3}, {4, 2, 2}, {2, 3, 6}, {4, 5, 4}, {5, 3, 1}};
        int vertices = 6;
        Graph g = new Graph();
        ArrayList<ArrayList<Pair>> graph = g.createGraphWithWeights(arr, vertices);

        ShortestPath shortestPath = new ShortestPath();
        Stack<Integer> stack = shortestPath.topoSort(vertices, graph);


        int[] shortestDist = new int[vertices];
        Arrays.fill(shortestDist, Integer.MAX_VALUE);

        calculateShortestDistance(stack, shortestDist, graph);

        System.out.println("shortest distance to all vertices from source");
        for (int i : shortestDist) {
            System.out.print(i + " ");
        }
    }

    private static void calculateShortestDistance(Stack<Integer> stack, int[] shortestDist, ArrayList<ArrayList<Pair>> graph) {

        int source = stack.peek();
        shortestDist[source] = 0;

        while (!stack.isEmpty()) {
            int top = stack.pop();
            ArrayList<Pair> neighbours = graph.get(top);
            for (Pair n : neighbours) {
                shortestDist[n.v] = Integer.min(shortestDist[n.v], shortestDist[top] + n.weight);
            }
        }

    }

    public void dfs(ArrayList<ArrayList<Pair>> graph, int[] visited, int curr, Stack<Integer> stack) {

        visited[curr] = 1;
        ArrayList<Pair> pairs = graph.get(curr);

        for (Pair n : pairs) {
            if (visited[n.v] == 0) {
                dfs(graph, visited, n.v, stack);
            }
        }
        stack.push(curr);
    }

    public Stack<Integer> topoSort(int vertices, ArrayList<ArrayList<Pair>> graph) {

        int[] visited = new int[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == 0) {
                dfs(graph, visited, i, stack);
            }
        }
        return stack;
    }

}
