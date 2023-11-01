public class CountingSubIslands {
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int traversals = 0;

        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[i].length;j++){
                if(grid2[i][j]==1){
                    if(traverse(grid1, grid2, i, j)){
                        traversals += 1;
                    }                    
                }
            }
        }
        return traversals;
    }

    public boolean traverse(int[][] grid1, int[][] grid2, int i, int j){
        

        if(i>=0 && j>=0 && i < grid2.length && j < grid2[i].length && grid2[i][j]==1
          && grid2[i][j]!=2){
            
            if(grid1[i][j] == 0) return false;
            
            grid2[i][j] = 2;

            if(traverse(grid1, grid2, i, j+1) && traverse(grid1, grid2, i, j-1)
               && traverse(grid1, grid2, i+1, j) && traverse(grid1, grid2, i-1, j))
               {
                   return true;
               }
               else{
                   grid2[i][j] = 1;
                   return false;
               }
        }

        return true;
    }
    
}
