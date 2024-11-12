package backtrack;

import java.util.*;

public class PermutationSlower {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 1};
        Set<List<Integer>> list = new HashSet<>();
        permute(nums, list, 0);
        List<List<Integer>> l = new ArrayList<>();
        l.addAll(list);

    }

    private static void permute(int[] nums, Set<List<Integer>> set, int idx) {

        for (int i = 0; i < nums.length; i++) {

            int curr = nums[i];
            if (set.size() == 0) {
                List<Integer> inner = new ArrayList<>();
                inner.add(curr);
                set.add(inner);
            }
            else {
                int listSize = set.size();
                Set<List<Integer>> result = new HashSet<>();

                for (int j = 0; j < listSize; j++) {
                    for (List<Integer> inner : set) {
                        int innerSize = inner.size();
                        for (int k = 0; k <= innerSize; k++) {
                            List<Integer> newList = new ArrayList<>(inner);
                            newList.add(k, curr);
                            result.add(newList);
                        }
                    }
                }
                set = result;
            }
            System.out.println(set);
        }

    }
}
