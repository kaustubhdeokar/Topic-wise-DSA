
package graph.traversals;

import graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CycleInUndirected {

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                if(dfs(adj, i, -1, visited)) return true;
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int parent,
                       boolean[] visited)
    {
        visited[src] = true;
        for(int neighbour: graph.get(src)){
            if(!visited[neighbour]){
                if(dfs(graph, neighbour, src, visited)) return true;
            }
            else if(neighbour!=parent){
                return true;
            }
        }
        return false;

    }

    public boolean bfs(ArrayList<ArrayList<Integer>> graph, int src, int parent,
                       boolean[] visited)
    {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{src, parent});
        visited[src] = true;

        while(!q.isEmpty()){
            int[] top = q.remove();
            int currNode = top[0];
            int currParent = top[1];

            for(int neighbour: graph.get(currNode)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(new int[]{neighbour, currNode});
                }
                else if(neighbour!=currParent){
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> directedGraph = g.sampleUndirectedGraph();
        CycleInUndirected cycle = new CycleInUndirected();
        System.out.println(cycle.isCycle(directedGraph));
    }

}
