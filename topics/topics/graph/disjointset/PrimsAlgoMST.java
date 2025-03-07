package graph.disjointset;

import graph.Graph;

import java.util.*;

// to find the minimum spanning tree - from current available edge which is not visited,
// we take the lowest valued edge and mark the node as visited.

public class PrimsAlgoMST {
    public static void main(String[] args) {

        int[][] edges = {{0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}};
        Graph g = new Graph();
        int nodes = 3;
        int vertex = 3;
        List<List<int[]>> graph = g.createWeightedGraph(edges, 3);
        PrimsAlgoMST prims = new PrimsAlgoMST();
        prims.spanningTree(vertex, nodes, graph);
    }

    public int spanningTree(int V, int E, List<List<int[]>> adj) {

        boolean[] visited = new boolean[V];
        int mstSum = 0;
        int src = 0;

        Comparator<int[]> distanceComp = (c1, c2) -> Integer.compare(c1[0], c2[0]);
        Queue<int[]> pq = new PriorityQueue<>(distanceComp);
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int topNode = top[1];
            int topDist = top[0];
            //System.out.println("topNode:"+topNode);

            if (visited[topNode]) {
                //System.out.println("returning:"+topNode);
                continue;
            }

            visited[topNode] = true;

            for (int[] neighbour : adj.get(topNode)) {
                int neighNode = neighbour[0];
                int neighDist = neighbour[1];

                if (!visited[neighNode])
                    pq.add(new int[]{neighDist, neighNode});
            }

            mstSum += topDist;

        }

        return mstSum;
    }

}
