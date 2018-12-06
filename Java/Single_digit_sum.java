import java.util.*;

public class Single_digit_sum {
    
    public static void main(String[] args){
        
        int n=999,m,i,j,t,sum=0;
        boolean temp=true;
        while(temp){
            if(n%10==n)
                break;
            else{
                while(n>0){
                    m=n/10;
                    sum=sum+n%10;
                    n=m;
                }
             }
            System.out.println(sum);
            if(sum>9)
            {
                temp=true;
                n=sum;
                sum=0;
            }
            else
                temp=false;
         }
        System.out.println("The single digit sum is:"+sum);
    }
}
   
