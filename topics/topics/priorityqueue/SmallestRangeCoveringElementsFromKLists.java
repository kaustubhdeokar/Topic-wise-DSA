package priorityqueue;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {

    public static void main(String[] args) {

        int[][] nums = {{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        List<List<Integer>> list = new ArrayList<>();

        for (int[] subArray : nums) {
            List<Integer> subList = new ArrayList<>();
            for (int num : subArray) {
                subList.add(num);
            }
            list.add(subList);
        }
         SmallestRangeCoveringElementsFromKLists small = new SmallestRangeCoveringElementsFromKLists();
        int[] answer = small.smallestRange(list);
        System.out.println(Arrays.toString(answer));

    }

    public int[] smallestRange(List<List<Integer>> nums) {
        // priority queue <integer:integer>  size = (nums.length)
        // int[] ptr = new int[nums.length];
        // at each step until end of any one list is reached
        // put into queue.
        // calculate range - update range min.
        // remove the least element and add element from same list to the queue.

        Comparator<int[]> comp = (c1, c2) -> Integer.compare(c1[0],c2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        int[] ptrs = new int[nums.size()];

        int max = -1;
        for(int i=0;i<nums.size();i++){
            int num = nums.get(i).get(ptrs[i]++);
            max = Integer.max(max, num);
            pq.add(new int[]{num,i});
        }

        int startRange = -1;
        int endRange = 100001;
        while(!pq.isEmpty()){

            int[] ni = pq.poll();
            int min = ni[0];
            int index = ni[1];

            if((max-min)<(endRange-startRange)){
                startRange = min;
                endRange = max;
            }
            if(ptrs[index]>=nums.get(index).size()){
                break;
            }
            else{
                int num = nums.get(index).get(ptrs[index]++);
                max = Integer.max(max, num);
                //System.out.println("adding:"+num+":"+index);
                pq.add(new int[]{num, index});
            }
        }


        return new int[]{startRange,endRange};
    }

}
