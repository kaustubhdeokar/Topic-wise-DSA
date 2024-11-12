package dp.problems;

import java.util.Arrays;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }
        return canConcatenate(memo, s1, 0, s2, 0, s3, 0);
    }

    boolean canConcatenate(int[][] memo, String s1, int ptr1,String s2, int ptr2,String s3, int ptr3)
    {
        if(ptr1==s1.length() && ptr2==s2.length() && ptr3 == s3.length()) return true;

        if(memo[ptr1][ptr2]!=-1) {
            return memo[ptr1][ptr2] == 1;
        }
        boolean res1 = false;
        boolean res2 = false;
        boolean str13Match = s1.charAt(ptr1) == s3.charAt(ptr3);
        boolean str23Match = s2.charAt(ptr2) == s3.charAt(ptr3);

        if (ptr1<s1.length() && ptr3< s3.length() && str13Match
                && ptr2 < s2.length() && str23Match)
        {
            res1 = canConcatenate(memo, s1,ptr1+1, s2, ptr2, s3, ptr3+1);
            res2 = canConcatenate(memo, s1,ptr1, s2, ptr2+1, s3, ptr3+1);
            if(res1||res2){
                memo[ptr1][ptr2] = 1;
            }
            else{
                memo[ptr1][ptr2] = 0;
            }
            return res1||res2;
        }

        else if(ptr1<s1.length() && ptr3<s3.length() && str13Match)
        {
            res1 = canConcatenate(memo, s1,ptr1+1, s2, ptr2, s3, ptr3+1);
            if(res1) memo[ptr1][ptr2] = 1;
            else memo[ptr1][ptr2] = 0;
            return res1;
        }

        else if(ptr3<s3.length() && ptr2<s2.length() && str23Match)
        {
            res2 = canConcatenate(memo, s1,ptr1, s2, ptr2+1, s3, ptr3+1);
            if(res2) memo[ptr1][ptr2] = 1;
            else memo[ptr1][ptr2] = 0;
            return res2;
        }
        memo[ptr1][ptr2] = 0;
        return false;
    }
}
