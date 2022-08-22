import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Height {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases > 0) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (averageLessThan35(a, b) || averageLessThan35(b, c) || averageLessThan35(a, c)) {
                System.out.println("Fail");
            } else {
                System.out.println("Pass");
            }
            testcases -= 1;
        }


    }

    public static boolean averageLessThan35(int a, int b) {
        return (1.0*(a + b) / (2.0)) < 35;
    }

}
