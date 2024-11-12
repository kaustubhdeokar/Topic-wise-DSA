package dp.problems;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
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

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1); //lis ending at each val = 1
        int maxLis = 1;
        int j = 1;
        while (j < nums.length) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    lis[j] = Math.max(lis[j], lis[i] + 1);
                    maxLis = Math.max(lis[j], maxLis);
                }
            }
            j += 1;
        }
        System.out.println(maxLis);


    }
}
