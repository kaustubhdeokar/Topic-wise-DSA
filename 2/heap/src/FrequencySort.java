import java.util.*;

public class FrequencySort {
    
    public int[] frequencySort(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }
            else{
                map.put(num, 1);
            }
        }

        Comparator<Integer> comparator = (i1, i2) -> {
            int numSort = Integer.compare(map.get(i1), map.get(i2));
            if(numSort==0){
                return -1*Integer.compare(i1, i2);
            }
            return numSort;
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);

        for(int num: nums){
            queue.add(num);
        }   
        int[] ans = new int[queue.size()];
        int idx = 0;
        while(!queue.isEmpty()){
            ans[idx++] = queue.poll();
        }

        return ans;
    }

}
