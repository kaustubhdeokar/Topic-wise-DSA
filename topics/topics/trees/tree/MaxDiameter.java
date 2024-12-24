package trees.tree;

import java.util.ArrayList;

public class MaxDiameter {
    public static void main(String[] args) {

        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}}; // n nodes
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}}; // m nodes

        int len1 = edges1.length; // n-1
        int len2 = edges2.length; // m-1

        MaxDiameter maxDiameter = new MaxDiameter();
        ArrayList<ArrayList<Integer>> forest1 = maxDiameter.createForest(edges1, len1);
        ArrayList<ArrayList<Integer>> forest2 = maxDiameter.createForest(edges2, len2);

        System.out.println(maxDiameter.findMaxDiameter(forest1, forest2)+1);

    }

    private int findMaxDiameter(ArrayList<ArrayList<Integer>> forest1, ArrayList<ArrayList<Integer>> forest2) {

        int[] maxDiameterAndNode = {-1, -1};
        findMaxDiameter(forest1, 0, -1, maxDiameterAndNode);
      //  System.out.println(maxDiameterAndNode[0]+":"+maxDiameterAndNode[1]);
        int maxDiam1 = maxDiameterAndNode[0];

        maxDiameterAndNode = new int[]{-1, -1};
        findMaxDiameter(forest2, 0, -1, maxDiameterAndNode);
        //System.out.println(maxDiameterAndNode[0]+":"+maxDiameterAndNode[1]);
        int maxDiam2 = maxDiameterAndNode[0];

        return (int)(Math.ceil(maxDiam1/2) + Math.ceil(maxDiam2/2));
    }

    private int findMaxDiameter(ArrayList<ArrayList<Integer>> forest1, int src, int parent, int[] maxDiameterAndNode) {

        int children = 0;
        int largestChildDist = 0;
        int secondLargestChildDist = 0;
        for (Integer neighbour : forest1.get(src)) {
            if (neighbour != parent) {
                children += 1;
                int childDist = findMaxDiameter(forest1, neighbour, src, maxDiameterAndNode);
                if (childDist > largestChildDist) {
                    secondLargestChildDist = largestChildDist;
                    largestChildDist = childDist;
                } else if (childDist > secondLargestChildDist) {
                    secondLargestChildDist = childDist;
                }
            }
        }
        int diameter = largestChildDist + secondLargestChildDist;
        if (maxDiameterAndNode[0] < diameter) {
            maxDiameterAndNode[0] = diameter;
            maxDiameterAndNode[1] = src;
           // System.out.println("max diameter updated:" + src + ":" + diameter);
        }
        if (children == 0) return 1;
        return largestChildDist + 1;
    }

    private ArrayList<ArrayList<Integer>> createForest(int[][] edges1, int len1) {
        ArrayList<ArrayList<Integer>> forest = new ArrayList<>();
        for (int i = 0; i <= len1; i++) {
            forest.add(new ArrayList<>());
        }
        for (int[] edge : edges1) {
            forest.get(edge[1]).add(edge[0]);
            forest.get(edge[0]).add(edge[1]);
        }
        return forest;
    }

}
