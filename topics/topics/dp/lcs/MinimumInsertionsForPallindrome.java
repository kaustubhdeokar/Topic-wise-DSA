package dp.lcs;

public class MinimumInsertionsForPallindrome {
    public static void main(String[] args) {
        String str = "abcaa";
        MinimumInsertionsForPallindrome minInsert = new MinimumInsertionsForPallindrome();
        minInsert.calculate(str);
    }

    private void calculate(String str) {
        LongestPallindromicSubsequence longestPallindromicSubsequence = new LongestPallindromicSubsequence();
        String answer = longestPallindromicSubsequence.calculate(new StringBuilder(str).reverse().toString());
        System.out.println(answer);

        //whatever is not a part of the str, will be the number of additions
        System.out.println(str.length() - answer.length());
    }

}
