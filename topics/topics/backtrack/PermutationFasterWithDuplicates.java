package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationFasterWithDuplicates {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> src = new ArrayList<>();
        for (int a : nums) src.add(a);
        traversal(src, new ArrayList<>());
        return ans;
    }

    private void traversal(List<Integer> src, List<Integer> temp) {
        if (src.isEmpty()) {
            ans.add(new ArrayList<>(temp));
            System.out.println(temp);
            return;

        } else {
        }
        for (int i = 0; i < src.size(); i++) {
            if (i > 0 && src.get(i).equals(src.get(i - 1))) continue;
            temp.add(src.get(i));
            List<Integer> newSrc = new ArrayList<>(src);
            newSrc.remove(i);
            traversal(newSrc, temp);
            temp.remove(temp.size() - 1);
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        PermutationFasterWithDuplicates permutationFaster = new PermutationFasterWithDuplicates();
        List<List<Integer>> lists = permutationFaster.permuteUnique(nums);
        System.out.println(lists);
    }


}
