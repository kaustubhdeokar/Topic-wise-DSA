package graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathWeighted {

    public static void main(String[] args) {
        ShortestPathWeighted d = new ShortestPathWeighted();
        ArrayList<ArrayList<iPair>> graph = d.createData();
        int src = 1;
        int destination = 5;
        ArrayList<Integer> shortestDistancesFromSrc = d.dijkstraWithShortestPath(graph, src, destination);
        shortestDistancesFromSrc.add(0, src);
        System.out.println("path travelled from src to destination" + shortestDistancesFromSrc);
    }

    ArrayList<Integer> dijkstraWithShortestPath(ArrayList<ArrayList<iPair>> adj, int src, int destination) {
        int nodes = adj.size();
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            dist.add(Integer.MAX_VALUE);
        }
        int[] parent = new int[nodes];
        Arrays.fill(parent, -1);

        ArrayList<Integer> pathTravelled = new ArrayList<>();


        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new iPair(src, 0));
        dist.set(src, 0);

        while (!pq.isEmpty()) {
            iPair top = pq.poll();
            int currNode = top.first;
            int currDist = top.second;
            for (iPair neighAndDist : adj.get(currNode)) {
                int neigh = neighAndDist.first;
                int neighDist = neighAndDist.second;

                if (dist.get(neigh) > currDist + neighDist) {
                    pq.add(new iPair(neigh, currDist + neighDist));
                    dist.set(neigh, currDist + neighDist);
                    parent[neigh] = currNode;
                    System.out.println("neigh:" + neigh + " dist:" + currDist + " neigh :" + neighDist);
                }

            }
        }

        System.out.println("traversal----");
        int traversal = destination;
        while (traversal != src) {
            pathTravelled.add(0, traversal);
            traversal = parent[traversal];
        }
        System.out.println("traversal----");
        for (int i = 0; i < parent.length; i++) {
            System.out.println(i + ":" + parent[i]);
        }

        return pathTravelled;
    }

    class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private ArrayList<ArrayList<iPair>> createData() {
        int[][][] graph = new int[][][]{
                {{}},
                {{2, 2}, {4, 1}},
                {{1, 2}, {5, 5}, {3, 4}},
                {{2, 4}, {5, 1}, {4, 3}},
                {{1, 1}, {3, 3}},
                {{2, 5}, {3, 1}}
        };

        ArrayList<ArrayList<iPair>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }
        int ptr = 0;
        for (int[][] g : graph) {
            for (int[] neighDist : g) {
                if (neighDist.length == 2) {
                    list.get(ptr).add(new iPair(neighDist[0], neighDist[1]));
                }
            }
            ptr += 1;
        }
        return list;
    }

}
