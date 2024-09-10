package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class Traversal {

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
            }
        }
    }

    private void traverseDfs(ArrayList<ArrayList<Integer>> list, int nodes){
        boolean[] visited = new boolean[nodes];
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                traverseDfs(list, i, visited);
            }
        }
    }

    private void traverseDfs(ArrayList<ArrayList<Integer>> list, int curr, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.add(curr);
        visited[curr] = true;

        while(!stack.isEmpty()){
            curr = stack.pop();
            System.out.println(curr);
            for(int neigh: list.get(curr)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    stack.add(neigh);
                }
            }
        }
    }


    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.sampleGraph();
        Traversal traversal = new Traversal();
        System.out.println("BFS");
        traversal.traverseBfs(graph, 5);
        System.out.println("\nDFS");
        traversal.traverseDfs(graph, 5);
    }

}