package heap;

import java.util.*;

public class MedianStream {

    PriorityQueue<Integer> smallMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> largeMinHeap = new PriorityQueue<>();

    public MedianStream() {

    }

    public void addNum(int num) {

        if (!largeMinHeap.isEmpty() && num > largeMinHeap.peek()){
            largeMinHeap.add(num);
        }
        else{
            smallMaxHeap.add(num);
        }

        balanceHeaps();

    }

    private void balanceHeaps() {
        if (smallMaxHeap.size() > largeMinHeap.size() + 1) {
            largeMinHeap.add(smallMaxHeap.poll());
        } else if (largeMinHeap.size() > smallMaxHeap.size() + 1) {
            smallMaxHeap.add(largeMinHeap.poll());
        }
    }

    public double findMedian() {
        if (largeMinHeap.size() > smallMaxHeap.size()) {
            return (double) largeMinHeap.peek();
        } else if (smallMaxHeap.size() > largeMinHeap.size()) {
            return (double) smallMaxHeap.peek();
        } else {
            return ((double) largeMinHeap.peek() + (double) smallMaxHeap.peek()) / 2.0;
        }
    }


    public static void main(String[] args) {

        MedianStream medianStream = new MedianStream();

        medianStream.addNum(2);
        System.out.println(medianStream.findMedian());

        medianStream.addNum(3);
        System.out.println(medianStream.findMedian());

        medianStream.addNum(4);
        System.out.println(medianStream.findMedian());

        medianStream.addNum(7);
        System.out.println(medianStream.findMedian());

        medianStream.addNum(6);//2 3 4 6 7
        System.out.println(medianStream.findMedian());

        medianStream.addNum(8);//2 3 4 6 7 8
        System.out.println(medianStream.findMedian());

        medianStream.addNum(9);//2 3 4 6 7 8 9
        System.out.println(medianStream.findMedian());

        medianStream.addNum(1);//1 2 3 4 6 7 8
        System.out.println(medianStream.findMedian());

    }

    private void queue() {

        largeMinHeap.add(1);
        largeMinHeap.add(4);
        largeMinHeap.add(10);


    }

}
