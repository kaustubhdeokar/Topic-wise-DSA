import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while(testCases>0){
            int n = scan.nextInt();
            System.out.println(reverse(n));
            testCases-=1;
        }

    }

    private static int reverse(int n) {

        int reverseNumber = 0;
        int lengthNumber = countDigit(n);
        while(n>0){
            int reminder = n%10;
            reverseNumber += reminder*Math.pow(10,lengthNumber--);
            n/=10;
        }
        return reverseNumber;
    }

    private static int countDigit(int n) {

        return (int)Math.floor(Math.log10(n));
    }
}
