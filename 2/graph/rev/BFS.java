package graph.rev;

import java.util.*;

public class BFS{


    public void bfsUtil(ArrayList<ArrayList<Integer>> list, int vertices){

        int[] visited = new int[vertices];
        for(int i=0;i<vertices;i++){
            if(visited[i]==0){
                bfs(i, visited, vertices, list);
            }
        }
        
    }

    public void bfs(int vertex, int[] visited, int vertices, ArrayList<ArrayList<Integer>> list){

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);

        while(!queue.isEmpty()){

            int top = queue.pop();
            System.out.println(top);
            for(int adjacent: list.get(top)){
                if(visited[adjacent]!=0){
                    queue.add(adjacent);
                }
            }
            visited[top] = 1;
        }


    }

    class Graph {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    
        public ArrayList<ArrayList<Integer>> createGraph(int[][] arr) {
    
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(new ArrayList<>());
                for (int j : arr[i])
                    list.get(i).add(j);
            }
            return list;
        }
    
    
    
        public ArrayList<ArrayList<Pair>> createGraphWithWeights(int[][] arr, int vertices) {
    
            ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    
            for (int i = 0; i < vertices; i++)
                list.add(new ArrayList<>());
    
            for (int i = 0; i < arr.length; i++) {
                list.get(arr[i][0]).add(new Pair(arr[i][1], arr[i][2]));
            }
            return list;
        }
    
        public HashMap<Integer, ArrayList<Integer>> createGraph(int[][] arr, boolean isBidirectional) {
            for (int i = 0; i < arr.length; i++) {
    
                int key = arr[i][0];
                int value = arr[i][1];
    
                addToGraph(key, value);
                if (isBidirectional) {
                    addToGraph(value, key);
                }
            }
            return graph;
        }
    
        public void addToGraph(int key, int value) {
            if (graph.get(key) != null) {
                graph.get(key).add(value);
            } else {
                graph.put(key, new ArrayList<>() {{
                    add(value);
                }});
            }
        }
    
    }

    public static void main(String[] args){

        Graph graph = new Graph();
        int[][] matrix = {{1, 2}, {0, 2, 3, 4}, {0, 1, 3, 4}, {1, 2}, {1, 2}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(matrix);
        BFS bfs = new BFS();
        bfs.bfsUtil(list, 5);
    }

}
