package string.problems;

//Leetcode pod 12 sep
//1684. Count the Number of Consistent Strings
public class ConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {

        boolean[] allowedChars = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            allowedChars[allowed.charAt(i) - 'a'] = true;
        }

        int result = 0;

        for (String word : words) {
            boolean match = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allowedChars[word.charAt(i) - 'a']) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ConsistentStrings consistentStrings = new ConsistentStrings();
        int result = consistentStrings.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"});
        System.out.println(result);
    }

}
