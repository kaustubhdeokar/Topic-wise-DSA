import java.util.*;

public class StringWithoutACharacter {
    public static void main(String[] main){
        String s = "abcab";
        StringBuilder stringBuilder = new StringBuilder();
        String result = recursivelyRemoveCharacter(s, 'a',stringBuilder, 0);
        System.out.println("result"+result);
        
        result = recursivelyRemoveCharacter(s, 'a',0);
        System.out.println("result"+result);
        
    }

    public static String recursivelyRemoveCharacter(String s, char a, StringBuilder stringBuilder, int index){
        
        if(index>=s.length()){
            return "";
        }

        if(s.charAt(index) != a){
            stringBuilder.append(s.charAt(index));
        }

        recursivelyRemoveCharacter(s, a, stringBuilder, index+1);

        return stringBuilder.toString();
    }

    public static String recursivelyRemoveCharacter(String s, char a, int index){

        StringBuilder stringBuilder = new StringBuilder();

        if(index>=s.length()){
            return "";
        }

        if(s.charAt(index) != a){
            stringBuilder.append(s.charAt(index));
        }

        stringBuilder.append(recursivelyRemoveCharacter(s, a, index+1));

        return stringBuilder.toString();
    }

}
