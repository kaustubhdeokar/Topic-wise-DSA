import java.util.ArrayDeque;

public class RottingOranges {
    
    class Node{
        
        int i;
        int j;
        int curr;

        Node(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.curr = k;
        }

    }

    public int orangesRotting(int[][] grid) {
        
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                
                ArrayDeque<Node> q = new ArrayDeque<>();

                if(grid[i][j]==2){
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    q.add(new Node(i, j, 2));
                    traverse(grid, q, visited);
                }
            }
        }

        int[] minMax = {Integer.MIN_VALUE};

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                
                if(grid[i][j]==1){
                    return -1;
                }
                if(grid[i][j]>2){
                    minMax[0] = Integer.max(minMax[0], grid[i][j]);
                }

            }
        }
        
        
        if(minMax[0] == Integer.MIN_VALUE){
            return 0;
        }
        
        return minMax[0] - 3 + 1;

    }

    public void traverse(int[][] grid, ArrayDeque<Node> q, boolean[][] visited){

        while(!q.isEmpty()){

            Node top = q.remove();
            int i = top.i;
            int j = top.j;
            int curr = top.curr;
            visited[i][j] = true;

            if(grid[i][j]==1){
                grid[i][j] = curr;
            }
            else if(grid[i][j]>2){
                grid[i][j] = Integer.min(grid[i][j], curr);
            }

            if(isValid(grid, i+1, j, visited)){
                q.add(new Node(i+1, j, curr+1));
            }
            if(isValid(grid, i-1, j, visited)){
                q.add(new Node(i-1, j, curr+1));
            }
            if(isValid(grid, i, j-1, visited)){
                q.add(new Node(i, j-1, curr+1));
            }
            if(isValid(grid, i, j+1, visited)){
                q.add(new Node(i, j+1, curr+1));
            }

        }        

    }

    public boolean isValid(int[][] grid, int i, int j, boolean[][] visited){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length && visited[i][j]==false
         && grid[i][j]!=0;
    }
    
}
