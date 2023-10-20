//https://leetcode.com/problems/find-if-path-exists-in-graph/


/*



*/

class Solution {
    
    
    class Graph{
        int vertices;
        LinkedList<Integer>[] list;
        
        Graph(int vertices){
            this.vertices = vertices;
            list = new LinkedList[vertices];
            
            for(int i=0;i<vertices;i++)
                list[i] = new LinkedList<>();
        }

		//forming a LL for each node. 
        
        public void addEdges(int[][] edges){
            for(int i=0;i<edges.length;i++){
                list[edges[i][0]].add(edges[i][1]);
                list[edges[i][1]].add(edges[i][0]);
            }
        }
        
        //breadth first search traversal starting from source to find destination.
        
        public boolean edgeExists(int source,int destination){
            
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.addAll(list[source]);
            boolean[] visited = new boolean[vertices];
            
            while(!q.isEmpty()){
                Integer top = q.pop();
                
                if(!visited[top]){
                    for(Integer i:list[top]){
                        if(i ==  destination)
                            return true;
                        if(!visited[i])
                            q.add(i);
                    }
                }
                
                visited[top] = true;
                
            }
            return false;   
        }
        
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        if(n==1)
            return true;
        
        Graph g = new Graph(n);
        g.addEdges(edges);
        return g.edgeExists(source,destination);
    }
}
