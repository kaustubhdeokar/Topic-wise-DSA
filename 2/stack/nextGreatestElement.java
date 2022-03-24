//leetcode problem link - https://leetcode.com/problems/next-greater-element-i/

import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //1 - nGE for array nums2
        
        Stack<Integer> stack = new Stack<>();
        int nums2Length = nums2.length;
        int[] highestElements = new int[nums2Length];
        
        //for the last element - as it has -1 as it's next Greatest Element.
        stack.push(nums2[nums2Length-1]);
        highestElements[nums2Length-1] = -1;
        
        for(int i=nums2Length-2;i>=0;i--){
            
            boolean nextGreatestElFound = false;
            while(!stack.isEmpty()){
                if(stack.peek()>nums2[i]){
                    highestElements[i] = stack.peek();
                    stack.push(nums2[i]);
                    nextGreatestElFound = true;
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(!nextGreatestElFound){
                highestElements[i] = -1;
                stack.push(nums2[i]);
            }
            
        }
              
        Map<Integer,Integer> mapNumbersToNextGreatestElements = new HashMap<>();
        for(int i=0;i<nums2Length;i++){
            mapNumbersToNextGreatestElements.put(nums2[i],highestElements[i]);
        }
        
        int[] nextGreatestElForNums1 = new int[nums1.length];
        int index = 0;
        for(Integer i:nums1){
            nextGreatestElForNums1[index++] = mapNumbersToNextGreatestElements.get(i);
        }
        return nextGreatestElForNums1;
        
    }
}
