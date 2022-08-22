import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Equalise {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases > 0) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (Math.abs(a - b) % 2 != 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            testcases -= 1;
        }


    }


}
