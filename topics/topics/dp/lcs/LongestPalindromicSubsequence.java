package dp.lcs;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s1 = "aebcbda";
        LongestPalindromicSubsequence pallindromicSubsequence = new LongestPalindromicSubsequence();
        System.out.println(pallindromicSubsequence.calculate(s1));
    }

    public String calculate(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);

        PrintLCS lcs = new PrintLCS();
        return lcs.topDown(s1, s2);
    }

}
