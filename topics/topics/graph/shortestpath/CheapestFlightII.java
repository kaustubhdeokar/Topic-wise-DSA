package graph.shortestpath;

import graph.Graph;

import java.util.*;

public class CheapestFlightII {

    public static void main(String[] args) {

        CheapestFlightII cheapestFlightII = new CheapestFlightII();
        int n = 5;
        int[][] flights = new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int src = 0, dst = 2, k = 2;

        int cheapestPrice = cheapestFlightII.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cheapestPrice);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>(n);
        Graph g = new Graph();
        g.createWeightedGraph(graph, flights, n);

        int[] cheapestPrice = new int[n];
        Arrays.fill(cheapestPrice, Integer.MAX_VALUE);
        cheapestPrice[src] = 0;

        int[] stopsToNode = new int[n];
        Arrays.fill(stopsToNode, Integer.MAX_VALUE);
        stopsToNode[src] = 0;

        bfs(graph, cheapestPrice, stopsToNode, src, k);

        if (cheapestPrice[dst] == Integer.MAX_VALUE) return -1;
        return cheapestPrice[dst];
    }

    private void bfs(ArrayList<ArrayList<int[]>> graph, int[] cheapestPrice, int[] stopsToNode,
                     int src, int stopsAllowed) {

        Comparator<int[]> nodePriceStops = (c1, c2) -> Integer.compare(c1[1], c2[1]);
        Queue<int[]> q = new PriorityQueue<>(nodePriceStops);
        q.add(new int[]{src, 0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int currNode = curr[0];
            int currStops = curr[2];
            int currPrice = curr[1];

            System.out.println(currNode + ":" + currStops + ":" + currPrice);

            if (currStops > stopsAllowed) continue;

            for (int[] neighbours : graph.get(currNode)) {
                int neighbourNode = neighbours[0];
                int neighbourPrice = neighbours[1];
                int newPrice = currPrice + neighbourPrice;
                if (cheapestPrice[neighbourNode] > newPrice)
                //((currStops + 1)<=stopsAllowed)
                // or
                {
                    cheapestPrice[neighbourNode] = newPrice;
                    stopsToNode[neighbourNode] = currStops + 1;
                    q.add(new int[]{neighbourNode, newPrice, currStops + 1});
                }
                else if((currStops + 1 )< stopsToNode[neighbourNode]){
                    q.add(new int[]{neighbourNode, newPrice, currStops+1});
                }
            }
        }
    }


}
