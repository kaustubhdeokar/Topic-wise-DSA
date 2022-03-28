//https://www.codechef.com/LP2TO302/problems/SMPAIR

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SmallestPair {

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(bufferedReader.readLine());
        while (testcases-- > 0) {
            int numElem = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int[] arr = new int[numElem];
            for (int i = 0; i < numElem; i++) {
                arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int lowestSum = Integer.MAX_VALUE;
            int lowest = arr[0];
            for (int i = 1; i < numElem; i++) {
                lowestSum = Integer.min(lowestSum,lowest+arr[i]);
                lowest = Integer.min(lowest,arr[i]);
            }
            System.out.println(lowestSum);
        }
    }
}
