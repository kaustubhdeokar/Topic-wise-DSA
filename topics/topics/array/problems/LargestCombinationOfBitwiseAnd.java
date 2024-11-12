package array.problems;

import java.util.ArrayList;
import java.util.List;

public class LargestCombinationOfBitwiseAnd {

    public static void main(String[] args) {

        int[] candidates = new int[]{16,17,71,62,12,24,14};
        LargestCombinationOfBitwiseAnd largestCombination = new LargestCombinationOfBitwiseAnd();
        System.out.println(largestCombination.largestCombination(candidates));

    }

    public int largestCombination(int[] candidates) {

        int maxSize = 0;
        int power = 1;
        int highest = -1;

        for(int c: candidates){
            if(c>highest) highest = c;
        }

        int maxPower = 1;
        while(maxPower<highest){
            maxPower = maxPower * 2;
        }
        // System.out.println("maxPower:"+maxPower);

        while(power <= maxPower){

            List<Integer> numsWithPowers = new ArrayList<>();
            for(int c: candidates){
                if((power & c) > 0){
                    numsWithPowers.add(c);
                }

            }

            if(numsWithPowers.size()>=maxSize){
                maxSize = numsWithPowers.size();
            }
            power = power*2;
            numsWithPowers.clear();

        }

        return maxSize;

    }

}
