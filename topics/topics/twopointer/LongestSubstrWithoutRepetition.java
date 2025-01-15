package twopointer;

public class LongestSubstrWithoutRepetition {

    public static void main(String[] args) {
        LongestSubstrWithoutRepetition lsr = new LongestSubstrWithoutRepetition();
        int len = lsr.lengthOfLongestSubstring("abcabcbb");
        System.out.println("len:" + len);
    }

    public int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end = 0;
        int[] chars = new int[128];
        int maxLen = 0;

        while (end < s.length()) {

            char currChar = s.charAt(end);

            if (chars[currChar] == 0) {
                //System.out.print("unique, ");
                chars[currChar] = 1;
                //System.out.print("currChar:"+currChar);
                end += 1;
                //System.out.println(", end:"+end);
            } else {
                //System.out.print("duplicate, ");
                while (chars[s.charAt(end)] > 0) {
                    chars[s.charAt(start)] -= 1;
                    start += 1;
                    //System.out.println("start:"+start);
                }
            }
            maxLen = Integer.max(maxLen, end - start);
            //System.out.println("maxLen:"+maxLen);
        }
        return maxLen;
    }


}
