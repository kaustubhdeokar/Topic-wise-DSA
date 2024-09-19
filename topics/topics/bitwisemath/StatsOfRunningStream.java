
package bitwisemath;

import java.text.DecimalFormat;

public class StatsOfRunningStream{


    public static void main(String[] args) {

        double ans = 0;
        for(int i=0;i<256;i++){

            ans += Math.pow(10, 9);
        }
        showDecimal(ans);

//        showDecimal(Double.MAX_VALUE);
    }

    private static void showDecimal(double ans) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(0);  // To avoid decimal points

        String formattedNumber = decimalFormat.format(ans);
        System.out.println(formattedNumber);
    }


}