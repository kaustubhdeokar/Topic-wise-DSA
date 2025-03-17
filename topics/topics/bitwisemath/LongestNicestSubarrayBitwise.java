package bitwisemath;

//https://leetcode.com/problems/longest-nice-subarray/?envType=daily-question&envId=2025-03-18
public class LongestNicestSubarray {

    public int longestNiceSubarray(int[] nums) {

        int start = 0;
        int res = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            while ((cur & n) != 0) {
                cur = cur ^ nums[start];
                start++;
            }
            res = Math.max(i - start + 1, res);
            cur = cur | n;
        }
        return res;

    }

    public static void main(String[] args) {

    }

}
