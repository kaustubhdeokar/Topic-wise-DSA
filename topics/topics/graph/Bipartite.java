package graph;

import java.util.Arrays;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {

        int size = graph.length;
        int[] color = new int[size];
        Arrays.fill(color, -1);

        for(int i=0;i<size;i++){
            if(color[i]==-1){
                int currColor = 1;
                if(!dfs(graph, i, color, currColor)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int curr, int[] color, int currColor){

        color[curr] = currColor;

        for(int neigh: graph[curr]){
            if(color[neigh]==-1){
                if(!dfs(graph, neigh, color, (currColor+1)%2)){
                    return false;
                }
            }
            else if(color[neigh]==color[curr]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        Bipartite bipartite = new Bipartite();
        boolean isBipartite = bipartite.isBipartite(graph);
        System.out.println(isBipartite);

    }
}
