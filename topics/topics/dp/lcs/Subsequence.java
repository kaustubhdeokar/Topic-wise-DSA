package dp.lcs;

import java.util.Arrays;

public class Subsequence {
    public static void main(String[] args) {
        String s1 = "rabbbit";
        String s2 = "rabbit";

        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }

        Subsequence subsequence = new Subsequence();
        StringBuilder curr = new StringBuilder();
        int res = subsequence.subsequence(memo, s1, s1.length(), s2, s2.length());
        System.out.println(res);

        System.out.println();

        for(int[] m: memo){
            for(int m1: m){
                System.out.print(m1+" ");
            }
            System.out.println();
        }
    }

    private int subsequence(int[][] memo, String s1, int i, String s2, int j) {
        if(j<=0){
            return 1;
        }
        if (i <= 0) {
            return 0;
        }

        if(memo[i][j]!=-1) return memo[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            memo[i][j] = subsequence(memo, s1, i - 1, s2, j - 1) + subsequence(memo, s1, i-1, s2, j);
        } else {
            memo[i][j] = subsequence(memo, s1, i-1, s2, j);
        }
        return memo[i][j];
    }
}
