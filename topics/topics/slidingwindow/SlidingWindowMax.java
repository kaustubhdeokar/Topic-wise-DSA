package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMax {


    public int[] maxSlidingWindow(int[] arr, int k) {

        //idea here is that, if the element being pushed is greater than the top element, remove the top element
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.getLast() < arr[i]) {
                queue.removeLast();
            }
            queue.add(arr[i]);
        }
        int n = arr.length;
        int[] res = new int[n - k + 1];
        res[0] = queue.getFirst();
        for (int i = 1; i < res.length; i++) {
            int inIdx = k + i - 1;
            int outIdx = i - 1;
            if (queue.getFirst() == arr[outIdx]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && arr[inIdx] > queue.getLast()) {
                queue.removeLast();
            }
            queue.add(arr[inIdx]);
            res[i] = queue.getFirst();
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        int[] answer = slidingWindowMax.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(answer));

    }

}
