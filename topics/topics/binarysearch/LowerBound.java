package binarysearch;

import java.io.IOException;
import java.io.PrintWriter;

public class LowerBound {

    public static void main(String[] args) throws IOException {
        LowerBound solution = new LowerBound();
        solution.solve();
    }

    private void solve() throws IOException {

        int[] arr = new int[]{1, 2, 3, 4, 5, 5, 6, 7, 7, 8, 9, 9, 9, 11};
        PrintWriter out = new PrintWriter(System.out);
        int start = 0;
        int end = arr.length - 1;

        int target = 13;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid:" + mid + " :" + arr[mid]);
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        out.println("start:" + start +"end:"+end);
        out.flush();
        out.close();

    }
}
