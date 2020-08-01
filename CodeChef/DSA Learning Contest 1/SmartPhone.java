import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//https://www.codechef.com/LRNDSA01/problems/ZCO14003
public class SmartPhone {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int elements = scan.nextInt();
        Long[] array = new Long[elements];
        int counter=0;
        while(counter<elements){
            array[counter]=scan.nextLong();
            counter+=1;
        }
        Comparator<Long> comparator = (integer, t1) -> Long.compare(integer,t1);
        Arrays.sort(array,comparator);
        long maximumProfit = Long.MIN_VALUE;
        for(int i=0;i<elements;i++){
            if((array[i]*(elements-i))>maximumProfit){
                maximumProfit = array[i]*(elements-i);
            }
        }
        System.out.println(maximumProfit);
    }

}
