package array.problems;

public class LeetcodePOD {

    public static void main(String[] args) {

        LeetcodePOD pod = new LeetcodePOD();
        System.out.println(pod.getLucky("leetcode", 2));

    }

    public int getLucky(String s, int k) {
        StringBuilder sumStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int alphabetIdx = (int) curr - 'a' + 1;
            sumStr.append(alphabetIdx);
        }
        int curr = 0;
        while (k > 0) {
            curr = 0;
            String currStr = sumStr.toString();
            for (int i = 0; i < currStr.length(); i++) {
                curr += (int) currStr.charAt(i) - '0';
            }
            sumStr.delete(0, sumStr.length());
            sumStr.append(curr);
            k -= 1;
        }
        return curr;
    }
}
