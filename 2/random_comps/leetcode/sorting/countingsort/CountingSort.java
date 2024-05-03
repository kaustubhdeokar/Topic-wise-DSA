package sorting.countingsort;

//https://leetcode.com/problems/relative-sort-array/

public class CountingSort {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        //relative sorting according to elements of arr2.

        int[] cnt = new int[1001];

        for (int n : arr1) cnt[n]++; //simple count array for each elem in arr1.

        int i = 0;
        for (int n : arr2) { //as per elements in arr2, and their counts, rewrite the elements in arr1.
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        //add elements not in arr1.

        for (int n = 0; n < cnt.length; n++) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }

    }

}
