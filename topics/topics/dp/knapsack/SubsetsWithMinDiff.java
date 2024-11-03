package dp.knapsack;

public class SubsetsWithMinDiff {

    public int minimumDifference(int[] nums) {
        //given that nums length array size n*2
        //on each subset of size n, find the difference
        //return the minimum difference.

        int sum = 0;
        for(int n: nums)
        {
            sum+=n;
        }
        int elems = 0;
        return minimumDifference(nums, sum, elems ,nums.length, 0);
    }

    public int minimumDifference(int[] nums, int sum, int elems ,int n, int currSum)
    {
        if(elems>(nums.length/2))
        {
            return Integer.MAX_VALUE;
        }
        if(n==0 && elems==(nums.length/2))
        {
            int a = sum - currSum;
            return Math.abs(a- currSum);
        }
        if(n<=0) return Integer.MAX_VALUE;

        return Integer.min(
                minimumDifference(nums, sum, elems+1, n-1, currSum + nums[n-1]),
                minimumDifference(nums, sum, elems, n-1, currSum)
        );
    }

//    public int minimumDifferenceDp(int[] nums, int sum, int elems ,int n, int currSum)
//    {
////        int[][] dp = new int[][];
//        if(elems>(nums.length/2))
//        {
//            return Integer.MAX_VALUE;
//        }
//        if(n==0 && elems==(nums.length/2))
//        {
//            int a = sum - currSum;
//            return Math.abs(a- currSum);
//        }
//        if(n<=0) return Integer.MAX_VALUE;
//
//        return Integer.min(
//                minimumDifference(nums, sum, elems+1, n-1, currSum + nums[n-1]),
//                minimumDifference(nums, sum, elems, n-1, currSum)
//        );
//    }
}
