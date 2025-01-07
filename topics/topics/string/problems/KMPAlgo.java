package string.problems;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgo {

    public static void main(String[] args) {

        KMPAlgo algo = new KMPAlgo();

//        String pattern = "ababaa";
        String pattern = "aaba";
         int[] lps = algo.prepareLps(pattern);
        for (int l : lps) {
            System.out.print(l + " ");
        }
        String txt = "aabaacaadaabaaba";
        System.out.println(algo.findMatches(txt, pattern, lps));
    }

    private List<Integer> findMatches(String txt, String pattern, int[] lps) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < txt.length()) {
            if (txt.charAt(i) == pattern.charAt(j)) {
                i += 1;
                j += 1;
                if (j == pattern.length()) {
                    result.add(i - pattern.length());
                    j = lps[j - 1];
                }
            } else {
                if (j == 0) i += 1;
                else {
                    j = lps[j - 1];
                }
            }
        }
        return result;
    }

    private int[] prepareLps(String pattern) {

        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int i = 0;
        int j = 1;
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i + 1;
                i += 1;
                j += 1;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j += 1;
                } else {
                    i = lps[i - 1];
                }
            }
        }

        return lps;
    }

}
