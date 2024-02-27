import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;


// adjacent should not have same color. 
// if we start coloring adjacents by alternate colors only way we get the same color is 
// if there is a cycle & cycle length is odd.

// so when a cycle is detected, check it's adjacents for same color.

public class BipartiteGraph {
    
     class NodeToColor{
        int node;
        int color;
        
        NodeToColor(int node, int color){
            this.node = node;
            this.color = color;
        }
        
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        
        int[] visited = new int[V];
        Arrays.fill(visited, -1);
        int color = 1; // color is 1 or 0 (let's do x+1%2)
        
        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                NodeToColor nc = new NodeToColor(i, 1);
                if(!bfs(adj, i, visited, nc)){
                    return false;
                }
            }
        }
    
        
        return true;
        
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int curr, int[] visited, NodeToColor nc)
    {
        // bfs -> each adjacent
        
        ArrayDeque<NodeToColor> q = new ArrayDeque<>();
        q.add(nc);
        
        while(!q.isEmpty()){
            
            NodeToColor top = q.remove();
            int node = top.node;
            int color = top.color;
            
            //System.out.println("top:"+node+":"+color+" visited:"+visited[node]);
            
            if(visited[node]==-1){
                visited[node] = color;
                //System.out.println("visited:"+node);
                for(int neigh: adj.get(node)){
                    q.add(new NodeToColor(neigh, ((color+1)%2)));
                }
            }
            else{
                //System.out.println("checking for cycle:"+node);
                //cycle check for adjacents.
                for(int neigh: adj.get(node)){
                    if(visited[neigh]==color){ // check for same color.
                        return false;
                    }
                }
            }
            

            
        }
        
        return true;
        
    }

}
