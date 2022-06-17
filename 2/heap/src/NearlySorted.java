import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {
    public static void main(String[] args) {

        int[] arr = {};
        int k = 3;

        // element is 3 steps away (max) from it's original position.
        //so maintaining a heap with 3 elements will fetch the correct order that we want. (Onlogk)

    }

    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        ArrayList<Integer> resultList = new ArrayList<>();

        // Comparator<Integer> descComp = (i1,i2) -> Integer.compare(i2,i1);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int i : arr) {
            heap.add(i);
            if (heap.size() > k) {
                resultList.add(heap.poll());
            }
        }
        while (!heap.isEmpty()) {
            resultList.add(heap.poll());
        }
        return resultList;
    }
}
