import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = in.nextInt();
        while (testcases > 0) {

            int r = in.nextInt();
            int c = in.nextInt();

            System.out.println("r" + r + "c" + c);

            int rows = 2 * r + 1;
            int cols = 2 * c + 1;

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < cols; j++) {

                    if (i == 0 || i == 1) {
                        if (j == 0 || j == 1)
                            System.out.print("..");
                        j = 2;
                    }
                    if (i % 2 == 0) //even row. +-
                    {
                        while (j != cols) {
                            if (j % 2 == 0)
                                System.out.print('+');
                            else
                                System.out.print('-');
                            j += 1;
                        }
                    } else //odd row |.
                    {
                        while (j != cols) {
                            if (j % 2 == 0)//even place
                                System.out.print('|');
                            else
                                System.out.print('.');
                            j += 1;
                        }
                    }
                }
                System.out.println();
            }


            testcases -= 1;
        }

    }
}
