import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        for(int cases = 1;cases<=testcases;cases++){

            int dices = scanner.nextInt();
            int[] diceSides = new int[dices];
            int maxSide = Integer.MIN_VALUE;
            for(int i=0;i<dices;i++){
                diceSides[i] = scanner.nextInt();
                maxSide = Integer.min(maxSide,diceSides[i]);
            }

            Set<Integer> set = new HashSet<>();
            int maxCount = 0;
            int currCount = 0;
            for(int i=0;i<dices;i++){
                int currDiceSide = diceSides[i];
                while(currDiceSide > 0 && set.contains(currDiceSide)){
                    currDiceSide--;
                }
                if(currDiceSide!=0) //set does not contain currDiceSide
                {
                    set.add(currDiceSide);
                    currCount+=1;
                    maxCount = Integer.max(currCount,maxCount);
                }
                else{
                    set = new HashSet<>();
                    set.add(diceSides[i]);
                    currCount = 1;
                }
            }

            System.out.println("Case #"+cases+": "+maxCount);

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

