package backtrack;

import java.util.ArrayList;

public class NextPermutation {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 1};

        ArrayList<Integer> src = new ArrayList<>();
        for (int a : arr) src.add(a);
        src.sort((c1, c2) -> c1 - c2);
        boolean[] foundAndPopulated = new boolean[]{false, false};

        ArrayList<Integer> temp = new ArrayList<>();
        NextPermutation np = new NextPermutation();
        np.traverse(src, temp, arr, foundAndPopulated);

    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;

        // Step 1: Find the largest index k such that nums[k] < nums[k + 1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }

        // If no such index exists, the permutation is the last permutation
        if (k == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the largest index l greater than k such that nums[k] < nums[l]
        int l = -1;
        for (int i = n - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }

        // Step 3: Swap the value of nums[k] with that of nums[l]
        swap(nums, k, l);

        // Step 4: Reverse the sequence from nums[k + 1] up to and including the final element nums[n]
        reverse(nums, k + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void traverse(ArrayList<Integer> src, ArrayList<Integer> temp, int[] arr, boolean[] foundAndPopulated) {

        if (foundAndPopulated[1]) {
            return;
        }

        if (src.isEmpty()) {
            if (foundAndPopulated[0]) {
                foundAndPopulated[1] = true;
                System.out.println("foundAndPopulated:" + temp);
            } else {
                for (int i = 0; i < temp.size(); i++) {
                    if (arr[i] != temp.get(i)) {
                        return;
                    }
                }
                foundAndPopulated[0] = true;
            }
        }

        for (int i = 0; i < src.size(); i++) {
            if (i > 0 && src.get(i).equals(src.get(i - 1))) continue;
            temp.add(src.get(i));
            ArrayList<Integer> tempSrc = new ArrayList<>(src);
            tempSrc.remove(i);
            traverse(tempSrc, temp, arr, foundAndPopulated);
            temp.remove(temp.size() - 1);
        }

    }

}
