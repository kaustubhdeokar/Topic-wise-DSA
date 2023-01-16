import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {
    public static void main(String[] args) {

        int[] arr = new int[]{6,5,3,2,8,10,9};
        int k = 3;
        ArrayList<Integer> result = nearlySorted(arr, k);
        for(Integer res: result){
            System.out.print(res+" ");
        }
        // element is 3 steps away (max) from it's original position.
        //so maintaining a heap with 3 elements will fetch the correct order that we want. (Onlogk)

    }

    public static ArrayList<Integer> nearlySorted(int arr[], int k) {
        ArrayList<Integer> resultList = new ArrayList<>();

        // priority queue by default min heap. 
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k+1);

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
