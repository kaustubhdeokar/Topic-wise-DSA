package graph.shortestpath;


import java.util.*;

public class Djikstras {
    public static void main(String[] args) {
        Djikstras d = new Djikstras();
        ArrayList<ArrayList<int[]>> graph = d.createData();
        ArrayList<Integer> shortestDistancesFromSrc = d.dijkstra(graph, 2);
        System.out.println(shortestDistancesFromSrc);
    }

    private ArrayList<ArrayList<int[]>> createData() {
        int[][][] graph = new int[][][]{
                {{1, 1}, {2, 6}},
                {{2, 3}, {0, 1}},
                {{1, 3}, {0, 6}}
        };
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }
        int ptr = 0;
        for (int[][] g : graph) {
            for (int[] neighDist : g) {
                list.get(ptr).add(new int[]{neighDist[0], neighDist[1]});
            }
            ptr += 1;
        }
        return list;
    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<int[]>> adj, int src) {

        int nodes = adj.size();
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{src, 0});
        dist.set(src, 0);

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currNode = top[0];//2
            int currDist = top[1];//-
            for (int[] neighAndDist : adj.get(currNode)) {
                int neigh = neighAndDist[0];
                int neighDist = neighAndDist[1];
                if (dist.get(neigh) > currDist + neighDist) {
                    pq.add(new int[]{neigh, currDist + neighDist});
                    dist.set(neigh, currDist + neighDist);
                    System.out.println("neigh:" + neigh + " dist:" + currDist + " neigh :" + neighDist);
                }
            }
        }

        return dist;
    }


}
