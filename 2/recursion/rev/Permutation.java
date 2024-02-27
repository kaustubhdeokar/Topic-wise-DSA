import java.util.*;

public class Permutation {

    public static void main(String[] args){
        String str = "abc";
        permutations(str);
    }

    public static void permutations(String str){

        ArrayDeque<String> list = new ArrayDeque<>();
        list.add("");

        for(int k=0;k<str.length();k++){

            char c = str.charAt(k); // b
            int size = list.size(); // 1

            for(int i=0;i<size;i++){

                String top = list.remove(); //"a";

                for(int j=0;j<=top.length();j++)
                {
                    String newString = top.substring(0,j)+ c + top.substring(j);
                    System.out.println("newstring:"+newString);
                    list.add(newString); //ba, ab
                }

            }


        }

        while(!list.isEmpty()){
            System.out.println("top:"+list.remove());
        }
        
    }

}
