import java.util.*;

public class TopologicalSortDFS{
    

    public void toplogicalSort(ArrayList<ArrayList<Integer>> graph, int vertices){
        
        int[] visited = new int[vertices];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                dfs(graph, i, visited, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int currVertex, int[] visited, Stack<Integer> stack){

        visited[currVertex] = 1;

        for(int adj: graph.get(currVertex)){
            if(visited[adj]==0){
                dfs(graph, adj, visited, stack);
            }
        }
        System.out.println("added currvertex:"+currVertex);
        stack.add(currVertex);

    }
    
    public static void main(String[] args){

        Graph graph = new Graph();
        int[][] neighbours = {{1}, {3}, {3,4}, {4},{}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(neighbours);
        TopologicalSortDFS ts = new TopologicalSortDFS();
        ts.toplogicalSort(list,neighbours.length);
    }
}