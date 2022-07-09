package graph.directed;

import java.util.Arrays;

//https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinimumSpanningTree {

    public static void main(String[] args) {

        MinimumSpanningTree minimumSpanningTree = new MinimumSpanningTree();
        int[][] points = {{3, 12}, {-2, 5}, {-4, 1}};

        System.out.println("Min cost to travel all points:" + minimumSpanningTree.minCostConnectPoints(points));

    }

    public int minCostConnectPoints(int[][] points) {

        int pointsLen = points.length;
        int[] visited = new int[pointsLen];
        int[] dist = new int[pointsLen];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int pointsVisited = 0;
        int totalMinDist = 0;

        while (pointsVisited < pointsLen) {

            int minDist = Integer.MAX_VALUE;
            int minDistPoint = -1;

            for (int i = 0; i < pointsLen; i++) {
                if (visited[i] == 0) {
                    if (dist[i] < minDist) {
                        minDist = dist[i];
                        minDistPoint = i;
                    }
                }
            }

            visited[minDistPoint] = 1;
            totalMinDist += minDist;
            pointsVisited += 1;

            for (int i = 0; i < pointsLen; i++) {

                if (visited[i] == 0) {
                    dist[i] = Integer.min(dist[i], Math.abs(points[i][0] - points[minDistPoint][0]) +
                            Math.abs(points[i][1] - points[minDistPoint][1]));
                }
            }

        }

        return totalMinDist;
    }

}
