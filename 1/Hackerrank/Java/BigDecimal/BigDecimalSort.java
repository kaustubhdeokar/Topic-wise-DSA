import java.math.BigDecimal;
import java.util.*;

public class BigDecimalSort {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String [] s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();


        Arrays.sort(s,0,n,new Comparator<Object>(){
            public int compare(Object a1,Object a2){
                BigDecimal bg1 = new BigDecimal((String)a1);
                BigDecimal bg2 = new BigDecimal((String)a2);
                return bg2.compareTo(bg1);
            }
        });

        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }


    }

}
