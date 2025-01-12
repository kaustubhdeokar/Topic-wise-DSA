package dp.lcs;

public class MinimumDeletionForPallindrome {

    public static void main(String[] args) {

        String s1 = "agbcba";
        MinimumDeletionForPallindrome minimumDeletionForPallindrome = new MinimumDeletionForPallindrome();
        String pallindrome = minimumDeletionForPallindrome.calculatePallindrome(s1);
        System.out.println("pallindrome:"+pallindrome);
        minimumDeletionForPallindrome.calculate(s1, pallindrome);
    }

    private void calculate(String s1, String pallindrome) {
        int sitr = 0;
        int pallindromeitr = 0;
        StringBuilder result = new StringBuilder();
        while (pallindromeitr < pallindrome.length() && sitr < s1.length()) {
            if(pallindrome.charAt(pallindromeitr)==s1.charAt(sitr)){
                result.append(pallindrome.charAt(pallindromeitr));
                pallindromeitr+=1;
                sitr+=1;
            }
            else{
                System.out.println("delete:"+s1.charAt(sitr));
                sitr+=1;
            }
        }
        while(sitr<s1.length()){
            System.out.println("delete:"+s1.charAt(sitr));
            sitr+=1;
        }
    }

    private String calculatePallindrome(String s1) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        return longestPalindromicSubsequence.calculate(s1);
    }

}
