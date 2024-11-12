package array.problems;

public class CanSort {

    public boolean canSortArray(int[] nums) {

        int previousMax = Integer.MIN_VALUE;
        int previousMin = Integer.MAX_VALUE;
        int i = 0;


        while (i < nums.length) {

            int[] currentMinMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, i};
            i = calculateMaxAndMinForNextSegment(nums, i, currentMinMax);

            if (previousMax > currentMinMax[0]) return false;

            previousMin = currentMinMax[0];
            previousMax = currentMinMax[1];

            System.out.println("1 - min:" + previousMin + " max:" + previousMax);
        }

        return true;

    }

    public int calculateMaxAndMinForNextSegment(int[] nums, int i, int[] minMax) {
        int currSetBits = countSetBits(nums[i]);
        while (i < nums.length && countSetBits(nums[i]) == currSetBits) {
            minMax[0] = Integer.max(minMax[0], nums[i]);
            minMax[1] = Integer.min(minMax[1], nums[i]);
            i += 1;
        }
        System.out.println("1 - min:" + minMax[0] + " max:" + minMax[1]);
        return i;
    }


    public int countSetBits(int num) {
        int count = 0;
        System.out.print("num:" + num);
        while (num > 0) {
            num &= (num - 1);
            count += 1;
        }
        System.out.println(":" + count);
        return count;
    }

}
