package LongestConsecutiveSeq;
import java.util.HashSet;
public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }

        int maxCount = 0;
        int count = 0;

        HashSet<Integer> calculatedSeq = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            count = 1;
            boolean containsPlusOne = set.contains(curr+1);
            boolean containsMinusOne = set.contains(curr-1);

            if(!calculatedSeq.contains(nums[i])){

                if(!(containsPlusOne && containsMinusOne) && (containsPlusOne || containsMinusOne)){

                    System.out.println("num:"+curr);
                    int incrCurr = curr;
                    int decrCurr = curr;

                    while(set.contains(incrCurr+1)){
                        incrCurr = incrCurr+1;
                        calculatedSeq.add(incrCurr);
                        count+=1;
                    }

                    while(set.contains(decrCurr-1)){
                        decrCurr = decrCurr - 1;
                        calculatedSeq.add(decrCurr);
                        count+=1;
                    }

                }

            }
            calculatedSeq.add(nums[i]);
            maxCount = Integer.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {



    }

}
