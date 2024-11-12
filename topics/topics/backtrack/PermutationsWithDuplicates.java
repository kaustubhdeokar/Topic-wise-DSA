package backtrack;

import java.util.*;

public class PermutationsWithDuplicates {

    // Driver method
    public static void main(String[] args) {

        Set<List<Integer>> setOfPermutations = new HashSet<>();
        int[] nums = new int[]{1,1,2,2};

        for(int i=0;i<nums.length;i++) {
            int curr = nums[i];
            int setSize = setOfPermutations.size();
            if (setSize == 0) {
                //inserting first element
                List<Integer> list = new ArrayList<>();
                list.add(curr);
                setOfPermutations.add(list);
            } else {
                Set<List<Integer>> newSet = new HashSet<>();
                Iterator<List<Integer>> iterator = setOfPermutations.iterator();
                while (iterator.hasNext()) {
                    List<Integer> currSet = iterator.next();
                    int currSetSize = currSet.size();
                    for (int innerSetSize = 0; innerSetSize <= currSetSize; innerSetSize++) {
                        currSet.add(innerSetSize, curr);
                    }
                    newSet.add(currSet);
                }
                setOfPermutations.clear();
                setOfPermutations.addAll(newSet);
            }
        }
        System.out.println(setOfPermutations);
    }
}
