package binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestIdx {

    public static void main(String[] args) {

        NearestIdx ne = new NearestIdx();
        int[] arr = {13, 13, 10, 6, 5, 2, 6, 6, 1, 1, 18, 18, 6};
        int[] que = {10, 6, 1, 5, 7};
        List<Integer> res = ne.find(arr, que);
        System.out.println(res);
    }

    private List<Integer> find(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> mapNumToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!mapNumToIndex.containsKey(num)) {
                mapNumToIndex.put(num, new ArrayList<>());
            }
            mapNumToIndex.get(num).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int q = 0; q < queries.length; q++) {
            int query = queries[q];
            int num = nums[query];
            List<Integer> indexes = mapNumToIndex.get(num);
            if (indexes.size() == 1) res.add(-1);
            else {
                //1->(10,11)
                //query = 0
                //to find query index by binary search.
                int start = 0;
                int end = indexes.size()-1;
                int mid = 0;
                while (start <= end) {
                    mid = start + (end - start) / 2;
                    int elem = indexes.get(mid);
                    if (elem == query) break;
                    else if (elem > query) end = mid - 1;
                    else start = mid + 1;
                }

                int prevDist;
                int nextDist;
                // 1 5 l=7
                if (mid == 0) { // 7-5 + 1
                    prevDist = nums.length - indexes.get(indexes.size() - 1) + indexes.get(0);
                } else {
                    prevDist = indexes.get(mid) - indexes.get(mid - 1);
                }


                if (mid == indexes.size() - 1) {
                    nextDist = nums.length - indexes.get(indexes.size() - 1) + indexes.get(0);
                } else {
                    nextDist = indexes.get(mid + 1) - indexes.get(mid);
                }

                res.add(Integer.min(prevDist, nextDist));

            }
        }

        return res;

    }

}
