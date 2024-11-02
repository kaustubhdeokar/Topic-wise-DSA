package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithinKStops {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //create a graph.
        ArrayList<ArrayList<NeighbourInfo>> graph = new ArrayList<>(n);
        createGraph(graph, flights);
        // maintain a price array
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        //dfs(graph, price, src, dst, k); - bloody fucker won't work.
        bfs(graph, price, src, k);

        if (price[dst] == Integer.MAX_VALUE) return -1;
        return price[dst];
    }


    private void bfs(ArrayList<ArrayList<NeighbourInfo>> graph, int[] price, int src, int stopsAllowed) {

        Queue<NodeInfo> q = new LinkedList<>();
        q.add(new NodeInfo(src, 0, 0));

        while (!q.isEmpty()) {
            NodeInfo top = q.remove();
            int currNode = top.node;
            int currStops = top.stop;
            int currPrice = top.price;

            if (currStops > stopsAllowed) continue;

            for (NeighbourInfo neighbourInfo : graph.get(currNode)) {
                int neighbourNode = neighbourInfo.neighbour;
                int neighbourPrice = neighbourInfo.price;

                if (price[neighbourNode] > (currPrice + neighbourPrice) && currStops <= stopsAllowed) {
                    price[neighbourNode] = currPrice + neighbourPrice;
                    q.add(new NodeInfo(neighbourNode, currPrice + neighbourPrice, currStops + 1));
                }

            }

        }


    }

    public void dfs(ArrayList<ArrayList<NodeInfo>> graph, int[] price, int src, int dst, int k) {
        if (k < 0) return; // answer needed in k stops.
        for (NodeInfo neighbour : graph.get(src)) {
            int neigh = neighbour.node;
            int currPrice = neighbour.price;

            if (price[neigh] > (price[src] + currPrice)) {
                price[neigh] = price[src] + currPrice;
                dfs(graph, price, neigh, dst, k - 1);
                if (neigh != dst)
                    price[neigh] = Integer.MAX_VALUE;
            }

        }
    }

    public void createGraph(ArrayList<ArrayList<NeighbourInfo>> graph,
                            int[][] flights) {
        for (int[] flight : flights) {
            while (graph.size() <= flight[0] || graph.size() <= flight[1]) {
                graph.add(new ArrayList<>());
            }
            graph.get(flight[0]).add(new NeighbourInfo(flight[1], flight[2]));
        }
    }

    class NeighbourInfo {
        int neighbour;
        int price;

        public NeighbourInfo(int neighbour, int price) {
            this.neighbour = neighbour;
            this.price = price;
        }
    }

    class NodeInfo {
        int node;
        int price;
        int stop;

        NodeInfo(int node, int price, int stop) {
            this.node = node;
            this.price = price;
            this.stop = stop;
        }
    }

}
