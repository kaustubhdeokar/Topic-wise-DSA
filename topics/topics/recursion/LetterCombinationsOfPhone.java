package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhone {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> combos = new ArrayList<>();
        backtrack(map, combos, new StringBuilder(), 0, digits);
        return combos;
    }

    public void backtrack(HashMap<Character, String> map, List<String> combos, StringBuilder sb, int idx, String digits) {
        if (sb.length() == digits.length()) {
            combos.add(sb.toString());
            return;
        }
        if (idx >= digits.length()) return;
        String digit = map.get(digits.charAt(idx));
        for (char c : digit.toCharArray()) {
            sb.append(c);
            backtrack(map, combos, sb, idx + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhone lc = new LetterCombinationsOfPhone();
        System.out.println(lc.letterCombinations("234"));
    }
}
