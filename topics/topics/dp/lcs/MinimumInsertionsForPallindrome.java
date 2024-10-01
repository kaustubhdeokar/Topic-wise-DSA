package dp.lcs;

public class MinimumInsertionsForPallindrome {
    public static void main(String[] args) {
        String str = "aacecaaa";
        MinimumInsertionsForPallindrome minInsert = new MinimumInsertionsForPallindrome();
        minInsert.calculate(str);
    }

    private void calculate(String str) {
        LongestPallindromicSubsequence longestPallindromicSubsequence = new LongestPallindromicSubsequence();
        String answer = longestPallindromicSubsequence.calculate(new StringBuilder(str).reverse().toString());

        int mid = answer.length() / 2;
        int start = mid;
        int end = mid;
        StringBuilder result = new StringBuilder(str.charAt(mid));
        while (start >= 0 && end < answer.length()) {
            if (str.charAt(start) == str.charAt(end)) {
                result.append(str.charAt(start));
                start -= 1;
                end += 1;
            } else {
                result.append(str.charAt(start));
                result.append(str.charAt(end));
                start -= 1;
                end += 1;
            }
        }
        while (start >= 0) {
            result.append(str.charAt(start));
            start -= 1;
        }
        while (end < answer.length()) {
            result.append(str.charAt(end));
            end += 1;
        }
        System.out.println(result);
    }

}
