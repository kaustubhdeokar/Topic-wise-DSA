package recursion;

public class NumberUtil {

    public static void main(String[] args) {

        NumberUtil f = new NumberUtil();
        System.out.println(f.factorial(5));
        System.out.println(f.sumOfN(5));
        System.out.println(f.sumOfDigits(1234));
        System.out.println(f.productOfDigits(1234));
        Double d = f.reverseNum(1234);
        System.out.println(d.intValue());
        System.out.println(f.isPalindrome(1221));
        System.out.println(f.numOfZeroes(30204));
        System.out.println(f.numberOfSteps(9));
    }

    public boolean isPalindrome(int n) {
        return n == reverseNum(n);
    }

    public double reverseNum(int n) {
        if (Math.log10(n) == 0)
            return n;
        return (n % 10) * Math.pow(10, Math.floor(Math.log10(n))) + reverseNum(n / 10);
    }

    public int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public int sumOfN(int n) {
        if (n == 0)
            return 0;
        return n + sumOfN(n - 1);
    }

    public int productOfDigits(int n) {
        if ((n / 10) == 0)
            return n;
        return (n % 10) * productOfDigits(n / 10);
    }

    public int sumOfDigits(int n) {
        if ((n / 10) == 0)
            return n;
        return n % 10 + sumOfDigits(n / 10);
    }

    public int numOfZeroes(int n) {
        if ((n / 10) == 0) {
            if (n % 10 == 0)
                return 1;
            else
                return 0;
        }
        int s = n % 10 == 0 ? 1 : 0;
        return s + numOfZeroes(n / 10);
    }

    public int numberOfSteps(int num) {
        int steps = 0;
        if(num==0)
            return steps;
        else if((num&1)==0)
            steps = numberOfSteps(num/2);
        else
            steps = numberOfSteps(num-1);
        return 1 + steps;
    }

}

