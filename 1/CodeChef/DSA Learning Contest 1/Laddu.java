import java.util.Arrays;
import java.util.Scanner;

public class Laddu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        scan.nextLine();
        while (testCases-- > 0) {

            String[] activitiesAndCountry = scan.nextLine().split(" ");
            int activities = Integer.parseInt(activitiesAndCountry[0]);
            String country = activitiesAndCountry[1];
            int totalBonus = 0;
            while (activities-- > 0) {
                String[] activityArray = scan.nextLine().split(" ");
                if (activityArray.length == 2) {
                    if (activityArray[0].equals("CONTEST_WON")) { //contest won.
                        totalBonus += 300 + (Math.max((20 - Integer.parseInt(activityArray[1])), 0));
                    }
                    else { //bug found.
                        totalBonus += Integer.parseInt(activityArray[1]);
                    }
                }
                else {
                    if (activityArray[0].equals("TOP_CONTRIBUTOR")) {
                        totalBonus += 300;
                    }
                    else {
                        totalBonus += 50;
                    }
                }

            }

            if(country.equals("INDIAN")){
                System.out.println(totalBonus/200);
            }
            else{
                System.out.println(totalBonus/400);
            }
        }

    }
}
