package prefixsum.problems;

import java.util.HashMap;
import java.util.Map;

//leetcode pod 11 dec
public class MaxCommonRange {

    public static void main(String[] args) {

        MaxCommonRange maxCommonRange = new MaxCommonRange();
        int[] nums = {4, 6, 1, 2};
        int k = 2;
        System.out.println(maxCommonRange.maximumBeauty(nums, k));
    }

    public int maximumBeauty(int[] nums, int k) {

        //possible ranges nums[i]-k, nums[i]+k
        //2-6 4-8 -1-3 0-4
        /*
occurance  1 1 1-1 1-1  -1   -1
arr        0 1 2 3 4 5 6 7 8  9
total      1 2 3 2 3 2   1    0
        */
        if (nums.length == 1) return 1;

        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int n : nums) {
            int lowerLimit = Integer.max(0, n - k);
            map.merge(lowerLimit, 1, Integer::sum);
            int upperLimit = n + k + 1;
            map.merge(upperLimit, -1, Integer::sum);
            max = Math.max(max, n + k);
        }
        int maxCount = 0;
        int curr = 0;
        for (int i = 0; i < max; i++) {
            if (map.get(i) != null) {
                curr += map.get(i);
                maxCount = Math.max(maxCount, curr);
                if (maxCount == nums.length) return maxCount; //maxed out.
            }
        }
        return maxCount;
    }


}

