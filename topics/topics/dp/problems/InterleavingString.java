package dp.problems;

import java.util.Arrays;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s) {
        if (s1.length() + s2.length() != s.length()) return false;
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return canConcatenate(memo, s1, 0, s2, 0, s, 0);
    }

    boolean canConcatenate(int[][] memo, String s1, int ptr1, String s2, int ptr2, String s, int ptr) {
        if (ptr1 == s1.length() && ptr2 == s2.length() && ptr == s.length()) return true;

        if (memo[ptr1][ptr2] != -1) {
            return memo[ptr1][ptr2] == 1;
        }
        boolean res1 = false;
        boolean res2 = false;

        if (ptr1 < s1.length() && ptr < s.length() && s1.charAt(ptr1) == s.charAt(ptr)) {
            res1 = canConcatenate(memo, s1, ptr1 + 1, s2, ptr2, s, ptr + 1);
            if(res1) {
                memo[ptr1][ptr2] = 1;
                return true;
            }
        }

        if (ptr2 < s2.length() && ptr < s.length() && s2.charAt(ptr2) == s.charAt(ptr)) {
            res2 = canConcatenate(memo, s1, ptr1, s2, ptr2 + 1, s, ptr + 1);
            if(res2){
                memo[ptr1][ptr2] = 1;
                return true;
            }

        }
        int val = (res1 || res2) ? 1 : 0;
        memo[ptr1][ptr2] = val;
        return res1 || res2;
    }

    public static void main(String[] args) {

        InterleavingString interleavingString = new InterleavingString();
        System.out.println("is interleaving: " + interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));

    }
}
