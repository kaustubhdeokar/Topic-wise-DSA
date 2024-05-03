package graph.rev;

import java.util.*;

public class ArticulationPoints {
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int[] visited = new int[V];
        int[] discovery = new int[V];
        int[] lowestChildrenDiscovery = new int[V];
        ArrayList<Integer> points = new ArrayList<>();
        int[] articulationPoints = new int[V];
        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        
        int current = 0;
        int time = 0;
        
        for(int i=0;i<V;i++){
            
            if(visited[i]==0){
                dfs(i, parent, adj, visited, discovery, lowestChildrenDiscovery, time, articulationPoints);
            }
                
        }
        
        for(int i=0;i<V;i++){
            if(articulationPoints[i]==1){
                points.add(i);
            }
        }
        
        if(points.size()==0){
            points.add(-1);
        }
        
        return points;
    }
    
    public void dfs(int current, int[] parent, ArrayList<ArrayList<Integer>> graph, int[] visited, int[] discovery, int[] lowestChildrenDiscovery, int time, int[] articulationPoints){
        
        visited[current] = 1;
        discovery[current] = lowestChildrenDiscovery[current] = time;
        time+=1;
        
        int children = 0;
        
        for(int child: graph.get(current)){
            
            if(visited[child]==0){
                
                children+=1;
                parent[child] = current;
                dfs(child, parent, graph, visited, discovery, lowestChildrenDiscovery, time+1, articulationPoints);
                
                lowestChildrenDiscovery[current] = Integer.min(lowestChildrenDiscovery[current], lowestChildrenDiscovery[child]);
                
                if(parent[current] == -1 && children>1){
                    articulationPoints[current] = 1;
                }
                
                if(parent[current]!=-1 && lowestChildrenDiscovery[child] >= discovery[current]){
                    articulationPoints[current] = 1;
                }
                
            }   
            
            else if(current != parent[child])
                lowestChildrenDiscovery[current] = Integer.min(lowestChildrenDiscovery[current], discovery[child]);
            
        }
        
    }
}
