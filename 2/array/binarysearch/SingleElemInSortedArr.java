
/*

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 nums = [1,1,2,3,3,4,4,8,8]
 -> 2 

*/


//one approach is to take xor. 


import java.io.*;
import java.util.*;

public class SingleElemInSortedArr{


   public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for(int i:nums){
            xor^=i;
        }
        return xor;
    }
    
// but this takes n time to take lesser time using binary search. 


	public int singleNonDuplicateBS(int[] nums) {
        
        int start = 0;
        int end = nums.length-1;
        
        //xor of 1 with odd num gives num-1
        //xor of 1 with even num gives num+1
        /*
        with the nums array.
        all the nums except for 1 occur in pairs. 
        with index 0,1 - 2,3 - 4,5 
        hence with the xor technique above, 
        when we get for odd number, we should check the previous element is same or not. 
        							and vice versa for even. 
        if arr[num] & arr[num^1] is equal, hence till this point all numbers are in pair, and increment start = mid+1;
        						 is not equal, then the single element is towards left, already occured. 
               
        
        */
        
       while(start<end){
       	int mid = start+(end-start)/2;
       	if(nums[mid]==nums[mid^1])
       		start = mid+1;
       	else
       		end = mid;
       	}
	    return nums[start];    
    }
    
}
	    
