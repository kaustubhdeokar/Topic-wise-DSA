import java.util.*;

public class JavaAnagrams{
    
    void barking(){
        System.out.println("Barking");
    }
    void hungry(){
        System.out.println("Dog is hungry! feed food");
    }

    void verfiyanagrams(String a,String b){
            a=a.toLowerCase();
            b=b.toLowerCase();
            
            char[] a1=new char[26];
            char[] b1=new char[26];

            if(a.length()!=b.length()){
                System.out.println("Not Anagrams");
            }
            else{
                for(int i=0;i<a.length();i++){                
                    int aint;
                    aint=a.charAt(i);
                    a1[(aint%97)]+=1;
                    aint=b.charAt(i);
                    b1[(aint%97)]+=1;

                }
                int t=0;
                for(int i=0;i<26;i++){
                    if(a1[i]!=b1[i]){
                        t=1;
                    }
                    if(t==1)
                    break;
                }
                if(t==1){
                    System.out.println("Not Anagrams");
                    return;
                }
                else{
                    System.out.println("Anagrams");
                }
            }


    }
    
    public static void main(String[] args){

        String s1,s2;
        Scanner scan=new Scanner(System.in);
        s1=scan.nextLine();
        s2=scan.nextLine();
        Dog d1=new Dog();
        d1.verfiyanagrams(s1,s2);
        scan.close();

    }
}