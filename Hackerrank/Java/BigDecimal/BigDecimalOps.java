import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigDecimalOps {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String t = scan.nextLine();
        BigDecimal bd1 = new BigDecimal(s);
        BigDecimal bd2 = new BigDecimal(t);

        System.out.println(bd1.add(bd2));
        System.out.println(bd1.multiply(bd2));


    }
}
