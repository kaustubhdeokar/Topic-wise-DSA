package trees.tree;

import java.util.*;

public class ForestValidChildren {

    public void validChildren(List<List<Integer>> forest, int src, int parent, int k, long[] sum, int[] components, int[] values) {

        sum[src] = values[src];

        for (int neigh : forest.get(src)) {
            if (parent != neigh) {
                validChildren(forest, neigh, src, k, sum, components, values);
                sum[src] += sum[neigh];
            }
        }

        if (sum[src] % k == 0) {
            components[0] += 1;
            sum[src] = 0;
        }
    }

    private List<List<Integer>> createForest(int n, int[][] edges) {
        List<List<Integer>> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            nodeList.get(to).add(from);
            nodeList.get(from).add(to);
        }
        return nodeList;
    }

    public static void main(String[] args) {

        // 1,2 0,3,4  0,5,6
        //  0    1      2

        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values = {1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000};
        int k = 7;
        int n = 7;
        ForestValidChildren forestTraversals = new ForestValidChildren();
        List<List<Integer>> forest = forestTraversals.createForest(n, edges);
        int[] components = {0};

        if(k==1 || k ==0) System.out.println("components:"+n);
        long[] sum = new long[n];

        forestTraversals.validChildren(forest, 0, -1, k, sum, components, values);
        if(components[0]==0) components[0]+=1;

        System.out.println("components:" + components[0]);
    }


}
