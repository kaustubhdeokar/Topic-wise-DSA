package slidingwindow;

public class ConsecutiveOnesIII {

    public static void main(String[] args) {
        ConsecutiveOnesIII co = new ConsecutiveOnesIII();
        String s = "101011";
        int r = co.maxLengthOfOnes(s, 2);
        System.out.println(r);
    }


    public int maxLengthOfOnes(String s, int k) {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int zeroCount = 0;
        int maxString = 0;
        while (i < sLen) {
            char curr = s.charAt(i);
            if (curr == '1') {
                i += 1;
            } else if (zeroCount < k) {
                zeroCount += 1;
                i += 1;
            } else {
                maxString = Math.max(i - j, maxString);
                zeroCount += 1;
                while (zeroCount > k) {
                    curr = s.charAt(j);
                    if (curr == '0') {
                        zeroCount -= 1;
                    }
                    j += 1;
                }
                i+=1;
            }
        }

        maxString = Math.max(i - j, maxString);

        return maxString;

    }
}
