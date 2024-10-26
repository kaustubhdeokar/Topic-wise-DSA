package dp.strings;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfAString {

    public boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[26];
        int length = 0;
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a'] += 1;
            length += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (chars[s2.charAt(i) - 'a'] > 0) {
                if (calculateIfInclusionPossible(chars, s1, s2, i, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean calculateIfInclusionPossible(int[] chars, String s1, String s2, int index, int length) {
        List<Integer> indexesTraversed = new ArrayList<>();
        int end = index + length;
        int target = 0;
        while (index < end && index < s2.length()) {
            int curr = s2.charAt(index) - 'a';
            if (chars[curr] > 0) {
                chars[curr] -= 1;
                indexesTraversed.add(curr);
                index += 1;
                target += 1;
            } else {
                break;
            }
        }
        for (int i : indexesTraversed) {
            chars[i] += 1;
        }
        if (target == length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        String s1 = "ab", s2 = "eidbaooo";
        PermutationOfAString permutationOfAString = new PermutationOfAString();
        boolean ans = permutationOfAString.checkInclusion(s1, s2);
        System.out.println(ans);

    }
}
