package dp.knapsack;

import java.util.*;

//https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
public class PartitionArrSoDiffIsMin {


    public static void main(String[] args) {
        PartitionArrSoDiffIsMin partition = new PartitionArrSoDiffIsMin();
        int[] arr = {1, 5, 3, 7, 9, 4};
        partition.createSumMappings(arr);
    }

    private void createSumMappings(int[] arr) {
        /*
        HashMap Left =
        {
        1: [1,5,3]
        2: [(1 + 5) = 6, (1 + 3) = 4, (5 + 3) = 8]
        3: [9]
        }
        HashMap right =
        {
        1: [7,9,4]
        2: [(7 + 9) = 16, (7 + 4) = 11, (9 + 4) = 13]
        3: [20]
        }
        */

        int arrLen = arr.length;
        Map<Integer, List<Integer>> mapAmountOfNumsToTheirSum1 = new HashMap<>();
        createMappings(mapAmountOfNumsToTheirSum1, arr, 0);
        Map<Integer, List<Integer>> mapAmountOfNumsToTheirSum2 = new HashMap<>();
        createMappings(mapAmountOfNumsToTheirSum2, arr, arrLen / 2);
        int arrSum = Arrays.stream(arr).sum();
        System.out.println("Sum:" + arrSum);

        int minDiff = Integer.MAX_VALUE;
        int midLen = arrLen / 2;
        for (int i = 0; i <= midLen; i++) {
            List<Integer> list1 = mapAmountOfNumsToTheirSum1.get(i);
            Collections.sort(list1);
            List<Integer> list2 = mapAmountOfNumsToTheirSum2.get(midLen - i);
            Collections.sort(list2);

            int l1Ptr = 0;
            int l2Ptr = list2.size() - 1;
            while (l1Ptr < list1.size() && l2Ptr >= 0) {
                int partition1 = list1.get(l1Ptr) + list2.get(l2Ptr);
                int partition2 = arrSum - partition1;
                minDiff = Integer.min(minDiff, Math.abs(partition1 - partition2));

                if (partition1 > arrSum / 2) {
                    l2Ptr -= 1;
                } else {
                    l1Ptr += 1;
                }
            }

        }

        System.out.println(minDiff);

    }

    private void createMappings(Map<Integer, List<Integer>> mapAmountOfNumsToTheirSum, int[] arr, int offset) {
        int mid = arr.length / 2;
        int range = arr.length / 2;
        range = (int) Math.pow(2, range) - 1;
        for (int i = 0; i <= range; i++) {
            String binStr = Integer.toBinaryString(i);

            int number = 0;
            int setBits = 0;
            for (int j = 0; j < binStr.length(); j++) {
                int mapChar = offset + mid - j - 1;
                if (binStr.charAt(j) == '1') {
                    number += arr[mapChar];
                    setBits += 1;
                }
            }
            if (mapAmountOfNumsToTheirSum.get(setBits) == null)
                mapAmountOfNumsToTheirSum.put(setBits, new ArrayList<>());
            mapAmountOfNumsToTheirSum.get(setBits).add(number);
        }
        System.out.println(mapAmountOfNumsToTheirSum);
    }


}
