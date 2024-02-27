package linearsearch;

public class NoOfDigits {

    public static void main(String[] args) {

        int[] arr = {12, 345, 2, 6, 7896};
        int count = 0;
        for (int j : arr) {
            int noOfDigits = calculateDigitsIn(j);
            System.out.println(noOfDigits);
        }
        System.out.println(count);
    }

    public static int calculateDigitsIn(int num) {
        if (num < 1) num *= -1;
        return (int) (Math.log10(num)) + 1;
    }
}
