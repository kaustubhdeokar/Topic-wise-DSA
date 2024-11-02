package graph;

import java.util.ArrayList;

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

    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> directedGraph = g.sampleDirectedGraph();
        CycleInUndirected cycle = new CycleInUndirected();
        cycle.isCycle(directedGraph);
    }

}
