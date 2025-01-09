package graph.shortestpath;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    //there is also a way in which we can avoid using djikstra's here.
    //plain dfs will work here with shortest hops to the destination -> answer.

    public int shortestPathBinaryMatrix(int[][] grid) {

        int len = grid.length;
        int rows = len;
        int cols = len;

        if(grid[0][0]==1|| grid[len-1][len-1]==1)
            return -1;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1) grid[i][j] = -1;
                else grid[i][j] = Integer.MAX_VALUE;
            }
        }

        Comparator<int[]> distToNode = (c1, c2) -> Integer.compare(c1[0], c2[0]);
        Queue<int[]> q = new PriorityQueue<>(distToNode);
        grid[0][0] = 1;
        q.add(new int[]{1,0,0});

        while(!q.isEmpty())
        {
            int[] top = q.remove();
            int i = top[1];
            int j = top[2];
            int currDist = top[0];

            if(i==len-1 && j==len-1)
            {
                return Math.abs(currDist);
            }

            valid(i+1, j+1, currDist+1, len, q, grid);
            valid(i+1, j, currDist+1, len, q, grid);
            valid(i+1, j-1, currDist+1, len, q, grid);

            valid(i, j+1, currDist+1, len, q, grid);
            valid(i, j-1, currDist+1, len, q, grid);

            valid(i-1, j+1, currDist+1, len, q, grid);
            valid(i-1, j, currDist+1, len, q, grid);
            valid(i-1, j-1, currDist+1, len, q, grid);
        }

        return -1;

    }

    public void valid(int i, int j, int currDist, int len, Queue<int[]> q,
                      int[][] grid){

        if(i>=0 && j>=0 && i<len && j<len && grid[i][j]!=-1 && currDist<grid[i][j])
        {
            grid[i][j] = currDist;
            q.add(new int[]{currDist,i,j});
        }
    }
}
