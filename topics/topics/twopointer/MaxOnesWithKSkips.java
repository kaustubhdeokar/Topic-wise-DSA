package twopointer;

public class MaxOnesWithKSkips {
    public static void main(String[] args) {
        MaxOnesWithKSkips max = new MaxOnesWithKSkips();
        System.out.println(max.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        int zeroCount = 0;
        int maxString = 0;

        while (i < len)
        {
            int curr = nums[i];
            if (curr == 1)
            {
                i += 1;
            }
            else if (zeroCount < k)
            {
                zeroCount += 1;
                i += 1;
            }
            else
            {
                maxString = Math.max(i - j, maxString);
                zeroCount += 1;
                while (zeroCount > k)
                {
                    curr = nums[j];
                    if (curr == 0)
                    {
                        zeroCount -= 1;
                    }
                    j += 1;
                }
                i+=1;
            }
        }

        maxString = Math.max(i - j, maxString);

        return maxString;
    }
}
