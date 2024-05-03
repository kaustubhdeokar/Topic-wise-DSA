package sliding_window;

import java.util.*;
//https://leetcode.com/problems/sliding-window-maximum/submissions/880721165/
public class SlidingWindowMaximum {
    class MapNumberToIndex{
        int number;
        int index;
        MapNumberToIndex(int number, int index){
            this.number = number;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] arr, int k) {

        Comparator<MapNumberToIndex> comparator = (m1, m2) -> -1*Integer.compare(m1.number, m2.number);
        PriorityQueue<MapNumberToIndex> queue = new PriorityQueue<>(comparator);
        int[] result = new int[arr.length-k+1];
        
        for(int i=0;i<k;i++){
            queue.add(new MapNumberToIndex(arr[i],i));
        }

        int resPtr = 0;
        int start = 0;
        int end = k -1;
        result[resPtr++] = queue.peek().number;

        while (end < arr.length){
        
            end += 1;
            start += 1;
            if(end==arr.length) break;

            while(!queue.isEmpty() && start>queue.peek().index){
                queue.poll();
            }
            queue.add(new MapNumberToIndex(arr[end],end));
            result[resPtr++] = queue.peek().number;
        }

        return result;
    }
}
