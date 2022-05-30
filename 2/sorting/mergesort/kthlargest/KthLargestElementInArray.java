//Kth Largest Element in an Array
//https://leetcode.com/problems/kth-largest-element-in-an-array/

//applied mergesort to do the same.

import java.util.Optional;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Optional<Integer> optional = quicksort(nums,0,nums.length-1,nums.length-k); 
        if(optional!=null && optional.isPresent())
            return optional.get();
        
        int toFind = nums.length - k;
        int kthlargest = 0;
        System.out.println("tofind:"+toFind);
        
        for(int i=0;i<nums.length;i++){
            if(kthlargest == toFind)
                break;
            else
                kthlargest+=1;
        }
        return nums[kthlargest];
    }
    
    public Optional<Integer> quicksort(int[] nums,int low, int high,int k){
        if(low>=high)
            return null;
        
        int pivot = nums[high];
        int left = low;
        int right = high;
        
        while(left<right){
            while(nums[left] <= pivot && left<right){
                left+=1;
            }
            while(nums[right] >= pivot && left<right){
                right-=1;
            }
            swap(nums,left,right);
        }
        swap(nums,left,high);
        
        if(left==k)
            return Optional.of(nums[left]);
        
        quicksort(nums,low,left-1,k);
        quicksort(nums,left+1,high,k);
        return null;
    }
    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
}
