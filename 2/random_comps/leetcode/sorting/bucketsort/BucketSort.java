package sorting.bucketsort;

//https://leetcode.com/problems/top-k-frequent-elements/submissions/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSort {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 2, 3};
        HashMap<Integer, Integer> mapNumToCount = new HashMap<>(); //map with frequency.
        for (int i : arr) {
            mapNumToCount.putIfAbsent(i, 0);
            mapNumToCount.computeIfPresent(i, (key, val) -> val +1);
        }

        ArrayList<Integer>[] bucket = new ArrayList[arr.length + 1];
        //buckets per frequency.
        //frequency 3->(1,2)
        //frequency 1->(3)

        for (Map.Entry<Integer, Integer> entry : mapNumToCount.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        int k = 2;//2 most frequent elements.
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            ArrayList<Integer> integers = bucket[i];

            if (k == 0)
                break;

            for (int j : integers) {
                resultList.add(j);
                k -= 1;
                if (k == 0)
                    break;
            }
        }
        System.out.println(resultList);
    }

}
