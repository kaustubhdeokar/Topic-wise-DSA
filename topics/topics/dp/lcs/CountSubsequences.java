package dp.lcs;

import java.util.Arrays;

public class CountSubsequences {

    public static void main(String[] args) {
        String s1 = "xxyxy";
        String s2 = "xy";
        int[] memo = new int[s1.length()+1];
        Arrays.fill(memo, -1);
        StringBuilder s2Rev = new StringBuilder(s2).reverse();
        CountSubsequences count = new CountSubsequences();
        StringBuilder curr = new StringBuilder();
        int res = count.count(s1, s1.length(), memo, s2Rev.toString(), curr);
        System.out.println("res:" + res);
    }

    public int count(String s1, int index, int[] memo, String s2, StringBuilder curr) {
        if (curr.length() > s2.length()) return 0;

        if (index == 0) {
            System.out.println(curr);
            if (curr.toString().equals(s2)) return 1;
            else return 0;
        }

        if(memo[index]!=-1) {
            System.out.println("calculated for index:"+index);
            return memo[index];
        }

        int right = count(s1, index - 1, memo, s2, curr);
        curr.append(s1.charAt(index-1));
        int left = count(s1, index - 1, memo, s2, curr);
        curr.deleteCharAt(curr.length()-1);
        return memo[index] = left+right;
    }

    //horse ros
    //rs

}
