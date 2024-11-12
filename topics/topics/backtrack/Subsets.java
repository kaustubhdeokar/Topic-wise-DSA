package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> res = subsets.createSubsets(new int[]{1, 2, 3});
        System.out.println(res);
    }

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

        resultList.addAll(createSubSets(list, nums, currIdx + 1));

        list.add(nums[currIdx]);
        resultList.addAll(createSubSets(list, nums, currIdx + 1));
        list.remove(list.size() - 1);

        return resultList;
    }

    public List<List<Integer>> createSubsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {

            List<List<Integer>> innerList = new ArrayList<>();
            int curr = nums[i];

            for (int j = 0; j < result.size(); j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(curr);
                innerList.add(list);
            }
            result.addAll(innerList);
        }

        return result;

    }

}
