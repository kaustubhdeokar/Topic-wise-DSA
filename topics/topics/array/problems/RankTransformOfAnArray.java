package array.problems;

import java.util.*;

public class RankTransformOfAnArray {

    class MapValToIndex {
        int val;
        int index;

        MapValToIndex(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "MapValToIndex{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) {

        RankTransformOfAnArray rank = new RankTransformOfAnArray();
        int[] arr = new int[]{40, 10, 10, 30};
        int[] result = rank.rankTransform(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private int[] rankTransform(int[] arr) {
        List<MapValToIndex> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new MapValToIndex(arr[i], i));
        }

        list.sort((c1, c2) -> Integer.compare(c1.val, c2.val));
        int[] rank = new int[arr.length];
        int r = 1;
        int prevVal = list.get(0).val - 1;

        for (MapValToIndex mapValToIndex : list) {
            int index = mapValToIndex.index;
            int val = mapValToIndex.val;
            if (val == prevVal) {
                r -= 1;
            }
            rank[index] = r;
            prevVal = val;
            r += 1;
        }

        return rank;

    }

}
