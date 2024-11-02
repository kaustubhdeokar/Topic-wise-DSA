package graph;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class Djikstras {
    public static void main(String[] args) {
        Djikstras d = new Djikstras();
        ArrayList<ArrayList<iPair>> graph = d.createData();
        ArrayList<Integer> shortestDistancesFromSrc = d.dijkstra(graph, 2);
        System.out.println(shortestDistancesFromSrc);
    }

    private ArrayList<ArrayList<iPair>> createData() {
        int[][][] graph = new int[][][]{
                {{1, 1}, {2, 6}},
                {{2, 3}, {0, 1}},
                {{1, 3}, {0, 6}}
        };
        ArrayList<ArrayList<iPair>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }
        int ptr = 0;
        for (int[][] g : graph) {
            for (int[] neighDist : g) {
                list.get(ptr).add(new iPair(neighDist[0], neighDist[1]));
            }
            ptr += 1;
        }
        return list;
    }

    class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int nodes = adj.size();
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new iPair(src, 0));
        dist.set(src, 0);

        while (!pq.isEmpty()) {
            iPair top = pq.poll();
            int currNode = top.first;//2
            int currDist = top.second;//-
            for (iPair neighAndDist : adj.get(currNode)) {
                //0 6, 1 3
                int neigh = neighAndDist.first;
                int neighDist = neighAndDist.second;
                if (dist.get(neigh) > currDist + neighDist) {
                    pq.add(new iPair(neigh, currDist + neighDist));
                    dist.set(neigh, currDist + neighDist);
                    System.out.println("neigh:" + neigh + " dist:" + currDist + " neigh :" + neighDist);
                }
            }
        }

        return dist;
    }


}
