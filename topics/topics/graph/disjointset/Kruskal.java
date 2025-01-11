package graph.disjointset;

import java.util.ArrayList;
import java.util.Comparator;
//https://leetcode.com/problems/min-cost-to-connect-all-points/
class Kruskal {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        //n = 3, i=0. i=1
        /*
         0 0   2 2   3 10
         0 0         y     y
         2 2               y
         3 10
         */
        ArrayList<int[]> list = new ArrayList<>();
        Comparator<int[]> distanceComparator = (c1, c2) -> c1[0] - c2[0];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                int p1x = points[i][0];
                int p1y = points[i][1];
                int p2x = points[j][0];
                int p2y = points[j][1];
                int diff = Math.abs(p1x - p2x) + Math.abs(p1y - p2y);
                list.add(new int[]{diff, i, j});
            }
        }
        list.sort(distanceComparator);

        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int[] rank = new int[n];
        return constructMST(list, parents, rank);

    }

    public int constructMST(ArrayList<int[]> list, int[] parents, int[] rank) {
        int totalCost = 0;
        for (int[] arr : list) {
            int u = arr[1];
            int v = arr[2];
            if (findParent(parents, u) != findParent(parents, v)) {
                union(parents, rank, u, v);
                totalCost += arr[0];
            }
        }
        return totalCost;
    }

    public void union(int[] parent, int[] rank, int x, int y) {
        int xpar = findParent(parent, x);
        int ypar = findParent(parent, y);
        if (xpar == ypar) return;

        if (rank[xpar] > rank[ypar]) {
            parent[ypar] = xpar;
        } else if (rank[xpar] < rank[ypar]) {
            parent[xpar] = ypar;
        } else {
            parent[ypar] = xpar;
            rank[xpar] += 1;
        }
    }

    public int findParent(int[] parent, int node) {
        if (parent[node] == node) return node;
        int newParent = findParent(parent, parent[node]);
        parent[node] = newParent;
        return newParent;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        Kruskal kruskal = new Kruskal();
        int result = kruskal.minCostConnectPoints(points);
        System.out.println(result);
    }

}