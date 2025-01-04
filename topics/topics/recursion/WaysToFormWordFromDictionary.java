package recursion;

public class WaysToFormWordFromDictionary {


    public static void main(String[] args) {

        String[] words = {"daa", "bcc", "bbd"};
        String target = "ba";

        WaysToFormWordFromDictionary ways = new WaysToFormWordFromDictionary();
        System.out.println(ways.numWays(words, target));

    }

    public int numWays(String[] words, String target) {

        int wi = 0; // index for words.
        StringBuilder curr = new StringBuilder();
        int ti = 0; // index for target

        return findWays(words, wi, target, ti, curr);

    }

    public int findWays(String[] words, int wi, String target, int ti, StringBuilder curr) {
        if (curr.toString().equals(target)) {
            System.out.println(curr);
            return 1;
        }
        if (wi >= words[0].length()) return 0;
        int ans = 0;
        for (int word = 0; word < words.length; word++) {
            if (words[word].charAt(wi) == target.charAt(ti)) {
                curr.append(words[word].charAt(wi));
                ans += findWays(words, wi + 1, target, ti + 1, curr);
                curr.deleteCharAt(curr.length() - 1);
                ans += findWays(words, wi + 1, target, ti, curr);
            } else {
                ans += findWays(words, wi + 1, target, ti, curr);
            }
        }
        return ans;
    }

}
