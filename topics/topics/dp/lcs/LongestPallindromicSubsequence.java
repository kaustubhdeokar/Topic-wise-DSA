package dp.lcs;

import java.util.Collections;

public class LongestPallindromicSubsequence {

    public static void main(String[] args) {

        String s1 = "agbcba";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            stringBuilder.append(s1.charAt(i));
        }
        String s2 = stringBuilder.toString();
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);

    }

    private void lcs(String s1, String s2){


    }

}
