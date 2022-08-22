import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CandyDistribution {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases > 0) {

            int candies = scanner.nextInt();
            int friends = scanner.nextInt();
            if (candies < friends) {
                System.out.println("No");
            } else if (candies % friends != 0) {
                System.out.println("No");
            } else if ((candies / friends) % 2 != 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            testcases -= 1;

        }
    }
}