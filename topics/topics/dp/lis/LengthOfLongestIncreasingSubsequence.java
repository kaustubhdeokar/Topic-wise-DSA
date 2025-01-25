package dp.lis;

import java.util.ArrayList;

//todo: document.
//todo: how to do it in nlogn ?
public class LengthOfLongestIncreasingSubsequence {
    public static void main(String[] args) {

        //lis ending at each val = 1

        //10, 9, 2, 5, 3, 7, 101, 18
        //1   1  1  1  1  1   1   1

        //for j=1
        //starting from 10, no value less than 9, no change to the result.

        //for j=2
        //starting from 10, no value less than 2, no change to the result.

        //for j=3
        //starting from 10, 2 is less than 5, lis[5] = max(lis[5], lis[2]+1)
        //10, 9, 2, 5
        //1   1  1  2

        //for j=4
        //starting from 10, 2 is less than 3, lis[3] = max(lis[3], lis[2]+1)
        //10, 9, 2, 5 3
        //1   1  1  2 2

        //for j=5
        //starting from 10, 2,5,3 is less than 7, lis[7] = max(lis[7], lis[2]+1) lis[7] = max(lis[7], lis[5]+1) lis[7] = max(lis[7], lis[3]+1)
        //10, 9, 2, 5, 3, 7
        //1   1  1  2  2  3

        int[] nums;
        nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        nums = new int[]{0, 1, 0, 3, 2, 3};
        LengthOfLongestIncreasingSubsequence lis = new LengthOfLongestIncreasingSubsequence();
        lis.binarySearch(nums);
    }

    public void binarySearch(int[] nums) {

        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int start = 0;
            int end = lis.size() - 1;
            int curr = nums[i];
            if (lis.get(end) < curr) {
                lis.add(curr);
                continue;
            }

            // 4 5 8 - input
            // 0 1 2
            // curr = 7
            // s = 0 e = 2 , m = 1, curr > mid, s = m+1,
            // s = 2 e = 2, m = 2, m < curr, end = s-1;, e=1, s = 2
            // 4 5 7 - output

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (lis.get(mid) >= curr) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (end < 0) lis.set(0, curr);
            else lis.set(start, curr);
            if (start - 1 >= 0 && lis.get(start - 1) == lis.get(start)) {
                lis.remove(lis.size() - 1);
            }
        }
        System.out.println(lis);
        System.out.println(lis.size());
    }

    public void traversalBruteForce(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLis = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
        }
        System.out.println(maxLis);
    }

}
