package bitwisemath;

public class ExistenceOfAlphabet {

    private static String alpha = "abcedyz";

    public static void main(String[] args) {

        long a = 0;

        for (int i = 0; i < alpha.length(); i++) {
            int alphabet = alpha.charAt(i) - 'a';
            a |= (1L << alphabet);
        }

        System.out.println(a&1);
        System.out.println(a&2);

    }

}
