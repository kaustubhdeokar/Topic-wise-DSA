package graph.undirected;

public class GoodComponents {
    
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[] = new boolean[V+1];
        int totalCompNodes = 0;
        for(int i=1;i<=V;i++){
            if(!visited[i]){
                totalCompNodes += findIfComponentIsGood(i, adj, visited);
            }
        }
        return totalCompNodes;
        
    }
    
    public int findIfComponentIsGood(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        
        int nodesInComponent = 1;
        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.add(i);
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(i);
        visited[i] = true;
        
        while(!q.isEmpty()){
            
            int top = q.pop();
            
            for(int neigh: adj.get(top)){
                if(!visited[neigh]){
                    q.add(neigh);
                    nodesInComponent+=1;
                    nodes.add(neigh);
                    visited[neigh] = true;
                }
            }
            
        }
        
        for(int node: nodes){
            if(adj.get(node).size()!=(nodesInComponent-1)){
                return 0;
            }
        }
    
        return 1;        
        
    }
    

}
