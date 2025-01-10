package graph.problems;

import java.util.ArrayDeque;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces += 1;
                traverse(i, isConnected, visited);
            }
        }
        return provinces;
    }

    public void traverse(int curr, int[][] isConnected, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(curr);
        visited[curr] = true;

        while (!q.isEmpty()) {
            int current = q.pop();
            int[] neighbours = isConnected[current];
            for (int i = 0; i < neighbours.length; i++) {
                if (!visited[i] && neighbours[i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
