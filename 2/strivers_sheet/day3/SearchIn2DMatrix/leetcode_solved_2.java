public class leetcode_solved_2 {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //search for the row.
        
        int targetRow = searchInMatrix(matrix,0,matrix.length-1,target);
        
        System.out.println("targetrow:"+targetRow);
        if(targetRow==-1)
            return false;
        
        return searchInRow(matrix[targetRow],0,matrix[targetRow].length-1,target);
        
    }
    
    
        
    public int searchInMatrix(int[][] arr, int low, int high, int target){

        System.out.println("low"+low+"high"+high);
        
        
        if(low>high)
            return -1;
        
        int med = (low+high)/2;
        int length = arr[med].length;
        
        if(arr[med][0]<=target && arr[med][length-1]>=target)
            return med;
        
        else if(arr[med][0]>target)
            return searchInMatrix(arr,low,med-1,target);
        
        else
             return searchInMatrix(arr,med+1,high,target);
        
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
