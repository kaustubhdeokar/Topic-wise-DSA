import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EasyPerm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases > 0) {

            int n = scanner.nextInt();
            for (int i = n; i > 0; i--) {
                System.out.print(i + " ");
            }
            testcases -= 1;
        }

    }
}
