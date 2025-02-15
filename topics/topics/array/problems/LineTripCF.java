package array.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LineTripCF {

    public static void main(String[] args) throws IOException {
        LineTripCF solution = new LineTripCF();
        solution.solve();
    }

    private void solve() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;


        int testcases = Integer.parseInt(br.readLine());
        while (testcases > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int maxDist = 0;
            int prev = 0;

            for (int i = 0; i < n; i++) {
                int arrI = Integer.parseInt(st.nextToken());
                maxDist = Integer.max(maxDist, arrI - prev);
                if(i==n-1){
                    maxDist = Integer.max(maxDist, 2*(x - arrI));
                }
                prev = arrI;
            }
            out.println(maxDist);
            testcases -= 1;
        }
        out.flush();
        out.close();

    }

}
