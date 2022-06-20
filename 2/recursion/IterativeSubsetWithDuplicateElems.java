package recursion;

import java.util.ArrayList;

public class IterativeSubsetWithDuplicateElems extends Utility {

    public static void main(String[] args) {

        int[] arr = {2, 2, 2, 2};

        ArrayList<ArrayList<Integer>> subsets = subsets(arr);
        print(subsets);
    }

    private static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            int n = outer.size();

            if (i != 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;

            for (int j = start; j < n; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }


}
