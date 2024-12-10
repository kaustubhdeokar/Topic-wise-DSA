package twopointer;

import java.util.HashMap;

public class SpecialStringLen {
    public static void main(String[] args) {
        SpecialStringLen specialStringLen = new SpecialStringLen();
        System.out.println(specialStringLen.maximumLength("abcaba"));
        System.out.println(specialStringLen.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
    }

    public int maximumLength(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        int largestLen = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder();
            int[] chars = new int[26];
            int count = 1;
            for (int j = i; j < s.length(); j++) {
                int curr = s.charAt(j) - 'a';
                str.append(s.charAt(j));
                chars[curr] += 1;
                if (chars[curr] == count) {
                    count += 1;
                    map.merge(str.toString(), 1, Integer::sum);
                    int occurence = map.get(str.toString());
                    if (occurence >= 3) {
                        largestLen = Math.max(largestLen, str.toString().length());
                    }
                } else {
                    //a [1] //b [1 1] -> not special break
                    break; //not special.
                }
            }
        }

        if (largestLen == 0) return -1;
        return largestLen;

    }
}