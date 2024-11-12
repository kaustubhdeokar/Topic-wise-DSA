package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    /*

    You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

    i != j,
    abs(i - j) <= indexDiff.
    abs(nums[i] - nums[j]) <= valueDiff, and

Return true if such pair exists or false otherwise.

     */

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] nums = {1, 5, 9, 1, 5, 9};
        int indexDiff = 2;
        int valueDiff = 3;
        bucketSort.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // 0 1 2  3 4 6
        //(1 5 9)(1 5 9)
        // we sort the arrays into buckets of size indexDiff.
        // in each bucket -> valueDiff query should be applied and returned true or not.

        ArrayList<Integer> bucketList = new ArrayList<>(valueDiff + 1);
        int i = 0;
        int group = 0;
        while ((i + group) < nums.length) {
            while ((i + group) < nums.length && i <= indexDiff) {
                bucketList.add(nums[i + group]);
                i += 1;
            }
            Collections.sort(bucketList);
            for (int j = 1; j < bucketList.size(); j++) {
                if (Math.abs(bucketList.get(j) - bucketList.get(j - 1)) <= valueDiff) {
                    return true;
                }
            }
            bucketList.clear();
            i = 0;
            group += 1;
        }
        return false;
    }
}
