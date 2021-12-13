/*
ID: kaustub13
LANG: JAVA
PROG: ride 
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class ride {
    public static void main(String[] args) throws IOException {

      BufferedReader bufferedReader = new BufferedReader(new FileReader("ride.in"));
      String input = bufferedReader.readLine();
      List<Integer> list = new ArrayList<>();
      int currentProduct = 1;
      while (input != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(input);
            while(stringTokenizer.hasMoreTokens()){
                String s = stringTokenizer.nextToken();
                for(int i=0;i<s.length();i++){
                    currentProduct*=((int)s.charAt(i)-64);
                }
            }
            System.out.println(currentProduct);
            list.add(currentProduct);
            input = bufferedReader.readLine();
            currentProduct = 1;
        }
        PrintWriter printWriter = new PrintWriter(new FileWriter("ride.out"));
        if (list.get(0) % 47 == list.get(1) % 47) {
            printWriter.println("GO");
        } else {
            printWriter.println("STAY");
        }
        printWriter.close();
        
    }
}

