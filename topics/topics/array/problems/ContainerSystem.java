package array.problems;

import java.util.*;

public class ContainerSystem {

    public static void main(String[] args) {
        ContainerSystem containerSystem = new ContainerSystem();
        containerSystem.designSystem();
    }

    private void designSystem() {

        Map<Integer, Integer> indexToNum = new HashMap<>();
        Map<Integer, SortedSet<Integer>> numberToIndexes = new HashMap<>();


        int[][] inputs = {{25, 50}, {56, 31}, {50}, {50}, {43}, {30, 50}, {31}, {43}, {25, 20}, {50}, {56, 43}, {68, 31}, {56, 31}, {20}, {43}, {25, 43}, {43}, {56, 31}, {54, 43}, {63, 43}};
        for (int[] input : inputs) {
            if (input.length == 2) {
                int index = input[0];
                int currNum = input[1];
                if (indexToNum.containsKey(index)) {
                    int earlierNum = indexToNum.get(index);
                    numberToIndexes.get(earlierNum).remove(index);
                }
                if (!numberToIndexes.containsKey(currNum)) numberToIndexes.put(currNum, new TreeSet<>());
                numberToIndexes.get(currNum).add(index);
                indexToNum.put(index, currNum);
            } else {
                if (numberToIndexes.get(input[0]) == null || numberToIndexes.get(input[0]).isEmpty()) System.out.println(-1);
                else System.out.println(numberToIndexes.get(input[0]).first());
            }
        }

    }

}
