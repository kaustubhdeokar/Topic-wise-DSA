package array.sorting;

import java.util.*;

public class AliceAndBobMeet {
    public static void main(String[] args) {
        int[] heights = {6, 4, 8, 5, 2, 7};
        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        AliceAndBobMeet aliceAndBobMeet = new AliceAndBobMeet();
        int[] res = aliceAndBobMeet.leftmostBuildingQueries(heights, queries);
        for (int r : res) {
            System.out.print(r + " ");
        }
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

        Map<Integer, List<int[]>> endingAtIndex = new HashMap<>();
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        for (int index = 0; index < queries.length; index++) {
            int[] query = queries[index];
            Arrays.sort(query);
            int startIdx = query[0];
            int endIdx = query[1];

            int max = Integer.max(heights[startIdx], heights[endIdx]);
            if (startIdx == endIdx) {
                result[index] = startIdx;
            } else if (max == heights[endIdx] && heights[startIdx] < heights[endIdx]) {
                result[index] = endIdx;
            } else {
                int[] maxIndex = new int[]{max, index};
                if (endingAtIndex.get(endIdx) == null) {
                    List<int[]> list = new ArrayList<>();
                    endingAtIndex.put(endIdx, list);
                }
                endingAtIndex.get(endIdx).add(maxIndex);
            }
        }

        System.out.println(endingAtIndex);

        Comparator<int[]> comp = (c1, c2) -> Integer.compare(c1[0], c2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>(comp);

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            if (endingAtIndex.get(i) != null) {
                for (int[] endingAt : endingAtIndex.get(i)) {
                    q.add(endingAt);
                }

            }

            while (!q.isEmpty() && q.peek()[0] < height) {
                int[] top = q.remove();
                result[top[1]] = i;
            }

        }

        return result;


    }
//
//    public int[] leftmostBuildingQueriesKindaN2Sol(int[] heights, int[][] queries) {
//
//        Map<Integer, List<List<Integer>>> endingAtIndex = new HashMap<>();
//        int[] result = new int[queries.length];
//        Arrays.fill(result, -1);
//
//        for (int q = 0; q < queries.length; q++) {
//            int[] query = queries[q];
//            Arrays.sort(query);
//            int startIdx = query[0];
//            int endIdx = query[1];
//
//            int max = Integer.max(heights[startIdx], heights[endIdx]);
//            if (max == heights[endIdx]) {
//                result[q] = endIdx;
//            } else {
//                List<Integer> startIdxMaxQuery = List.of(max, q);
//                if (endingAtIndex.get(endIdx) == null) {
//                    List<List<Integer>> list = new ArrayList<>();
//                    endingAtIndex.put(endIdx, list);
//                }
//                endingAtIndex.get(endIdx).add(startIdxMaxQuery);
//            }
//        }
//
//        Stack<int[]> stack = new Stack<>();
//        for (int i = heights.length - 1; i >= 0; i--) {
//            System.out.println("i:" + i);
//            while (!stack.isEmpty() && stack.peek()[0] < heights[i]) {
//                stack.pop();
//            }
//            stack.push(new int[]{heights[i], i});
//            System.out.println("stack:" + stack);
//            List<List<Integer>> list = endingAtIndex.get(i);
//            if (list != null) {
//                for (List<Integer> l : list) {
//                    int max = l.get(0);
//                    int idx = l.get(1);
//
//                    for (int j = stack.size() - 1; j >= 0; j--) {
//                        int[] itr = stack.get(j);
//                        if (itr[0] > max) {
//                            result[idx] = itr[1];
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        return result;
//
//
//    }
}
