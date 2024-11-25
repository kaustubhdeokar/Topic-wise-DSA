package array.problems;

import java.util.List;

public class SlidingWindowLc {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int[] prefix = new int[nums.size()];
        prefix[0] = nums.get(0);
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums.get(i) + prefix[i - 1];
        }

        int minSubarraySum = Integer.MAX_VALUE;

        int j;
        int toSubtract;
        for (int i = 0; i < prefix.length; i++) {
            j = i;
            int window = j - i + 1;
            while (window < l) {
                j += 1;
                window += 1;
            }

            toSubtract = (i > 0) ? prefix[i - 1] : 0;

            while (window >= l && window <= r && j < prefix.length) {
                int prefixSum = prefix[j] - toSubtract;
                if (prefixSum > 0) {
                    minSubarraySum = Math.min(minSubarraySum, prefixSum);
                }
                j += 1;
                window += 1;
            }

            if (j == prefix.length && (j - i) >= l && (j - i) <= r) {
                int prefixSum = prefix[j - 1] - toSubtract;
                if (prefixSum > 0) {
                    minSubarraySum = Math.min(minSubarraySum, prefixSum);
                }
            }

        }
        if (minSubarraySum == Integer.MAX_VALUE) return -1;
        return minSubarraySum;
    }

    public static void main(String[] args) {
        SlidingWindowLc slidingWindowLc = new SlidingWindowLc();

        System.out.println(slidingWindowLc.minimumSumSubarray(List.of(9,11,-9), 3, 3));
    }
}
