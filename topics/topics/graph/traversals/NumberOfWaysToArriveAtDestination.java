package graph.traversals;

import graph.Graph;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {

    public static void main(String[] args) {

        int n = 7, m = 10;
        NumberOfWaysToArriveAtDestination numWays = new NumberOfWaysToArriveAtDestination();
        ArrayList<ArrayList<int[]>> graph = numWays.getGraph(n);
        int[] ways = new int[n];
        int[] minTime = new int[n];

        Arrays.fill(minTime, Integer.MAX_VALUE);
        int src = 0;
        ways[src] = 1;
        minTime[src] = 0;
        numWays.bfs(graph, src, ways, minTime);


    }

    private void bfs(ArrayList<ArrayList<int[]>> graph, int src, int[] ways, int[] minTime) {

        Comparator<int[]> distToNode = (c1, c2) -> Integer.compare(c1[0], c2[0]);
        Queue<int[]> q = new PriorityQueue<>(distToNode);
        q.add(new int[]{0, src});


        while (!q.isEmpty()) {
            int[] node = q.remove();
            int currTime = node[0];
            int currNode = node[1];

            for (int[] neighbour : graph.get(currNode)) {
                int neighNode = neighbour[0];
                int neighTime = neighbour[1];

                int newTime = currTime + neighTime;

                if (minTime[neighNode] > newTime) {
                    q.add(new int[]{newTime, neighNode});
                    minTime[neighNode] = newTime;
                    ways[neighNode] = ways[currNode];
                }
                else if(minTime[neighNode] == newTime){
                    ways[neighNode] = (ways[neighNode] + ways[currNode]);
                }

            }

        }

        for (int i = 0; i < 7; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nminTime");
        for (int m : minTime) {
            System.out.print(m + " ");
        }
        System.out.println("\nways");
        for (int w : ways) {
            System.out.print(w + " ");
        }

    }

    private ArrayList<ArrayList<int[]>> getGraph(int n) {
        int[][] edges = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        Graph g = new Graph();
        g.createWeightedGraph(graph, edges, n);
        return graph;
    }

}
