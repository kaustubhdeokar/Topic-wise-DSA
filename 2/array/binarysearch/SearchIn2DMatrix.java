public class SearchIn2DMatrix{


	  /*
	  [
	  [1,4,7,11,15],
	  [2,5,8,12,19],
	  [3,6,9,16,22],
	  [10,13,14,17,24],
	  [18,21,23,26,30]
	  ]
	  
    ex: target = 6
	start from row =0  col = matrix[0].length-1
	as matrix[row][col], in col - 4 all values below 15 are greater, we can just skip that 
		col-> c--
	else if the value is lesser (but greater than curr[row][col]) we can jump to next row, 
		row->r++
	return when matrix[row][col]==target.
	
	  
	  */

	  public boolean searchMatrix(int[][] matrix, int target) {
            
        int row = 0;
        int col = matrix[row].length-1;
        
        while(col>=0 && row<matrix.length){
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                col-=1;
            else
                row+=1;
        }
        
        return false;
    }

}
