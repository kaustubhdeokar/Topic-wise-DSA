import java.util.*;
import java.io.*;

public class 3SumProblem{
	
	 public List<List<Integer>> threeSum(int[] nums) {
        
    		int n = nums.length;
    		int[] twoSum = new int[n];
    		for(int i=0;i<n;i++)
    			twoSum[i] = -1*nums[i];
    		
    		List<List<Integer>> answers = new ArrayList<>();
    		
    		for(int i=0;i<n;i++){
    		
			List<Integer> list = findIfTwoSumPossible(nums,twoSum[i],i);
			if(list.size()==2)
			{
				list.add(nums[i]);
				answers.add(list);
			}
				
		}
	    		
    		return answers;
    		
    	
    	}
    	
    	List<Integer> findIfTwoSumPossible(int[] nums,int sumRequired, int indexToAvoid){
    	
    		Map<Integer,Integer> map = new HashMap<>();

    		for(int i=0;i<nums.length;i++){
    		
    			if(i!=indexToAvoid){
    			
				if(map.get(sumRequired-nums[i])!=null)
					return Arrays.asList(sumRequired-nums[i],i);
				
				else
					map.put(nums[i],i);			
    				
    			}
    			
    		}	
    		
    	}
    	
    	
	public ArrayList<Integer> twoSum(int[] nums,int target){
	
		Set<Integer> map = new HashSet<>();
		
		for(int i=0;i<nums.length;i++){
			if(map.contains(target-nums[i]))
				return new ArrayList<>(List.of(nums[i],target-nums[i]));
			else
				map.put(nums[i]);
		}
		return new ArrayList<>();	
				
		
	}

	
	public static void main(String[] args){
	
	3SumProblem
	
	}	
	

}
