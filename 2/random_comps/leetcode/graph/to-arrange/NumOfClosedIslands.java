class NodePair{
    int x;
    int y;
    NodePair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int closedIsland(int[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int i=0;
        for(int j=0;j<grid[i].length;j++){
            if(!visited[i][j]){
                dfs(i,j,grid,visited);
            }
        }
        
        i=grid.length-1;
        for(int j=0;j<grid[i].length;j++){
            if(!visited[i][j]){
                dfs(i,j,grid,visited);
            }
        }
        
        int j=0;
        for(i=0;i<grid.length;i++){
            if(!visited[i][j]){
                dfs(i,j,grid,visited);
            }
        }
        
        j=grid[0].length-1;
        for(i=0;i<grid.length;i++){
            if(!visited[i][j]){
                dfs(i,j,grid,visited);
            }
        }
        
        int count = 0;
        for(i=0;i<grid.length;i++){
            for(j=0;j<grid[0].length;j++){
             
                
             if(grid[i][j]==0 && !visited[i][j])
             {
                 count+=1;
                 dfs(i,j,grid,visited);
             }

            }
        }
        
        return count;
    }
    
    public void dfsToCountZero(int[][] grid,boolean[][] visited){
     
    }
    
    
    public void dfs(int i,int j,int[][] grid,boolean[][] visited){
        
        
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length)
            return;
        
        if(grid[i][j]!=0)
            return;
        
        if(!visited[i][j]){

            visited[i][j] = true;
            grid[i][j]=1;
            
            dfs(i+1,j,grid,visited);
            dfs(i-1,j,grid,visited);
            dfs(i,j+1,grid,visited);
            dfs(i,j-1,grid,visited);
            
        }
        
    }
    
}
