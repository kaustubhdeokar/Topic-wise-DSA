package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumMultiplicationToEnd {

    public static void main(String[] args) {

        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;

        arr = new int[]{3, 4, 65};
        start = 7;
        end = 66175;

        MinimumMultiplicationToEnd min = new MinimumMultiplicationToEnd();
        Set<Integer> divisors = min.calculateDivisors(end);
        System.out.println(divisors);
        int r = min.calculateMultipleHopsToEnd(arr, start, end, divisors);
        System.out.println(r);


    }

    private Set<Integer> calculateDivisors(int end) {
        Set<Integer> divisors = new HashSet<>();
        int to = (int) Math.ceil(Math.sqrt(end));
        for (int i = 1; i <= to; i++) {
            if (end % i == 0) {
                divisors.add(end / i);
                divisors.add(i);
            }
        }
        return divisors;
    }

    private class NumberToHops {
        int num;
        int hops;

        public NumberToHops(int num, int hops) {
            this.num = num;
            this.hops = hops;
        }
    }

    private int calculateMultipleHopsToEnd(int[] arr, int start, int end, Set<Integer> divisors) {
        //start -> 3
        //arr of multiplicands.
        //multiply the start, with each of the multiplicands.
        //if the answer lies in divisors, we add it to the queue, with hops = hops+1
        //we should store the number and hops until here.

        Queue<NumberToHops> q = new LinkedList<>();
        q.add(new NumberToHops(start, 0));
        while (!q.isEmpty()) {
            NumberToHops qElem = q.remove();
            int elem = qElem.num;
            int hops = qElem.hops;
            if (elem == end) return hops;

            for (int j = 0; j < arr.length; j++) {
                int num = elem * arr[j] % 100000;
                q.add(new NumberToHops(num, hops + 1));
            }
        }
        return -1;
    }


}
