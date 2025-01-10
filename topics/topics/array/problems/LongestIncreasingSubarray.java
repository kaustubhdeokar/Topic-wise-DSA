package array.problems;

import java.util.List;

public class LongestIncreasingSubarray {

    public static void main(String[] args) {
        LongestIncreasingSubarray lis = new LongestIncreasingSubarray();
        List<Integer> list = List.of(5, 6, 1, 2, 3, 2, 3, 4);
        System.out.println(lis.lenOfLongIncSubArr(list));
        System.out.println(lis.lenOfLongIncCircularSubArr(list));
    }

    public int lenOfLongIncCircularSubArr(List<Integer> arr) {

        int arrLen = arr.size();
        int i = 1;
        int j = 1;
        int length = 1;
        int maxLength = 1;
        boolean exceededLength = false;

        while (i < arr.size()) {
            if (arr.get(j % arrLen) > arr.get((j - 1) % arrLen)) {
                length += 1;
                if (length > maxLength) maxLength = length;
            } else {
                if (exceededLength) break;
                i = j;
                length = 1;
            }
            j += 1;
            if (j > arrLen) exceededLength = true;
        }

        return maxLength;

    }

    public int lenOfLongIncSubArr(List<Integer> arr) {


        int i = 1;
        int length = 1;
        int maxLength = 1;

        while (i < arr.size()) {
            if (arr.get(i) > arr.get(i - 1)) {
                length += 1;
                if (length > maxLength) maxLength = length;
            } else {
                length = 1;
            }
            i += 1;

        }

        return maxLength;

    }

}
