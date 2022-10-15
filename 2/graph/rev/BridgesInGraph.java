/*
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * 
 */
import java.util.*;

public class BridgesInGraph {
    

    public void criticalConnections(int n, List<List<Integer>> connections) {
        
        boolean[] visited = new boolean[n];
        int[] discovery = new int[n];
        int[] lowestDisc = new int[n]; //lowest discovery of adjacent nodes.
        int[] time = {1};
        int parent = -1;
        
        Arrays.fill(lowestDisc, Integer.MAX_VALUE);
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(List<Integer> innerList: connections){
            int source = innerList.get(0);
            int dest = innerList.get(1);
            graph.get(source).add(dest); 
            graph.get(dest).add(source); 
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                findBridges(i, parent, visited, graph, time, discovery, lowestDisc);
            }
        }
        
    }


    public void findBridges(int current, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> graph, int[] time, int[] discovery, int[] lowestDisc){

        visited[current] = true;
        discovery[current] = lowestDisc[current] = time[0];
        time[0]+=1;
        
        for(int child: graph.get(current)){
            if(!visited[child]){
                findBridges(child, current, visited, graph, time, discovery, lowestDisc);
                
                lowestDisc[current] = Integer.min(lowestDisc[current], lowestDisc[child]);

                if(lowestDisc[child] > discovery[current]){
                    //this is a bridge.
                    //as their is connection from this child to it's ancestors. 
                }
            }
            else if(child!=parent){ //backedge case.
                lowestDisc[current] = Integer.min(lowestDisc[current], discovery[child]);
            }
            
        }
        

    }

    public static void main(String[] args){

        

    }

}
