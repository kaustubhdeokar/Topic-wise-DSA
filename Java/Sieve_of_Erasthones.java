import java.util.*;

public class Sieve_of_Erasthones {
    
    public static void main(String[] args){
        
        int i,j,n=50,temp=0;
        boolean p[]=new boolean[n+1];
        for(i=0;i<50;i++)
            p[i]=true;
        for(i=2;i*i<50;i++)
        {
            if(p[i]==true){
                for(j=i*i;j<n;j+=i)
                    p[j]=false;
            }
        }
        for(i=2;i<50;i++)
           if(p[i]==false)
               System.out.println(i);
        
    
    }
        }
   
