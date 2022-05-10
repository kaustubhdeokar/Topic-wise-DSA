public class Solution {
    
    class Graph{
        int vertices;
        ArrayList<ArrayList<Integer>> list;

        Graph(int vertices){
            this.vertices = vertices;
            list = new ArrayList<>();
            for(int i=0;i<vertices;i++)
            	list.add(i,new ArrayList<>());
        }

        public void addEdges(int[][] edges){
            for(int i=0;i<edges.length;i++){
                list.get(edges[i][0]).add(edges[i][1]);
            }
        }
    }

    
    public int solve(int A, int[][] B) {
        
        Graph g = new Graph(A);
        g.addEdges(B);
        ArrayList<ArrayList<Integer>> list = g.list; //graph formed. 

        boolean[] visited = new boolean[A+1];   //nodes visited in all calls.
        boolean[] currStack = new boolean[A+1]; //nodes in curr call. 

        for(int i=0;i<A;i++){
            int curr = i;
            if(!visited[curr]){
                if(dfsToCheckCycle(curr, visited, currStack, list)){
                    return 1;
                }
            }
        }
        return 0;
    }

    public boolean dfsToCheckCycle(int currNode, boolean[] visited, boolean[] currStack, ArrayList<ArrayList<Integer>> adj){
        
        if(currStack[currNode]) //if a node is traversed twice in curr call, a loop exists. 
            return true;

        if(visited[currNode])  // if it's not in currCall, then it's not a loop. for a DIRECTED GRAPH.
            return false;
       
        visited[currNode] = true;
        currStack[currNode] = true;

        for(Integer i:adj.get(currNode)){
            if(dfsToCheckCycle(i,visited,currStack,adj))
            return true;
        }

        currStack[currNode] = false; //remove node from curr stack call.

        return false;
    }

}

