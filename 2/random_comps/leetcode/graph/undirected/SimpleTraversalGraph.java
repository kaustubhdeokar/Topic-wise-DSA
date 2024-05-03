package graph.undirected;

import java.util.HashMap;
import java.util.Map;

public class SimpleTraversalGraph {
    

    public static void main(String[] args) {
        
        int[][] arr = {{2,3},{1,5},{1,4,6},{3},{2,7},{3,7},{5,6}};
        boolean[] visited = new boolean[arr.length+1];
        SimpleTraversalGraph graph = new SimpleTraversalGraph();

        System.out.println(graph.dfs(arr, visited, 1, -1));

    }

    public boolean dfs(int[][] arr, boolean[] visited, int curr, int parent){

        visited[curr-1] = true;
        System.out.println("visiting node:"+curr);

        for(int adj: arr[curr-1]){
            if(!visited[adj-1]){
                return dfs(arr, visited, adj, curr);
            }
            else if(adj!=parent){
                System.out.println("cycle found at :"+adj);
                return true;
            }
        }
        return false;
    }

    

}
