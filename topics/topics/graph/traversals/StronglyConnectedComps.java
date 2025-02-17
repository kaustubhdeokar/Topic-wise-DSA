package graph.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class StronglyConnectedComps {
    // two vertices are strongly connected, if there is a path/edge from a to b and there is a path/edge from b to a.
    // Kosaraju's algorithm
    // traverse dfs -> add nodes finishing their traversal to the stack.
    // reverse the edges
    // traverse dfs from the nodes in the stack, those having strongly connected components will be a part of the same traversal.

    // why does this work ? -> because that's the point of SCC -> a to b, and b to a both is possible.

    public static void main(String[] args) {
        int[][] edges = {{0, 2}, {2, 1}, {1, 0}, {0, 3}, {3, 4}};
        int nodes = 5;
        StronglyConnectedComps stronglyConnectedComps = new StronglyConnectedComps();
        List<List<Integer>> graph = stronglyConnectedComps.createGraph(edges, nodes);


        Stack<Integer> nodeStack = stronglyConnectedComps.addNodesToStackUsingDfs(nodes, graph);
        List<List<Integer>> reverseGraph = stronglyConnectedComps.reverseGraph(edges, nodes);
        stronglyConnectedComps.findSCC(reverseGraph, nodeStack, nodes);


    }

    private void findSCC(List<List<Integer>> reverseGraph, Stack<Integer> nodeStack, int nodes) {
        boolean[] visited = new boolean[nodes];
        int component = 0;
        while (!nodeStack.isEmpty()) {
            Integer top = nodeStack.pop();
            if (!visited[top]) {
                List<Integer> nodesInCurrentComponent = new ArrayList<>();
                findSCC(reverseGraph, top, visited, nodesInCurrentComponent);
                System.out.println("Component:" + component + " nodes:" + nodesInCurrentComponent);
                component += 1;
            }
        }
    }

    private void findSCC(List<List<Integer>> graph, int curr, boolean[] visited, List<Integer> nodesInCurrComponent) {

        visited[curr] = true;
        nodesInCurrComponent.add(curr);

        for (int neigh : graph.get(curr)) {
            if (!visited[neigh]) {
                findSCC(graph, neigh, visited, nodesInCurrComponent);
            }
        }

    }

    private List<List<Integer>> reverseGraph(int[][] edges, int nodes) {
        List<List<Integer>> list = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[1]).add(edge[0]);
        }
        return list;
    }

    private Stack<Integer> addNodesToStackUsingDfs(int nodes, List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                traverse(graph, stack, visited, i);
            }
        }
        return stack;
    }

    public void traverse(List<List<Integer>> graph, Stack<Integer> stack, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int neigh : graph.get(curr)) {
            if (!visited[neigh]) {
                traverse(graph, stack, visited, neigh);
            }
        }
        stack.add(curr);
    }

    public List<List<Integer>> createGraph(int[][] edges, int nodes) {
        List<List<Integer>> list = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
        }
        return list;
    }

}
