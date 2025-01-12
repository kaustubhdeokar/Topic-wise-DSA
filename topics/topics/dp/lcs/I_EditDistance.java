package dp.lcs;

import java.util.Arrays;

public class I_EditDistance {
    public static void main(String[] args) {

        String s1 = "horse";
        String s2 = "ros";

        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }

        I_EditDistance editDistance = new I_EditDistance();
        System.out.println(editDistance.edit(memo, s1, s1.length(), s2, s2.length()));
    }

    private int edit(int[][] memo, String s1, int i, String s2, int j) {

        // if 'horse' starting is reached and we are still as [ro]s -> we need to add [ro] to match strings.
        // hence return pending string.
        if(i==0) return j;
        //if 'ros' starting is reached and we are still at middle of 'hor'se, we need to remove [hor] then , return pending length of string1.
        if(j==0) return i;

        if(memo[i][j]!=-1) return memo[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            memo[i][j] = edit(memo, s1, i - 1, s2, j - 1);
        } else {
            memo[i][j] = 1+ Integer.min(edit(memo, s1, i-1, s2, j), Integer.min(edit(memo, s1, i, s2, j-1), edit(memo, s1, i-1, s2, j-1)));
        }
        return memo[i][j];
    }
}
