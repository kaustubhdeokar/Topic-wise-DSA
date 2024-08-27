package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Cycle {

    public void traverseBfs(ArrayList<ArrayList<Integer>> list, int nodes){
        boolean[] visited = new boolean[nodes];
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                traverseBfs(list, i, visited);
            }
        }
    }

    private void traverseBfs(ArrayList<ArrayList<Integer>> list, int curr, boolean[] visited) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(curr);
        visited[curr] = true;

        while(!queue.isEmpty())
        {
            curr = queue.remove();
            System.out.println(curr);
            for(int neigh: list.get(curr))
            {
                if(!visited[neigh]){
                    visited[neigh] = true;
                    queue.add(neigh);
                }
                else{
                    System.out.println("cycle.");
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.sampleGraph();

    }
}
