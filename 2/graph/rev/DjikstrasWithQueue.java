
import java.util.*;

public class DjikstrasWithQueue{

  static class NodeToDistance{
    
        int node;
        int distance;
        
        public NodeToDistance(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    
    static int[] dijkstra(int vertices, ArrayList<ArrayList<ArrayList<Integer>>> graph, int source)
    {
        
        int[] visited = new int[vertices];
        int[] distances = new int[vertices];
        
                
        PriorityQueue<NodeToDistance> q = new PriorityQueue<>((n1, n2)->Integer.compare(n1.distance, n2.distance));
        
        for(int i=0;i<vertices;i++){
            distances[i] = Integer.MAX_VALUE;
            q.add(new NodeToDistance(i, Integer.MAX_VALUE));
        }
        
        q.add(new NodeToDistance(source, 0));
        distances[source] = 0;
        

        for(int i=0;i<vertices;i++){
            
            NodeToDistance top = q.remove();
            int currNode = top.node;
            int currDist = top.distance;
            
            while(visited[currNode]==1){
                top = q.remove();
                currNode = top.node;
                currDist = top.distance;
            }
            
            visited[currNode] = 1;
            
            for(ArrayList<Integer> adj: graph.get(currNode)){
                
                int dest = adj.get(0);
                int dist = adj.get(1);
                
                if(visited[dest]==0){
                    distances[dest] = Integer.min(distances[dest], distances[currNode]+dist);
                    q.add(new NodeToDistance(dest, distances[dest]));
                }
                                
            }       
                
        } 
        
        return distances;
        
    }

    

}