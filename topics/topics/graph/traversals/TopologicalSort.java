package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.createKahnsAlgoGraph();
        int vertices = 6;

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.traverse(graph, vertices);
        topologicalSort.kahnsAlgo(graph, vertices);
    }

    private void kahnsAlgo(ArrayList<ArrayList<Integer>> graph, int vertices){
        //calculate indegree..
        //push elements with indegree 0 to the queue.
            //for each element reduce indegree of it's neighbours.
            //if neighbour indegree is 0 push to queue.
        //add to output result.

        //step1
        //0 1 2 3 4 5
        //2 2 1 1 0 0
        //elems=(4,5)

        //step2
        //curr->4 -> 0, 1 indegree[0]-=1 indegree[1]-=1
        //0 1 2 3 4 5
        //1 1 1 1 0 0
        //elems -> (5)

        //step3
        //curr->5 -> 2, 0 indegree[0]-=1 indegree[2]-=1
        //0 1 2 3 4 5
        //1 0 0 1 0 0
        //elems -> (0,2)

    }
    //leetcode course schedule
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][1]]+=1;
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int nodesProcessed = 0;

        while(!queue.isEmpty()){
            int top = queue.remove();
            nodesProcessed+=1;
            for(int adj:graph.get(top)){
                indegree[adj]-=1;
                if(indegree[adj]==0){
                    queue.add(adj);
                }
            }
        }

        return nodesProcessed==numCourses;
    }

    private void traverse(ArrayList<ArrayList<Integer>> graph, int vertices) {
        boolean[] recStack = new boolean[vertices];
        boolean[] visited = new boolean[vertices];
        Stack<Integer> resStack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if(!topologicalTraversalPossible(graph, i, visited, recStack, resStack)){
                    System.out.println("cycle starting from i:" + i + ":");
                }
            }
        }

        while(!resStack.isEmpty()){
            System.out.println(resStack.pop());
        }

    }

    private boolean topologicalTraversalPossible(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] visited, boolean[] recStack,
                                                 Stack<Integer> resStack) {

        visited[curr] = true;
        recStack[curr] = true;

        for (int neigh : graph.get(curr)) {
            if (!visited[neigh]) {
                if (!topologicalTraversalPossible(graph, neigh, visited, recStack, resStack)) {
                    return false;
                }
            } else if (recStack[neigh]) {
                System.out.println("cycle");
                return false;
            }
        }
        resStack.push(curr);
        recStack[curr] = false;
        return true;
    }


}
