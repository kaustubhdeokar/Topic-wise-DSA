package graph;

import java.util.LinkedList;

class Solution {
    
    class Graph{
        int vertices;
        LinkedList<Integer>[] list;

        Graph(int vertices){
            this.vertices = vertices;
            list = new LinkedList[vertices+1];
            
            for(int i=0;i<=vertices;i++)
                list[i] = new LinkedList<>();
            
        }
        
        public int addEdge(int[][] edge){
            for(int i=0;i<edge.length;i++){
                list[edge[i][0]].add(edge[i][1]);
                list[edge[i][1]].add(edge[i][0]);
            }
            
            for(int i=1;i<=vertices;i++){
                if(list[i].size()==vertices-1){
                    return i;
                }
            }
            return -1;
        }
        
    }
    
    public int findCenter(int[][] edges) {
        
        Graph g = new Graph(edges.length+1);
        return g.addEdge(edges);
        
    }
}
