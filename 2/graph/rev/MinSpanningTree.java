public class MinSpanningTree{

 static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int[] visited =new int[V];
        int[] minDist = new int[V];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        minDist[0] = 0;
        int totalDist = 0;
        
        for(int i=0;i<V;i++){
            
            int currVertex = -1;
            int minValue = Integer.MAX_VALUE;
            
            for(int j=0;j<V;j++){
                
                if(visited[j]==0 && minDist[j]<minValue){
                    minValue = minDist[j];
                    currVertex = j;
                    //System.out.println("minDist:"+j+":"+minDist[j]);
                }
            }
            
            visited[currVertex] = 1;
            totalDist += minDist[currVertex];
            
            
            //System.out.println("currvertex"+currVertex);
            
            for(ArrayList<Integer> outer: adj.get(currVertex)){
        
                int vertex = outer.get(0);
                int distance = outer.get(1);
                
                if(visited[vertex]==0){
                    minDist[vertex] = Integer.min(minDist[vertex], distance);
                }    
        
            }
                
                
        }
            
            

        return totalDist;
    
    }

}