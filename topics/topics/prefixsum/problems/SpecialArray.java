package prefixsum.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//todo: this should be done with prefix array
public class SpecialArray {
    public static void main(String[] args) {
        SpecialArray array = new SpecialArray();
        boolean[] res = array.isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}});
        for (boolean r : res) {
            System.out.print(r + " ");
        }
    }


    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        List<Integer> notSpecialNums = new ArrayList<>();
        int parity = nums[0] % 2;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == parity) {
                notSpecialNums.add(i);
            }
            parity = nums[i] % 2;
        }

        boolean[] result = new boolean[queries.length];
        Arrays.fill(result, true);
        if (notSpecialNums.size() == 0) {
            return result;
        }

        int counter = -1;
        for (int[] query : queries) {
            int start = 0;
            int end = notSpecialNums.size() - 1;
            counter += 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int midElem = notSpecialNums.get(mid);
                if (midElem > query[1]) {
                    end = mid - 1;
                } else if (midElem <= query[0]) {
                    start = mid + 1;
                } else {
                    result[counter] = false;
                    break;
                }
            }
        }
        return result;
    }
}
