package array.problems;

public class ConstructString {

    public static void main(String[] args) {
        ConstructString constructString = new ConstructString();
        String res = constructString.repeatLimitedString("aababab", 2);
        System.out.println(res);

    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] += 1;
        }
        StringBuilder str = new StringBuilder();
        int ptr = 25;
        int inputLength = 0;
        int lastActive = 25;
        while (ptr >= 0 && inputLength < s.length()) {
            while (ptr >= 0 && chars[ptr] == 0) {
                ptr -= 1;
            }
            int r1 = repeatLimit;
            if (str.length() > 0 && str.charAt(str.length() - 1) == ((char) 'a' + ptr)) {
                break;
            }
            while (ptr >= 0 && chars[ptr] > 0 && r1 > 0) {
                //  char c = (char)('a'+chars[ptr]);
                str.append((char) ('a' + ptr));
                chars[ptr] -= 1;
                r1 -= 1;
            }
            if (ptr >= 0 && chars[ptr] > 0) {
                lastActive = ptr;
                ptr -= 1;
                while (ptr >= 0 && chars[ptr] == 0) {
                    ptr -= 1;
                }
                if (ptr >= 0) {
                    str.append((char) ('a' + ptr));
                    chars[ptr] -= 1;
                }
                ptr = lastActive;
            } else {
                ptr -= 1;
            }
        }
        return str.toString();
    }
}
