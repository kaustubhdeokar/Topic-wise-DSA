import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class ArrangeArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases > 0) {

            int arrLen = scanner.nextInt();
            int[] arr = new int[arrLen];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arrLen; i++) {
                arr[i] = scanner.nextInt();
            }
            boolean canArrangeArray = true;
            for (int i = 0; i < arrLen; i++) {
                Integer integer = map.get(arr[i]);
                if (integer == null) {
                    map.put(arr[i], 1);
                } else {
                    map.put(arr[i], integer + 1);
                    if (calculateIfCanArrangeArray(integer + 1, arrLen)) {
                        canArrangeArray = false;
                        break;
                    }
                }
            }
            if (canArrangeArray) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            testcases -= 1;

        }
    }

    private static boolean calculateIfCanArrangeArray(int count, int arrLen) {
        if (arrLen % 2 == 0) {
            return count > (arrLen / 2);
        } else {
            return count > (arrLen / 2 + 1);
        }
    }

}
