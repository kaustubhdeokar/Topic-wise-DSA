//https://www.codechef.com/AUG20B/problems/LINCHESS
//CodeChef problem 2
//Chef and Linear Chess

import java.util.Scanner;

public class LinChess {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while(testCases-->0){
            int n = scan.nextInt();
            long k = scan.nextLong();
            long lowestSteps = Long.MAX_VALUE;
            long startToLowestSteps = -1;
            for(int i=0;i<n;i++){
                long pi = scan.nextLong();
                long steps = 0;
                if((k%pi)==0){
                    steps = ((k-pi)/pi);
                    if(steps<lowestSteps){
                        lowestSteps = steps;
                        startToLowestSteps = pi;
                    }
                }
            }
            if(startToLowestSteps == -1){
                System.out.println(-1);
            }
            else{
                System.out.println(startToLowestSteps);
            }
        }

    }

}
