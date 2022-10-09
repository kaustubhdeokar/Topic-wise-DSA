public class MinSpanningTree{

 static class NodeToDistance{
        int node;
        int distance;
        
        public NodeToDistance(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int[] visited =new int[V];
        int[] distance = new int[V];
        
        PriorityQueue<NodeToDistance> q = new PriorityQueue<>((n1, n2)->Integer.compare(n1.distance, n2.distance));
        
        q.add(new NodeToDistance(0, 0));
        distance[0] = 0;
        for(int i=1;i<V;i++){
            q.add(new NodeToDistance(i,Integer.MAX_VALUE));    
            distance[i] = Integer.MAX_VALUE;
        }
        
        int totalDist = 0;
        
        for(int i=0;i<V;i++){
            
            NodeToDistance top = q.remove();
            int currNode = top.node;
            int currDist = top.distance;
            
            
            
            while(visited[currNode]!=0){
                
                top = q.remove();
                currNode = top.node;
                currDist = top.distance;
                
            }
            
            visited[currNode] = 1;
            totalDist += distance[currNode];
            
            for(ArrayList<Integer> adjacent: adj.get(currNode))
            {
                int adjacentVertex = adjacent.get(0);
                int adjacentDistance = adjacent.get(1);
                
                if(visited[adjacentVertex]==0){
                    distance[adjacentVertex] = Integer.min(distance[adjacentVertex],  adjacentDistance);
                    q.add(new NodeToDistance(adjacentVertex, distance[adjacentVertex]));
                   
                }
            }
        }
        return totalDist;
    }

}