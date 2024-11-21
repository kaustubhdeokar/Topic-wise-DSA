package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayK {

    public int shortestSubarray(int[] nums, int k) {

        ArrayDeque<long[]> q = new ArrayDeque<>();
        long currSum = 0;
        long minSubArrLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            currSum += nums[i];

            if (currSum >= k) {
                minSubArrLen = Math.min(minSubArrLen, i + 1); // total upto now.
            }
            // if removing the elements from first can give us a higher total sum, remove..
            if(!q.isEmpty() && (currSum - q.getFirst()[0] >= k)){
                minSubArrLen = Math.min(minSubArrLen, i - q.getFirst()[1]); // removing the first element (hence +1 not added).
            }

            if(!q.isEmpty() && q.getLast()[0] >= currSum){
                q.removeLast();
            }

            q.add(new long[]{currSum, i});
        }

        return minSubArrLen == Integer.MAX_VALUE ? -1 : (int) minSubArrLen;
    }

    class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        ShortestSubarrayK subarr = new ShortestSubarrayK();
        int[] nums = {-28, 81, -20, 28, -29};
        int k = 89;
        int len = subarr.shortestSubarray(nums, k);
        System.out.println("len:" + len);
    }

}
