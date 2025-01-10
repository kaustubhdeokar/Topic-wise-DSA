package graph.shortestpath;

//https://takeuforward.org/data-structure/g-35-print-shortest-path-dijkstras-algorithm/

import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrintShortestPath {
    public static void main(String[] args) {

        int nodes = 6;
        int[][] edges = new int[][]{
                {1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        Graph g = new Graph();

        PrintShortestPath shortestPath = new PrintShortestPath();
        ArrayList<ArrayList<int[]>> graph = shortestPath.createGraph(edges, nodes);
        int src = 1;
        int dest = nodes - 1;

        shortestPath.calculateShortestPath(graph, src, dest, nodes);

    }

    private ArrayList<ArrayList<int[]>> createGraph(int[][] edges, int nodes) {
        //<<[1,1],[2,2]>  <[0,2],[2,3]> <[0,3],[1,3]>>

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new int[]{to, weight});
        }
        return graph;
    }

    private void calculateShortestPath(ArrayList<ArrayList<int[]>> graph, int src, int dest, int nodes) {

        int[] shortestPath = new int[nodes];
        int[] incomingNode = new int[nodes];
        incomingNode[src] = -1;
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[src] = 0;
        Comparator<int[]> nodeDist = (c1, c2) -> Integer.compare(c1[1], c2[1]);
        PriorityQueue<int[]> q = new PriorityQueue<>(nodeDist);
        q.add(new int[]{src, 0});

        while (!q.isEmpty()) {
            int[] top = q.remove();
            int currNode = top[0];
            int currDist = top[1];

            for (int[] neigh : graph.get(currNode)) {
                int to = neigh[0];
                int dist = neigh[1];
                if (shortestPath[to] > currDist + dist) {
                    shortestPath[to] = currDist + dist;
                    incomingNode[to] = currNode;
                    q.add(new int[]{to, dist});
                }
            }
        }

        System.out.println("shortest path to nodes:");
        for (int s : shortestPath) {
            System.out.print(s + " ");
        }
        System.out.println("\npath:");
        int node = dest;
        while (node != -1) {
            System.out.print(node + " ");
            node = incomingNode[node];
        }

    }


}
