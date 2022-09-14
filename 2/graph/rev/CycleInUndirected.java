import java.util.*;

public class CycleInUndirected{

  public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(dfs(i, visited, adj, -1))
                    return true;
            }
        }
        return false;
    }
    /**
    
    we can find this by keeping a visited array, and noting that if a node has been visited before. 
    the only trick is that while tracking a child node it's parent node will be visited, we have to avoid 
    such cases. 
    
    hence if any already visited node is found & if it's not the parent node it is a cycle
    
     */
    public boolean dfs(int curr, int[] visited, ArrayList<ArrayList<Integer>> graph, int parent){
        visited[curr] = 1;
        for(int i=0; i<graph.get(curr).size();i++){
            if(visited[graph.get(curr).get(i)]==0){
                if(dfs(graph.get(curr).get(i), visited, graph, curr))
                    return true;
            }
            else if(graph.get(curr).get(i)!=parent)
                return true;
        }
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