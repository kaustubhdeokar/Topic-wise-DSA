package array.problems;

import java.util.PriorityQueue;
import java.util.Stack;

public class ContinuousSubarrays {

    public static void main(String[] args) {

        ContinuousSubarrays continuousSubarrays = new ContinuousSubarrays();
        System.out.println(continuousSubarrays.continuousSubarrays(new int[]{5, 4, 2, 4, 5}));


    }

    public long continuousSubarrays(int[] nums) {

        int i = 0;
        int j = 0;

        int max = nums[0];
        int min = nums[0];
        int maxIdx = -1;
        int minIdx = -1;

        long count = 0;

        while (j < nums.length) {
            while (j < nums.length) {
                min = Integer.min(min, nums[j]);
                max = Integer.max(max, nums[j]);
                if (max == nums[j]) maxIdx = j;
                if (min == nums[j]) minIdx = j;
                if (Math.abs(max - min) > 2) break;
                j += 1;
            }
            //System.out.println("i:"+i+" j:"+j);
            if (j == nums.length) {
                break;
            } else {
                long n = j - i;
                count += (n * (n - 1)) / 2;
                //System.out.println("count:"+count);

                if (nums[j] < nums[i]) {
                    i = maxIdx + 1;
                } else {
                    i = minIdx + 1;
                }

                if (i < j) {
                    int toRemove = j - i;
                    count -= ((toRemove) * (toRemove - 1)) / 2;
                }

                int k = i;
                max = nums[k];
                min = nums[k];
                maxIdx = k;
                minIdx = k;
                while (k < j) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                    if (max == nums[k]) maxIdx = k;
                    if (min == nums[k]) minIdx = k;
                    k += 1;
                }
                //System.out.println("fin:i"+i+", j:"+j+", k:"+k);
            }

        }
        long n = j - i;
        count += (n * (n - 1)) / 2;

        count += nums.length; //all single subarrays.

        return count;
    }

}
