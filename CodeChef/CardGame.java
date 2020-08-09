//https://www.codechef.com/AUG20B/problems/CRDGAME3
//Code Chef Problem-3 for August Challenge 
//Another Card Game Problem 


import java.util.Scanner;

public class CardGame3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while(testCases-->0){
            int chef = scan.nextInt();
            int rick = scan.nextInt();
            int chefsDigits = (int) Math.ceil(chef/9.0);
            int ricksDigits = (int) Math.ceil(rick/9.0);
            if(chefsDigits>=ricksDigits){
                System.out.println(1+" "+ricksDigits);
            }
            else{
                System.out.println(0+" "+chefsDigits);
            }
        }

    }
}
