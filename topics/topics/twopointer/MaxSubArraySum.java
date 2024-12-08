package twopointer;


public class MaxSubArraySum {
    public static void main(String[] args) {

        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        int[] nums = new int[]{-5,1,2,-3,4};
        int k = 2;
        maxSubArraySum.maxSubarraySum(nums, k);
    }

    public long maxSubarraySum(int[] nums, int k) {
        if (k == 1) {
            return kadane(nums);
        }
        long res = Long.MIN_VALUE;
        long[] prefix = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < k; i++) {
            int len = (nums.length - i) / k;
            long[] tmp = new long[len];
            for (int j = 0; j < len; j++) {
                int start = i + j * k, end = start + k;
                tmp[j] = prefix[end] - prefix[start];
            }
            res = Math.max(res, kadane(tmp));
        }
        return res;
    }

    long kadane(long[] nums) {
        long res = Long.MIN_VALUE;
        long curr = 0;

        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(nums[i], curr+nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }

    long kadane(int[] nums) {
        long res = Long.MIN_VALUE;
        long curr = 0;

        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(nums[i], curr+nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }


    public long maxSubarraySum2(int[] nums, int k) {

        int negativeNums = 0;
        long curr = 0;
        long[] prefix = new long[nums.length];

        for(int i=0;i<nums.length;i++){
            curr += nums[i];
            prefix[i] = curr;
            if(nums[i]<0) negativeNums+=1;
        }

        int size;
        if(negativeNums > 0){
            size = k;
        }
        else{
            size = (nums.length / k) * k;
        }

        long totalMax = Long.MIN_VALUE;
        for(int s = size; s <= nums.length ; s+=k)
        {
            long currMax = Long.MIN_VALUE;
            for(int i=0;i<=nums.length-s;i++)
            {
                if(i==0) curr = prefix[i+s-1];
                else curr = prefix[i+s-1] - prefix[i-1];
                currMax = Long.max(currMax, curr);
            }
            totalMax = Long.max(totalMax, currMax);
        }
        return totalMax;
    }
}
