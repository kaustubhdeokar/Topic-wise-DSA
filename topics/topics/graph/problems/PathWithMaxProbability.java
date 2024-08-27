package graph.problems;

import java.util.ArrayDeque;

public class PathWithMaxProbability {

    public static void main(String[] args) {

        int[][] graph = {{0, 1}, {1, 2}, {0, 2}};
        int n = 3;
        double[] succProb = new double[]{0.5, 0.5, 0.2};
        int startNode = 0;
        int endNode = 3;

        traversal(graph, n, succProb, startNode, endNode);

    }

    private static void traversal(int[][] graph, int n, double[] succProb, int startNode, int endNode) {

        boolean[] visited = new boolean[n];
        traversal(graph, startNode, endNode, visited);

    }

    //written a plain dfs.. to compute
    private static void traversal(int[][] graph, int startNode, int endNode, boolean[] visited) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()){
            Integer top = queue.remove();
            System.out.println(top+" ");
            for(int neigh: graph[top]){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    queue.add(neigh);
                }
            }
        }

    }

}
