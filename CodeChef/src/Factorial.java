import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int testCases = scan.nextInt();
        while(testCases-->0){
            int number = scan.nextInt();
            System.out.println(zeroesInFactorial(number));
        }
    }

    private static int zeroesInFactorial(int number) {
        int powerOfFive = 1;
        int zeroes = 0;
        while(number >= Math.pow(5,powerOfFive)){
            zeroes += number/(Math.pow(5,powerOfFive));
            powerOfFive+=1;
        }
        return zeroes;
    }

}
