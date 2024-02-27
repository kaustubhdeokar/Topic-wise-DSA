import java.util.PriorityQueue;

public class KthLargestWithPriorityQueue {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4, 2};
        int k = 2;
        KthLargestWithPriorityQueue kth = new KthLargestWithPriorityQueue();
        System.out.println(kth.findKthLargest(nums,nums.length-k));
    }

    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}

