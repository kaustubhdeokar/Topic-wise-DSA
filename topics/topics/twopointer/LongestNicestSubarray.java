package twopointer;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/longest-nice-subarray/?envType=daily-question&envId=2025-03-18
public class LongestNicestSubarray {

    public int longestNiceSubarray(int[] nums) {

        int l = 0;
        int r = 0;
        int maxLen = 1;

        List<Integer> list = new ArrayList<>();

        while (r < nums.length) {
            list.add(nums[r]);
            // System.out.println("r:"+r+" list:"+list);
            if (checkIfValid(list)) {
                r += 1;
            } else {
                // System.out.println("list cleared, r:"+r+" l:"+l);
                list.clear();
                list.add(nums[r]);
                l = r - 1;
                while (l >= 0 && checkIfValid(list)) {
                    list.add(nums[l]);
                    l -= 1;
                }
                list.remove(list.size() - 1);
                r += 1;
                // System.out.println("l:"+l+" list:"+list);
            }
            maxLen = Integer.max(maxLen, list.size());
        }

        return maxLen;
    }

    public boolean checkIfValid(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if ((nums.get(i) & nums.get(j)) != 0) return false;
            }
        }
        return true;
    }


}
