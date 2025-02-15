package array.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ReverseSwapsCFHalloumiBoxes {

    public static void main(String[] args) throws IOException {
        ReverseSwapsCFHalloumiBoxes reverseSwapsCFHalloumiBoxes = new ReverseSwapsCFHalloumiBoxes();
        reverseSwapsCFHalloumiBoxes.solve();
    }

    private void solve() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;


        int testcases = Integer.parseInt(br.readLine());
        while (testcases > 0) {
            st = new StringTokenizer(br.readLine());
            int arrLen = Integer.parseInt(st.nextToken());
            int swapLen = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int max = -1;
            int min = Integer.MAX_VALUE;
            int prev = -1;
            boolean isSorted = true;
            for (int i = 0; i < arrLen; i++) {
                int arrI = Integer.parseInt(st.nextToken());
                if(prev!=-1 && prev > arrI){
                    isSorted = false;
                }
                prev = arrI;
                max = Integer.max(max, arrI);
                min = Integer.min(min, arrI);
            }
            if(isSorted) out.println("YES");
            else if (swapLen < 2) out.println("NO");
            else out.println("YES");
            testcases -= 1;
        }
        out.flush();
        out.close();
    }
}
