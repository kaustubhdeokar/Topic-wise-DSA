import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElem {

    public static void main(String[] args) {

        Comparator<Integer> comparator = (i1,i2) -> Integer.compare(i2,i1);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        int k =3;
        int arr[] = {7, 10, 4, 3, 20, 15};
        for (int i : arr) {
            priorityQueue.add(i);
            if (priorityQueue.size() > k) {
                System.out.println("removed:" + priorityQueue.poll());
            }
        }
        System.out.println(priorityQueue.poll());
    }

}
