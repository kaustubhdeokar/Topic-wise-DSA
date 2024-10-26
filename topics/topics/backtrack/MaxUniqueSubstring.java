package backtrack;

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSubstring {

    public static void main(String[] args) {

        String s = "abacc";
        Set<String> strings = new HashSet<>();
        System.out.println(maximumUniqueStrings(s, 0, strings));

    }

    private static int maximumUniqueStrings(String s, int start, Set<String> strings) {

        if (start == s.length()) return 0;

        int max = 0;

        for (int end = start + 1; end <= s.length(); end++) {

            String substring = s.substring(start, end);

            if (!strings.contains(substring)) {

                strings.add(substring);
                System.out.println("Substring:" + substring);
                max = Math.max(max, maximumUniqueStrings(s, end, strings) + 1);

                strings.remove(substring);
                System.out.println("remove:" + substring);
            }
        }
        return max;
    }

}
