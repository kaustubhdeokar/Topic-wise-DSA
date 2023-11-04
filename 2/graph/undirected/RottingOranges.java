import java.util.ArrayDeque;

public class RottingOranges {

    public static void main(String[] args) {
        
        RottingOranges rottingOranges = new RottingOranges();
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        rottingOranges.orangesRotting(grid);

    }
    
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
        
        int[][] visited = new int[grid.length][grid[0].length];
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Node(i, j, 0));            
                }
                if(grid[i][j]==0){
                    visited[i][j] = 0;
                }
            }
        }

        return traverse(grid, q, visited);

    }

    public int traverse(int[][] grid, ArrayDeque<Node> q, int[][] visited){

        int maxRottenTimeRecorded = Integer.MIN_VALUE;

        while(!q.isEmpty()){

            Node top = q.remove();
            int i = top.i;
            int j = top.j;
            int curr = top.curr;

            if(isValid(grid, i, j, visited)){
                
                maxRottenTimeRecorded = Integer.min(maxRottenTimeRecorded, curr);
                visited[i][j] = 2;
                System.out.println("marking as rotten, i:"+i+" j:"+j);

                q.add(new Node(i+1, j, curr+1));
                q.add(new Node(i-1, j, curr+1));
                q.add(new Node(i, j-1, curr+1));
                q.add(new Node(i, j+1, curr+1));
            }
        
        }

        return maxRottenTimeRecorded;
    
    }

    public boolean isValid(int[][] grid, int i, int j, int[][] visited){
        return i>=0 && i<visited.length && j>=0 && j<visited[0].length && (visited[i][j]!=2 || visited[i][j]!=0);
    }
    
}
