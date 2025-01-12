package dp.lcs;

public class E_MinimumInsertionsForPallindrome {
    public static void main(String[] args) {
        String str = "abcaa";
        E_MinimumInsertionsForPallindrome minInsert = new E_MinimumInsertionsForPallindrome();
        minInsert.calculate(str);
    }

    private void calculate(String str) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        String answer = longestPalindromicSubsequence.calculate(new StringBuilder(str).reverse().toString());
        System.out.println(answer);
        //whatever is not a part of the str, will be the number of additions
        System.out.println(str.length() - answer.length());
    }
    /*
        0 1 2 3 4 5 6 7
        l e e t c o d e
        longest common palindromic substring =
        1 2 7
        e e e

        so maintaining that - we form

        0 1 n n n n 2 3 4 5 6 7 n
        l e d o c t e t c o d e l

        n are all the new insertions.

    */

}
