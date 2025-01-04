package prefixsum.problems;

//2270. https://leetcode.com/problems/number-of-ways-to-split-array
public class ValidSplits {

    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int n : nums) sum += n;
        long remainingSum = 0;
        int splits = 0;
        long curr = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curr += nums[i];
            remainingSum = sum - curr;
            if (curr >= remainingSum) {
                splits += 1;
            }
        }
        return splits;
    }

}
