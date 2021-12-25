/*
ID: kaustub13
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.StringTokenizer;

class test {

    public static void main(String[] args) throws IOException {



        BufferedReader fileReader = new BufferedReader(new FileReader("test.in"));
        StringTokenizer st = new StringTokenizer(fileReader.readLine());
        int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        PrintWriter fileWriter = new PrintWriter(new FileWriter("test.out"));
        fileWriter.println(sum);
        fileWriter.close();

    }


}
