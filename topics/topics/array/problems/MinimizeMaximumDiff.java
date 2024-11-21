package array.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MinimizeMaximumDiff {

    public static void main(String[] args) {

        MinimizeMaximumDiff min = new MinimizeMaximumDiff();
        int[] quantities = min.readQuantitiesFromFile("/home/kaustubh/Desktop/Topic-wise-DSA/topics/topics/array/problems/input.txt");
        int n = 6;

        System.out.println(min.minimizedMaximum(n, quantities));

    }

    public int[] readQuantitiesFromFile(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return Arrays.stream(content.split("\\s+|,"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    public int minimizedMaximum(int n, int[] quantities) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int q: quantities) {
            sum+=q;
            max = Math.max(q, max);
            min = Math.min(q, min);
        }

        int low = 1;
        int high = max;
        int maxMid = high;

        while(low<=high){

            int mid = low + (high-low)/2;
            int count = 0;

            for(int q: quantities){
                count +=  Math.ceil(q/(1.0*mid));
            }
            // System.out.println("low:"+low+" high:"+high+" mid:"+mid+" count:"+count);

            if(count<=n){
                maxMid = Integer.min(mid, maxMid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return maxMid;
    }

}
