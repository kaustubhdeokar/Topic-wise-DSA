package backtrack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class MaxNumWithKSwaps
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("Enter a number string");
        String line = scan.nextLine();
        System.out.println("Enter allowed swaps");
        int swaps = scan.nextInt();
        int[] maxNum = {-1};
        int currIndex = 0;
        calculateMaxNumberWithSwaps(new StringBuilder(line), currIndex, swaps, maxNum);
        System.out.println("result:"+maxNum[0]);
    }

    public static void calculateMaxNumberWithSwaps(StringBuilder number, int currIdx, int swaps, int[] maxNum)
    {
        if(swaps==0 || currIdx>=number.length())
        {
            System.out.println("curr num:"+number);
            maxNum[0] = Integer.max(maxNum[0], Integer.parseInt(number.toString()));
            return;
        }

        int curr = number.charAt(currIdx) - '0';
        int maxDigit = -1;
        for (int i = currIdx; i < number.length(); i++) {
            maxDigit = Math.max(maxDigit, number.charAt(i) - '0');
        }

        if(maxDigit == curr){
            calculateMaxNumberWithSwaps(number, currIdx+1, swaps, maxNum);
        }
        else{
            for(int j=currIdx+1; j<number.length();j++)
            {
                int next = number.charAt(j) - '0';
                if(next == maxDigit) // if the curr is the max digit, we can swap. (there might be multiple)
                {
                    char swap1 = number.charAt(currIdx);
                    char swap2 = number.charAt(j);
                    number.setCharAt(currIdx, swap2);
                    number.setCharAt(j, swap1);

                    calculateMaxNumberWithSwaps(number, currIdx+1, swaps-1, maxNum);

                    //backtrack
                    number.setCharAt(currIdx, swap1);
                    number.setCharAt(j, swap2);
                }
            }
        }

    }

}
