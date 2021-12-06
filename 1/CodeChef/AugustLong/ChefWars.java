import java.util.Scanner;
//August Long - 1
//https://www.codechef.com/AUG20B/problems/CHEFWARS

public class ChefWars {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while(testCases-->0){
            long h,p;
            h = scan.nextLong();
            p = scan.nextLong();
            while(p>0){
                h = h-p;
                p/=2;
            }
            if(h >0){
                System.out.println(0);
            }
            else{
                System.out.println(1);
            }
        }

    }

}
