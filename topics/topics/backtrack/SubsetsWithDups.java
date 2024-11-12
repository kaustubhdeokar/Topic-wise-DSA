package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDups {

    public static void main(String[] args) {
        SubsetsWithDups subsets = new SubsetsWithDups();
        List<List<Integer>> res = subsets.subsetsWithDup(new int[]{1, 1, 3});
        System.out.println(res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start = 0;
        int lastResultSize = 0;

        for (int i = 0; i < nums.length; i++) {

            List<List<Integer>> innerResult = new ArrayList<>();

            if (i > 0 && nums[i] == nums[i - 1]) {
                start = result.size() - lastResultSize;
            } else {
                start = 0;
            }

            for (int j = start; j < result.size(); j++) {
                List<Integer> integers = new ArrayList<>(result.get(j));
                integers.add(nums[i]);
                innerResult.add(integers);
            }

            lastResultSize = innerResult.size();
            result.addAll(innerResult);

        }

        return result;

    }

}
