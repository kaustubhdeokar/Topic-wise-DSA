package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class NumberOfDistinctIslands {
    public static void main(String[] args){

        NumberOfDistinctIslands num = new NumberOfDistinctIslands();
        int[][] graph = new int[][]{
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}};
        num.numberOfDistinctIslands(graph);
    }

    public int numberOfDistinctIslands(int[][] graph)
    {

        // bfs on r,c=1 (store the cells subtracted from the base row and base col)
        // put them in a set and 

        int rows = graph.length;
        int cols = graph[0].length;


        for(int i=0; i<rows;i++){
            for(int j=0;j<cols;j++){
                if(graph[i][j] == 1){
                    ArrayList<int[]> path = calculateGroupDetails(graph, i, j);
                    for(int[] p: path){
                        System.out.print(p[0]+":"+p[1]+" ");
                    }
                    System.out.println();
                }
            }
        }

        return 0;

    }

    public ArrayList<int[]> calculateGroupDetails(int[][] graph, int baseRow, int baseCol){

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{baseRow, baseCol});
        graph[baseRow][baseCol] = 2;
        int maxRow = baseRow;
        int maxCol = baseCol;
        int cellsCovered = 0;

        ArrayList<int[]> path = new ArrayList<>();
        path.add(new int[]{0, 0});
        while(!q.isEmpty())
        {
            int[] curr = q.remove();
            cellsCovered+=1;
            int currI = curr[0];
            int currJ = curr[1];

            int nextI = currI+1;
            int nextJ = currJ;



            if(nextI < graph.length && nextJ < graph[0].length && graph[nextI][nextJ] == 1){
                maxRow = Integer.max(nextI-baseRow+1, maxRow);
                maxCol = Integer.max(maxCol-baseCol+1, nextJ);
                q.add(new int[]{nextI, nextJ});
                graph[nextI][nextJ] = 2;
                path.add(new int[]{nextI-baseRow, nextJ-baseCol});
            }



            nextI = currI;
            nextJ = currJ + 1;

            if(nextI < graph.length && nextJ < graph[0].length && graph[nextI][nextJ] == 1){
                maxRow = Integer.max(nextI-baseRow+1, maxRow);
                maxCol = Integer.max(maxCol-baseCol+1, nextJ);
                q.add(new int[]{nextI, nextJ});
                graph[nextI][nextJ] = 2;
                path.add(new int[]{nextI-baseRow, nextJ-baseCol});
            }

            nextI = currI;
            nextJ = currJ - 1;

            if(nextI > 0 && nextJ >0 && nextI < graph.length && nextJ < graph[0].length && graph[nextI][nextJ] == 1){
                maxRow = Integer.max(nextI-baseRow+1, maxRow);
                maxCol = Integer.max(maxCol-baseCol+1, nextJ);
                q.add(new int[]{nextI, nextJ});
                graph[nextI][nextJ] = 2;
                path.add(new int[]{nextI-baseRow, nextJ-baseCol});
            }

        }

        return path;

    }
}
