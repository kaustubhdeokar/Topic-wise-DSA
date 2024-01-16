//https://leetcode.com/problems/single-number-ii/

/*
 * 
 * Given an integer array nums where every element appears three times except for one, 
 * which appears exactly once. Find the single element and return it.
 */

public class SingleNumberII {
    public int singleNumber(int[] A) {

        int number = 0;

        for (int i = 0; i < 32; i++) {

            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                // if for a bit, count of sets bits for all numbers in the array are present,
                // add them.
                if (((A[j] >> i) & 1) == 1) {
                    sum += 1;
                    sum %= 3;
                }
            }
            if (sum != 0) {
                number |= sum << i; // re-constructing the number bit by bit.
            }
        }
        return number;
    }

    public int singleNumberII(int[] A) {

        for (int i : A) {

        }

        return -1;
    }

}