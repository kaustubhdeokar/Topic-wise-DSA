import java.util.*;

public class CycleInDirected{

  public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                int[] currVisited = new int[V];
                if(dfs(i, visited, currVisited, adj))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int curr, int[] visited, int[] currVisited, ArrayList<ArrayList<Integer>> graph){
        
        visited[curr] = 1;
        currVisited[curr] = 1;

        for(int i=0; i<graph.get(curr).size();i++){

            if(visited[graph.get(curr).get(i)]==0 && dfs(curr, visited, currVisited, graph)){
                return true;
            }
            else if(currVisited[graph.get(curr).get(i)]==0){
                return true;
            }
        }
        
        currVisited[graph.get(curr)] = 0;
        return false;

    }

   
    public static void main(String[] args){

        Graph graph = new Graph();
        int[][] neighbours = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(neighbours);
        CycleInUndirected cycle = new CycleInUndirected();
        System.out.println("cycle exists: "+cycle.isCycle(list, 4));

    }

}