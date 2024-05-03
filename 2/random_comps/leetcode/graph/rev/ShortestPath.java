package graph.rev;

import graph.src.Graph;

import java.util.*;

public class ShortestPath{

    public void findShortestPath(ArrayList<ArrayList<Integer>> adjList, int vertices){

        int[] visited = new int[vertices];
        int[] shortestPath = new int[vertices];
        for(int i=0;i<vertices;i++){
            shortestPath[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<vertices;i++){
            if(visited[i]==0)
                findShortestPathFor(adjList, visited, shortestPath, i);
        }

        for(int i:shortestPath){
            System.out.println(i+" ");
        }

    }

    public void findShortestPathFor(ArrayList<ArrayList<Integer>> graph, int[] visited, int[] shortestPath,int currVertex){
        visited[currVertex] = 1;
        shortestPath[currVertex] = 0;
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(currVertex);

        int dist = 0;

        while(!q.isEmpty()){

            int top = q.remove();
            
            for(int i=0;i<graph.get(top).size();i++){

                if(visited[graph.get(top).get(i)]==0){
                    visited[graph.get(top).get(i)] = 1;
                    shortestPath[graph.get(top).get(i)] = shortestPath[top] + 1;
                    q.add(graph.get(top).get(i));
                }

            }

        }
        
    }


    public static void main(String[] args){

        graph.src.Graph graph = new Graph();
        int[][] neighbours = {{1, 2,4}, {0, 3}, {0, 3, 4}, {1, 2, 5}, {0, 2, 5}, {3,4}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(neighbours);
        ShortestPath shortestPath = new ShortestPath();
        shortestPath.findShortestPath(list, 6);
        


    }


}