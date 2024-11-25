package dp.oned;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Integer.max(nums[0], nums[1]);
        if (nums.length == 3)
            return Integer.max(nums[0], Integer.max(nums[1], nums[2]));

        int i = 0;
        int a0 = nums[0];
        int a1 = Integer.max(nums[0], nums[1]);
        int ans1 = -1;
        int b0 = nums[1];
        int b1 = Integer.max(nums[2], nums[1]);
        int ans2 = -1;

        while (i < nums.length) {

            if (i > 1 && i < nums.length - 1) {
                a0 += nums[i];
                ans1 = Integer.max(a0, a1);
                a0 = a1;
                a1 = ans1;
                System.out.println(nums[i] + ":" + ans1);

            }

            if (i > 2) {
                b0 += nums[i];
                ans2 = Integer.max(b0, b1);
                b0 = b1;
                b1 = ans2;
            }
            i += 1;
        }

        return Integer.max(ans1, ans2);

    }

}
