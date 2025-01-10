package graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInWater {

    public int swimInWater(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        Comparator<int[]> compByLevel = (c1, c2) -> (c1[0]-c2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>(compByLevel);

        q.add(new int[]{grid[0][0], 0, 0,-1});

        int nextI, nextJ;

        while(!q.isEmpty()){
            int[] top = q.remove();
            int currI = top[1];
            int currJ = top[2];
            int currDist = top[0];
            int parentVal = top[3];

            if(visited[currI][currJ]==1) continue;
            visited[currI][currJ] = 1;

            int pathMax = Math.max(grid[currI][currJ], parentVal);
            if(currI==rows-1 && currJ==cols-1) return pathMax;

            int val1 = getVal(grid, rows, cols, currI+1, currJ);
            int val2 = getVal(grid, rows, cols, currI-1, currJ);
            int val3 = getVal(grid, rows, cols, currI, currJ+1);
            int val4 = getVal(grid, rows, cols, currI, currJ-1);

            grid[currI][currJ] = Integer.max(grid[currI][currJ], pathMax);
            if(val1!=Integer.MAX_VALUE){
                q.add(new int[]{val1, currI+1, currJ, grid[currI][currJ]});
            }
            if(val2!=Integer.MAX_VALUE){
                q.add(new int[]{val2, currI-1, currJ, grid[currI][currJ]});
            }
            if(val3!=Integer.MAX_VALUE){
                q.add(new int[]{val3, currI, currJ+1, grid[currI][currJ]});
            }
            if(val4!=Integer.MAX_VALUE){
                q.add(new int[]{val4, currI, currJ-1, grid[currI][currJ]});
            }

        }
        return -1;
    }

    public int getVal(int[][] grid, int rows, int cols, int ni, int nj){
        if(ni>=0 && nj>=0 && ni<rows && nj<cols){
            return grid[ni][nj];
        }
        else return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[][] grid =  {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        SwimInWater swimInWater = new SwimInWater();
        int res = swimInWater.swimInWater(grid);
        System.out.println(res);
    }
}
