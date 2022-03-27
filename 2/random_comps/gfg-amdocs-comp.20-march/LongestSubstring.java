import java.util.ArrayList;

public class LongestSubstring {


    public int lengthOfLongestSubstring(String s, int n) {

        int maxLen = 0;

        ArrayList<String> substr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((i + j) % 2 == 0)
                    substr.add(s.substring(i, j));
            }
        }

        for (String s1 : substr) {

            int leftSum = 0;
            int rightSum = 0;
            int len = s1.length();

            for (int i = 0; i < s1.length() / 2; i++) {
                leftSum += (int) s1.charAt(i);
            }
            for (int i = s1.length() / 2; i < s1.length(); i++)
                rightSum += (int) s1.charAt(i);


            if (leftSum == rightSum && len > maxLen)
                maxLen = len;

        }

        return maxLen;
    }


    public static void main(String[] args) {

        LongestSubstring substring = new LongestSubstring();
        int count = substring.lengthOfLongestSubstring("014552375", 7);
        System.out.print(count);

    }

}
