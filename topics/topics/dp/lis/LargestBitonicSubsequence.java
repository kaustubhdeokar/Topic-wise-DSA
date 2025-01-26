package dp.lis;

import java.util.Arrays;

public class LargestBitonicSubsequence {

    public static void main(String[] args) {

        int[] arr;
        //arr = new int[]{2, 1, 1, 5, 6, 2, 3, 1};
//        arr = new int[]{9, 8, 1, 7, 6, 5, 4, 3, 2, 1};
        arr = new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64};
        int[] longestIncreasingSubsequence = new int[arr.length];
        Arrays.fill(longestIncreasingSubsequence, 1);
        calculateLis(arr, longestIncreasingSubsequence);


        reverseArr(arr);
        int[] longestDecreasingSubsequence = new int[arr.length];
        Arrays.fill(longestDecreasingSubsequence, 1);
        calculateLis(arr, longestDecreasingSubsequence);
        reverseArr(longestDecreasingSubsequence);

        int longestBitonic = -1;
        int longestBitonicIndex = -1;
        for (int i = 1; i < arr.length - 1; i++) {
            int currBitonic = longestIncreasingSubsequence[i] + longestDecreasingSubsequence[i] - 1;
            if (currBitonic > longestBitonic) {
                longestBitonic = currBitonic;
                longestBitonicIndex = i;
            } else if (currBitonic == longestBitonic) {
                System.out.println("currbi" + currBitonic + " index:" + i);
            }
        }
        System.out.println("longestBitonic:" + longestBitonic + " longestBitonicIndex:" + longestBitonicIndex);
    }

    private static void reverseArr(int[] arr) {
        int pStart = 0;
        int pEnd = arr.length - 1;
        while (pStart < pEnd) {
            int temp = arr[pStart];
            arr[pStart] = arr[pEnd];
            arr[pEnd] = temp;
            pStart += 1;
            pEnd -= 1;
        }
    }

    private static void calculateLis(int[] arr, int[] lis) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        System.out.println();
        for(int i: lis){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void calculateLisForReverse(int[] arr, int[] lis) {
        for (int i = arr.length-1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        System.out.println();
        for(int i: lis){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
