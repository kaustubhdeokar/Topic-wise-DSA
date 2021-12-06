import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int nElements = scan.nextInt();
        List<Integer> listIntegers = new ArrayList<>();
        while(nElements-->0){
            listIntegers.add(scan.nextInt());
        }
        int testCases = scan.nextInt();
        while(testCases-->0){
            scan.nextLine();
            String strCase = scan.nextLine();
            if("Delete".equalsIgnoreCase(strCase)){
                listIntegers.remove(listIntegers.get(scan.nextInt()));
            }
            else{
                int x = scan.nextInt();
                int y = scan.nextInt();
                listIntegers.add(x,y);
            }
            
        }
        for(Integer i:listIntegers){
            System.out.print(i+" ");
        }

    }
}

