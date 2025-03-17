package graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class WaysToArriveAtDest {

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<int[]>> graph = createGraph(roads, n);
        long[] distToNode = new long[n];
        Arrays.fill(distToNode, Long.MAX_VALUE/2);
        distToNode[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;
        return findPath(graph, 0, n, distToNode, ways);

    }
    private int findPath(ArrayList<ArrayList<int[]>> graph, int src, int dest, long[] distToNode, int[] ways) {

        int mod = 1000000007;
        Comparator<long[]> comp = (c1, c2) -> Long.compare(c1[1], c2[1]);
        PriorityQueue<long[]> pq = new PriorityQueue<>(comp);
        pq.add(new long[]{src, 0});

        while(!pq.isEmpty()){

            long[] top = pq.remove();
            int currNode = (int)top[0];
            long currDist = top[1];

            for(int[] neighbour: graph.get(currNode)){
                int node = neighbour[0];
                long dist = neighbour[1];

                if(distToNode[node] > (currDist + dist)){
                    distToNode[node] = currDist + dist;
                    ways[node] = ways[currNode]%mod;
                    pq.add(new long[]{node, currDist+dist});
                }
                else if(distToNode[node]==(currDist+dist)){
                    ways[node] = (ways[node]%mod + ways[currNode]%mod)%mod;
                }
            }
        }

        return (ways[dest-1])%mod;
    }

    private ArrayList<ArrayList<int[]>> createGraph(int[][] graph, int nodes)
    {
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] vertex : graph) {
            int to = vertex[0];
            int from = vertex[1];
            int dist = vertex[2];
            list.get(from).add(new int[]{to, dist});
            list.get(to).add(new int[]{from, dist});
        }
        return list;
    }
}
