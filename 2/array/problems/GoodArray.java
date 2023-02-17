//Bezout's Identity - 
//if gcd(a,b) = d, then there exist integers x and y, s.t a * x + b * y = d;
//https://leetcode.com/problems/check-if-it-is-a-good-array/

class GoodArray {
    public boolean isGoodArray(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            result = gcd(nums[i], result);
            if (result == 1)
                return true;
        }
        return result == 1;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
