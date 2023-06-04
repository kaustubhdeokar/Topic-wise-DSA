package leetcodeJun;

//https://leetcode.com/contest/weekly-contest-348/problems/semi-ordered-permutation/
public class SemiOrderedPermutation {

    public int semiOrderedPermutation(int[] nums) {

        int length = nums.length;

        // nums[0] = 1
        // nums[length-1] = length;

        //idea1: how far is 1 from 0th index. & how far is n from length-1 index -> add -> if 1 has greater index than n, minus 1 from result.

        int posOfOne = 0;
        int posOfN = 0;

        int posOfOneFromZeroIdx = 0;
        int posOfNFromLengthIdx = 0;
        int onePrecedesN = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                posOfOneFromZeroIdx = i;
                posOfOne = i;
            } else if (nums[i] == length) {
                posOfNFromLengthIdx = Math.abs(length - 1 - i);
                posOfN = i;
            }
        }

        //System.out.println("posOfOneFromZeroIdx"+posOfOneFromZeroIdx);

        //System.out.println("posOfNFromLengthIdx"+posOfNFromLengthIdx);

        onePrecedesN = posOfOne > posOfN ? 1 : 0;

        //System.out.println("onePrecedesN"+onePrecedesN);

        return posOfOneFromZeroIdx + posOfNFromLengthIdx - onePrecedesN;

    }
}
