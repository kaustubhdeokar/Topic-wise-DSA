package graph.problems;

import graph.Graph;

import java.util.ArrayList;

public class TransitiveClosure {

    public static void main(String[] args) {

        Graph graph = new Graph();
        ArrayList<ArrayList<Integer>> list = graph.transitiveClosureGraph();

        int[][] result = new int[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            boolean[] visited = new boolean[list.size()];
            dfs(list, i, result[i], visited);

            for (boolean v : visited) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, int curr, int[] result, boolean[] visited) {
        visited[curr] = true;
        for (int neigh : list.get(curr)) {
            if (!visited[neigh]) {
                visited[neigh] = true;
                result[neigh] = 1;
                dfs(list, neigh, result, visited);
            }
        }
    }


}
