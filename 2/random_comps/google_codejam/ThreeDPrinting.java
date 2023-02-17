import java.io.*;
import java.util.*;

public class ThreeDPrinting{
       public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = in.nextInt();
        for (int cases = 1; cases <= testcases; cases++) {

            int[] result = new int[4];
            Arrays.fill(result, Integer.MAX_VALUE);

            for (int i = 0; i < 3; i++) {
                int j = 0;
                result[j] = Integer.min(result[j++], in.nextInt());
                result[j] = Integer.min(result[j++], in.nextInt());
                result[j] = Integer.min(result[j++], in.nextInt());
                result[j] = Integer.min(result[j], in.nextInt());
            }

            int totalInkPresent = 0;
            int totalInkRequired = (int) Math.pow(10, 6);

            for (int i : result) {
                totalInkPresent += i;
            }

            if (totalInkPresent < totalInkRequired) {
                System.out.println("Case #" + cases + ": IMPOSSIBLE");
            } else if (totalInkPresent == totalInkRequired) {
                print(cases, result);
            } else {
                int inkCount = 0;
                boolean inkNotRequired = false;
                for(int i=0;i<4;i++){
                    if(inkNotRequired)
                        result[i] = 0;
                    else if((inkCount+result[i])>totalInkRequired){
                        result[i] = totalInkRequired-inkCount;
                        inkNotRequired = true;
                    }
                    else
                    {
                        inkCount+=result[i];
                    }
                }
                print(cases, result);
            }
        }

    }

    public static void print(int cases, int[] arr) {
        System.out.print("Case #" + cases + ": ");
        
        for (int i=0;i<arr.length-1;i++)
            System.out.print(arr[i] + " ");
        System.out.print(arr[arr.length-1]);

        System.out.println();
    }
}
