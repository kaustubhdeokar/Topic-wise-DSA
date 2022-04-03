public class Efficient_Solution {
    
    /*

    treating the 2-d matrix as a single 1-matrix. 

    to find the middle element of a 2-d matrix. 
    
    low = 0
    high = row*col-1

    mid = low+(high-low)/2

    ex: 
    0 1 2
    3 4 5
    6 7 8
    9 10 11
    12 13 14

    low = 0
    high = 14
    mid = 7

    so for mid = 7 (also 7 element), it's matrix position will be

    row wise position = [mid/col] (7/3)->3 elements per row.
    col wise position = [mid%col] (7%3)->1 (3 elements per row hence mod3)

    */

    public boolean searchMatrix(int[][] arr, int target) {
        
         
        int low = 0;
        int row = arr.length;
        int col = arr[0].length;
        int high = row*col-1;
        
        
        while(low<=high){

            int mid = low+(high-low)/2;
            
            if(arr[mid/col][mid%col]==target){
                return true;
            }
            else if(arr[mid/col][mid%col] > target)
                high = mid-1;
            else
                low = mid+1;

        }

        return false;
        
    }
    


}
