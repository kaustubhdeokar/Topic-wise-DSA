package graph;

import java.util.ArrayList;

public class Cycle {

    public void dfs(ArrayList<ArrayList<Integer>> list, int nodes) {
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                System.out.println("traversing:" + i);
                boolean[] recStack = new boolean[nodes];
                System.out.println("cycle exists:" + dfs(list, i, visited, recStack));
            }
        }
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> list, int curr, boolean[] visited, boolean[] recstack) {


        visited[curr] = true;
        recstack[curr] = true;
        System.out.println(curr);

        for (int neigh : list.get(curr)) {
            System.out.println("neigh: " + neigh + " curr:" + curr);

            if (!visited[neigh]) {
                visited[neigh] = true;
                if (dfs(list, neigh, visited, recstack)) {
                    return true;
                }
            }
            if (recstack[neigh]) {
                return true;
            }
        }

        recstack[curr] = false;
        return false;
    }

    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> directedGraph = g.sampleDirectedGraph();
        Cycle cycle = new Cycle();
        cycle.dfs(directedGraph, 4);
    }
}
