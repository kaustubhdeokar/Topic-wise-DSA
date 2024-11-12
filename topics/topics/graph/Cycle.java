package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Cycle {

    public void directedGraphDfs(ArrayList<ArrayList<Integer>> list, int nodes) {
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                System.out.println("traversing:" + i);
                boolean[] recStack = new boolean[nodes];
                System.out.println("cycle exists:" + directedGraphDfs(list, i, visited, recStack));
            }
        }
    }



    private boolean directedGraphDfs(ArrayList<ArrayList<Integer>> list, int curr, boolean[] visited, boolean[] recstack) {


        visited[curr] = true;
        recstack[curr] = true;
        System.out.println(curr);

        for (int neigh : list.get(curr)) {
            System.out.println("neigh: " + neigh + " curr:" + curr);

            if (!visited[neigh]) {
                visited[neigh] = true;
                if (directedGraphDfs(list, neigh, visited, recstack)) {
                    return true;
                }
            }
            if (recstack[neigh]) {
                return true;
            }
        }

        recstack[curr] = false;
        return false;
    }

    //kahns algo
    public boolean directedBfs(ArrayList<ArrayList<Integer>> graph, int nodes){
        int[] indegree = new int[nodes];
        for(ArrayList<Integer> inner: graph){
            for(Integer destination: inner){
                indegree[destination]+=1;
            }
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<nodes;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        if(q.isEmpty()){
            return true;
        }

        while(!q.isEmpty()){
            Integer top = q.remove();
            System.out.print(top+" ");
            for(int neighbour: graph.get(top)){
                indegree[neighbour]-=1;
                if(indegree[neighbour]==0) q.add(neighbour);
            }
        }

        return !q.isEmpty();
    }

    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> directedGraph = g.sampleDirectedGraph();
        Cycle cycle = new Cycle();
        cycle.directedGraphDfs(directedGraph, 4);
        boolean res = cycle.directedBfs(directedGraph, 4);
        System.out.println("res:"+res);
    }

}
