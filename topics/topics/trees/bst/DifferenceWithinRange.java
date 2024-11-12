package trees.bst;

import sorting.BucketSort;

import java.util.TreeSet;

public class DifferenceWithinRange {

    public static void main(String[] args) {
        DifferenceWithinRange diff = new DifferenceWithinRange();
        int[] nums = {1,5,9,1,5,9};
        int indexDiff = 2;
        int valueDiff = 3;
        diff.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);

    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();

        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + valueDiff);
            final Integer ceil = values.ceiling(nums[ind] - valueDiff);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= indexDiff) {
                values.remove(nums[ind - indexDiff]);
            }
        }

        return false;
    }
}
