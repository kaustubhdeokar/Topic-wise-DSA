package recursion;

import java.util.ArrayList;

public class IterativeSubset extends Utility {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        ArrayList<ArrayList<Integer>> subsets = subsets(arr);
        print(subsets);

    }

    private static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i : arr) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(i);
                outer.add(inner);
            }
        }
        return outer;
    }


}
