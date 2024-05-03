package graph.rev.TopologicalSort;

import graph.src.Graph;

import java.util.*;

public class TopologicalSort{
    

    public void toplogicalSort(ArrayList<ArrayList<Integer>> graph, int vertices){
        
        int[] indegree = new int[vertices];
        
        for(int i=0;i<graph.size();i++){
            for(int j=0;j<graph.get(i).size();j++){
                indegree[graph.get(i).get(j)]+=1;
         
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<vertices;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int top = queue.remove();
            System.out.println(top+" ");

            for(int adj:graph.get(top)){
                indegree[adj]-=1;
                if(indegree[adj]==0)
                    queue.add(adj);
            }
        }

    }
    
    public static void main(String[] args){

        Graph graph = new Graph();
        int[][] neighbours = {{2,3}, {3, 4}, {3}, {},{}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(neighbours);
        TopologicalSort ts = new TopologicalSort();
        ts.toplogicalSort(list,neighbours.length);
    }
}