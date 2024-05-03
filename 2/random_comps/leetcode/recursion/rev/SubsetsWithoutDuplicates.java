package recursion.rev;//https://leetcode.com/problems/subsets-ii/submissions/

import java.util.*;

public class SubsetsWithoutDuplicates {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        ArrayList<Integer> curr = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        createSubsets(nums, curr, 0, list, false);
        return list;
    }
    
      private static void createSubsets(int[] nums, ArrayList<Integer> curr, int index, List<List<Integer>> list, boolean choosePrev){
  
        if(index >= nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }

        createSubsets(nums, curr, index+1, list, false);

        if(index>=1 && nums[index]==nums[index-1] && !choosePrev)
            return;
          
        curr.add(nums[index]);
        createSubsets(nums, curr, index+1, list, true);
        curr.remove(curr.size()-1);
    }
}
