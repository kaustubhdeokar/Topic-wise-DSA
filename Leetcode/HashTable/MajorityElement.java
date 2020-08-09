//For finding majority Element in an array 
//https://leetcode.com/problems/majority-element/
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
*/
import java.util.HashMap;
import java.util.Map;

class Solution {
       //Time O(n) Space O(n);
        public int majorityElement(int[] nums) {
        Map<Integer,Integer>countMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            if(countMap.containsKey(current)) {
                countMap.put(current, countMap.get(current) + 1);
            }
            else{
                countMap.put(current, 1);
            }
        }
        int majorityLength = nums.length/2;
        int majorityElement = 0;
        for(Map.Entry<Integer,Integer>entry:countMap.entrySet()){
            if(entry.getValue()>majorityLength){
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
}


/*
	//Time o(nlogn)
        //Space O(1)

	//sort the array
	Arrays.sort(arr);
        element at index arr.length/2 is the majority element;

	public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
        }
*/
