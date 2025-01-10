package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticFlow {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> visited = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            List<Integer> inner = new ArrayList<>(arr[0].length);
            for(int j=0;j<arr[0].length;j++){
                inner.add(0);
            }
            visited.add(inner);
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < arr[0].length; i++) {
            q.add(new int[]{0, i});
        }
        for (int i = 0; i < arr.length; i++) {
            q.add(new int[]{i, 0});
        }
        pacificToAtlantic(arr, visited, q, 1);


        for (int i = 0; i < arr.length; i++) {
            q.add(new int[]{i, arr[0].length - 1});
        }

        for (int i = 0; i < arr[0].length; i++) {
            q.add(new int[]{arr.length - 1, i});
        }

        pacificToAtlantic(arr, visited, q, 2);


        for (int i = 0; i < visited.size(); i++) {
            for (int j = 0; j < visited.get(i).size(); j++) {
                System.out.print(visited.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    private static void pacificToAtlantic(int[][] arr, List<List<Integer>> visited, ArrayDeque<int[]> q, int ocean) {
        int topi, topj;
        while (!q.isEmpty()) {
            int[] top = q.remove();
            int i = top[0], j = top[1];
            System.out.println("i:" + i + " j:" + j);
            if (visited.get(i).get(j) != ocean && visited.get(i).get(j) != 3) {
                visited.get(i).set(j, visited.get(i).get(j) + ocean);

                topi = i + 1;
                topj = j;
                if (valid(topi, topj, arr.length, arr[0].length) && arr[topi][topj] >= arr[i][j]) {
                    q.add(new int[]{topi, topj});
                }

                topi = i - 1;
                topj = j;
                if (valid(topi, topj, arr.length, arr[0].length) && arr[topi][topj] >= arr[i][j]) {
                    q.add(new int[]{topi, topj});
                }

                topi = i;
                topj = j + 1;
                if (valid(topi, topj, arr.length, arr[0].length) && arr[topi][topj] >= arr[i][j]) {
                    q.add(new int[]{topi, topj});
                }

                topi = i;
                topj = j - 1;
                if (valid(topi, topj, arr.length, arr[0].length) && arr[topi][topj] >= arr[i][j]) {
                    q.add(new int[]{topi, topj});
                }

            }
        }
    }

    public static boolean valid(int i, int j, int r, int c) {
        return i >= 0 && j >= 0 && i < r && j < c;
    }
}
