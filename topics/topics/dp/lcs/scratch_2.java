package dp.lcs;

import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {

        String s1 = "hfofxe";
        String s2 = "hfxeof";
        Scratch s = new Scratch();
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int[] m: memo) Arrays.fill(m, -1);
        System.out.println(s.lcs(memo, s1, s1.length(), s2, s2.length()));

    }

    private int lcs(int[][] memo, String s1, int l1, String s2, int l2) {
        if (l1 <= 0 || l2 <= 0) return 0;

        if(memo[l1][l2] != -1) return memo[l1][l2];

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return memo[l1][l2] =  1 + lcs(memo, s1, l1 - 1, s2, l2 - 1);
        }
        else {
            return memo[l1][l2] = Integer.max(lcs(memo, s1, l1 - 1, s2, l2), lcs(memo, s1, l1, s2, l2 - 1));
        }
    }
}