package array.problems;

import java.util.HashMap;
import java.util.Map;

public class MinOperations {

    public static void main(String[] args) {
        MinOperations min = new MinOperations();
        min.minimumOperations(new int[]{1,2,3,4,2,3,3,5,7});
    }
    public int minimumOperations(int[] nums) {
        //map<int, count>
        //if map.size() < nums.length (n)
        // remove first three -> n-3
        Map<Integer, Integer> numsToCount = new HashMap<>();
        int len = nums.length;
        for(int n: nums){
            numsToCount.merge(n, 1, Integer::sum);
        }
        System.out.println("map:"+numsToCount);
        int ptr = 0;
        int removals = 0;
        while(numsToCount.size() < len && ptr< len){
            for(int p = ptr;p < ptr+3; p++){
                if(p == nums.length) break;
                numsToCount.merge(nums[p],-1,Integer::sum);
                if(numsToCount.get(nums[p])==0) numsToCount.remove(nums[p]);
            }
            removals += 1;
            len -= 3;
            ptr+= 3;
            System.out.println("len:"+len);
            System.out.println("removals:"+removals);
            System.out.println("map:"+numsToCount);

        }
        return removals;

    }
}
