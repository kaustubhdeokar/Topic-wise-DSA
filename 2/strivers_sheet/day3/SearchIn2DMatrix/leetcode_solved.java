public class leetcode_solved {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        //search for the row.
        int targetRow = 0;
        
        //O(n)

        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]>target)
                break;
            else
                targetRow = i;
        }
        System.out.println("target row"+targetRow);
        
        //once found the target row, search via binarysearch.
        //O(logn)
        return searchInRow(matrix[targetRow],0,matrix[targetRow].length-1,target);
        
    }
    
    
    public boolean searchInRow(int[] arr, int low, int high, int target){

        System.out.println("low"+low+"high"+high);
        
        
        if(low>high)
            return false;
        int med = (low+high)/2;
        
        if(arr[med]==target)
            return true;
        
        else if(arr[med]>target)
            return searchInRow(arr,low,med-1,target);
        else
             return searchInRow(arr,med+1,high,target);
        
            
    }
    

}
