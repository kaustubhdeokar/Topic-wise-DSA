package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {

        int[] nums = {1, 2};
        List<Integer> list = new ArrayList<>();
        int numsLen = nums.length;
        ArrayList<ArrayList<Integer>> subSets = createSubSets(list, nums, 0);

    }

    public static ArrayList<ArrayList<Integer>> createSubSets(List<Integer> list, int[] nums, int currIdx) {

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        if (currIdx == nums.length) {
            resultList.add(new ArrayList<>(list));
            return resultList;
        }


        list.add(nums[currIdx]);
        resultList.addAll(createSubSets(list, nums, currIdx + 1));
        list.remove(list.size()-1);

        resultList.addAll(createSubSets(list, nums, currIdx + 1));


        return resultList;
    }

}
