import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class XorPairs {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases-- > 0) {

            int x = scanner.nextInt();

            /*
            *   i=0 j=1 k=2 :==6
                i=0 j=1 k=4 :==10
                i=0 j=1 k=6 :==14
                i=0 j=1 k=8 :==18
                i=0 j=1 k=10 :==22
                i=0 j=1 k=12 :==26
                i=0 j=1 k=14 :==30
                i=0 j=1 k=16 :==34
                i=0 j=1 k=18 :==38
                i=0 j=2 k=4 :==12
                i=0 j=2 k=8 :==20
                i=0 j=2 k=12 :==28
                i=0 j=2 k=16 :==36
                i=0 j=4 k=8 :==24
                i=0 j=4 k=16 :==40
                i=0 j=4 k=17 :==42
                i=0 j=4 k=18 :==44
                i=0 j=4 k=19 :==46
                i=0 j=8 k=16 :==48
                i=0 j=8 k=17 :==50
                i=0 j=8 k=18 :==52
                i=0 j=8 k=19 :==54
                i=0 j=12 k=16 :==56
                i=0 j=12 k=17 :==58
                i=0 j=12 k=18 :==60
                i=0 j=12 k=19 :==62
            * */

            if (x % 2 != 0) //no odd occuring nums.
                System.out.println(-1);
            else if (x != 0 && ((x & (x - 1)) == 0)) //power of 2 wouldn't work.
                System.out.println(-1);
            else {
                //i=0 j=1 k=2 :==6
                //i=0 j=1 k=4 :==10
                //i=0 j=1 k=6 :==14
                for (int i = 1; i < x / 2; i++) {
                    int one = i;
                    int two = x/2-i;
                    if (((one ^ two) + one + two) == x) {
                        System.out.print(0);
                        System.out.print(" " + i + " ");
                        System.out.println(two);
                        break;
                    }
                }

            }


        }
    }
}

