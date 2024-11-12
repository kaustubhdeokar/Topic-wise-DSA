package array.problems;

public class ArrayProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {-1, 1, 0, -3, 3};
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = left[i - 1] * arr[i];
        }

        right[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = right[i+1]*arr[i];
        }
        for(int r: right){
            System.out.print(r+" ");
        }


        System.out.println();

    }
}
