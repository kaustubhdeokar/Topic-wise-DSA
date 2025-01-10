package graph.shortestpath;

import java.util.Arrays;

//single source algorithm.
//can detect negative edges.
public class BellmanFord {
    public static void main(String[] args) {

        int[][] graph = new int[][]{{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}};
        int nodes = 6;
        int src = 0;

        //should iterate edges - 1 times.
        int[] minDist = new int[nodes];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[src] = 0;

        for (int i = 0; i < nodes - 1; i++) {

            for (int[] edge : graph) {
                int from = edge[0];
                int to = edge[1];
                int dist = edge[2];

                if (minDist[from] != Integer.MAX_VALUE && minDist[to] > minDist[from] + dist) {
                    minDist[to] = minDist[from] + dist;
                }
            }

        }

        //relaxing for the nth time.

        for(int[] edge: graph){
            int from = edge[0];
            int to = edge[1];
            int dist = edge[2];
            if(minDist[from]!= Integer.MAX_VALUE && minDist[to] > minDist[from]+dist){
                //negative cycle found.
                System.out.println("negative cycle found.");
            }
        }

        //min dist is the answer we want.
    }
}
