//https://leetcode.com/problems/find-the-town-judge/

//creating an adjaceny list. if anyone has 0 outgoing, so they trust no one. 
// and if incomings on that node are vertices-1 -> everyone trusts them

/*

THIS IS DONE IS A PRETTY BAD WAY, 
IN AN EASIER WAY , WE CAN KEEP A SINGLE ARRAY, trust[n]
AND DECREMENT FOR OUTGOING -> trust[source]--
AND INCREMENT FOR INCOMING -> trust[destination]++
*/

import java.util.LinkedList;

class TownJudge {
    
     class Graph{
         
        int vertices;
        LinkedList<Integer>[] list;
        int[] visited;
         
        Graph(int vertices){
            this.vertices = vertices;
            list = new LinkedList[vertices+1];
            visited = new int[vertices+1];
            
            for(int i=1; i<=vertices; i++)
                list[i] = new LinkedList<>();
        }
                 
        public void addEdges(int[][] edges){
            for(int i=0;i<edges.length;i++){
                list[edges[i][0]].add(edges[i][1]);
                visited[edges[i][1]]+=1;
            }
        }
        
		
		

        public int judgeExists(){
            
            for(int i=1;i<=vertices;i++){
                if( list[i].size() == 0 && visited[i] == vertices-1 )
                    return i;
            }
            return -1;
        }

         
        
    }
    
    
    public int findJudge(int n, int[][] trust) {
        Graph g = new Graph(n);
        g.addEdges(trust);
        return g.judgeExists();
    }
}
