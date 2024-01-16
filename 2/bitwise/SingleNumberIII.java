//https://leetcode.com/problems/single-number-iii/description/

public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int[] resultArray = new int[2];
        int lastSetBit = xor & (~(xor - 1));

        // lastSetBit is a result of xor operations.
        // the reason we use it to segregate the two numbers as it can be true for any
        // one number.

        /*
         * eg: 3,5 are two odd numbers
         * 3 = 011
         * 5 = 101
         * 3^5 = 110
         * 
         * last set bit = 2
         * 
         * 3 & lastSetBit = 1
         * 5 & lastSetBit = 0
         * 
         * so, res1 = 3 & res2 = 5
         */
        for (int num : nums) {
            if ((num & lastSetBit) != 0) {
                resultArray[0] ^= num;
            } else {
                resultArray[1] ^= num;
            }
        }

        return resultArray;

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 1, 3, 2, 5 };
        int[] ans = singleNumber(arr);
        System.out.println(ans[0] + ":" + ans[1]);

    }
}
