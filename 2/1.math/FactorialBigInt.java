import java.util.ArrayList;

public class FactorialBigInt {

    public static void main(String[] args) {
        //arrayListMultiplication();
        factorialWithArrayList();
    }

    private static void factorialWithArrayList() {
        ArrayList<Integer> factorial = new ArrayList<>();

        factorial.add(2);
        int carry = 0;
        for (int multiplier = 3; multiplier <= 50; multiplier++) {
            for (int i = factorial.size() - 1; i >= 0; i--) {
                int val = factorial.get(i) * multiplier + carry;
                carry = val / 10;
                factorial.set(i, val % 10);
            }
            while (carry > 0) {
                factorial.add(0, carry % 10);
                carry /= 10;
            }
            carry = 0;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(Integer i: factorial){
            stringBuilder.append(i);
        }
        System.out.println(stringBuilder.toString());

    }

    /**
     * Multiplying 567*2 using arraylist
     */
    private static void arrayListMultiplication() {
        ArrayList<Integer> factorial = new ArrayList<>();

        factorial.add(5);
        factorial.add(6);
        factorial.add(7);
        int multiplier = 2;
        int carry = 0;
        for (int i = factorial.size() - 1; i >= 0; i--) {
            int val = factorial.get(i) * multiplier + carry;
            carry = val / 10;
            factorial.set(i, val % 10);
        }
        if (carry > 0) {
            factorial.add(0, carry);
        }
        System.out.println(factorial);
    }

}
