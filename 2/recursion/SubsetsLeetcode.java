package recursion;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/subsets/
public class SubsetsLeetcode {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int numsLen = nums.length;
        return createSubSets(list, nums, 0);
    }

    public List<List<Integer>> createSubSets(List<Integer> list, int[] nums, int currIdx) {

        List<List<Integer>> resultList = new ArrayList<>();

        if (currIdx == nums.length) {
            resultList.add(new ArrayList<>(list));
            return resultList;
        }


        list.add(nums[currIdx]);
        resultList.addAll(createSubSets(list, nums, currIdx + 1));
        list.remove(list.size() - 1);

        resultList.addAll(createSubSets(list, nums, currIdx + 1));


        return resultList;
    }
}
