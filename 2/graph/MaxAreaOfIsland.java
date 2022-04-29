class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int area = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    area = Integer.max(area,dfs(grid,i,j,visited));
                    
                }
            }
        }
        return area;
    }
    
       public int dfs(int[][] grid,int r,int c,boolean[][] visited){
        
        if(grid[r][c]==0)
            return 0;
        
        int count = 0;
           
        if(!visited[r][c]){

            visited[r][c] = true;
            if(grid[r][c]==1)
                count+=1;
            
            if(r>=1)
                count += dfs(grid,r-1,c,visited);
            if(c>=1)
                count += dfs(grid,r,c-1,visited);
            if(r<(grid.length-1))
                count += dfs(grid,r+1,c,visited);
            if(c<(grid[0].length-1))
                count += dfs(grid,r,c+1,visited);

        }
        return count;
    }
}
