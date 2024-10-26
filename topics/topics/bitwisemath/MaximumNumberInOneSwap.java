package bitwisemath;

import java.util.ArrayDeque;

public class MaximumNumberInOneSwap {

    public static void main(String[] args) {

        int num = 2736592;
        MaximumNumberInOneSwap maximumNumberInOneSwap = new MaximumNumberInOneSwap();
        ArrayDeque<Integer> numsInIncOrder = maximumNumberInOneSwap.calculate(num);

        int length = maximumNumberInOneSwap.lengthOfNumber(num);
        int power = (int) Math.ceil(Math.log10(num + 1));
        StringBuilder result = new StringBuilder();

    }

    private ArrayDeque<Integer> calculate(int num) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            Integer curr = Integer.parseInt(String.valueOf(str.charAt(i)));
            while (!q.isEmpty() && q.peekLast() < curr) {
                q.removeLast();
            }
            q.add(curr);
        }
        return q;
    }

    private int lengthOfNumber(int num) {

        return (int) Math.ceil(Math.log10(num + 1));

    }

}
