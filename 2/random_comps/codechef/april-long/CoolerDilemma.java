import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CoolerDilemma {

    public static void main(String[] args) throws java.lang.Exception {


        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases-- > 0) {
            int rentPerMon = scanner.nextInt();
            int cost = scanner.nextInt();
            if(cost<=rentPerMon){
                System.out.println(0);
            }
            else{
                int q = cost/rentPerMon;
                int r = cost%rentPerMon;
                if(r==0)
                    System.out.println(q-1);
                else
                    System.out.println(q);
            }


        }

    }


}

