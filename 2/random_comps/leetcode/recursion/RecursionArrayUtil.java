package recursion;

import java.util.ArrayList;

public class RecursionArrayUtil {

    public static void main(String[] args) {

        ArrayUtil arrayUtil = new ArrayUtil();
        int[] arr = {2, 3, 1, 4, 5, 5, 5, 6};
        System.out.println(arrayUtil.verifyIsSorted(arr, 0));

        ArrayList<Integer> targetIndexes = new ArrayList<>();
        arrayUtil.getTargetIndexes(arr, 5, 0, new ArrayList<>());

        for (Integer i : targetIndexes) {
            System.out.print(i + " ");
        }

        targetIndexes = arrayUtil.getTargetIndexesWithoutListAsArg(arr, 5, 0);

        for (Integer i : targetIndexes) {
            System.out.print(i + " ");
        }

    }

    public boolean verifyIsSorted(int[] arr, int index) {
        if (index == arr.length - 1)
            return true;
        return arr[index] < arr[index + 1] && verifyIsSorted(arr, index + 1);
    }

    public ArrayList<Integer> getTargetIndexes(int[] arr, int target, int index, ArrayList<Integer> ans) {
        if (index == arr.length)
            return ans;
        if (arr[index] == target)
            ans.add(index);
        return getTargetIndexes(arr, target, index + 1, ans);
    }

    public ArrayList<Integer> getTargetIndexesWithoutListAsArg(int[] arr, int target, int index) {
        if (index == arr.length)
            return new ArrayList<>();
        //beautiful
        ArrayList<Integer> targetIndexesWithoutListAsArg = getTargetIndexesWithoutListAsArg(arr, target, index + 1);
        if (arr[index] == target) {
            targetIndexesWithoutListAsArg.add(index);
        }
        return targetIndexesWithoutListAsArg;
    }


}


