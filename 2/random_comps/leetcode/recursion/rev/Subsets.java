package recursion.rev;

import java.util.*;

public class Subsets {
    
    public static void main(String[] args){

        String str = "abcd";
        String curr = "";

        ArrayList<String> list = createSubsets(str, curr, 0);

        print(list);
    }

    public static void print(ArrayList<String> list){
        for(String s:list){
            System.out.println(s);
        }
    }

    public static ArrayList<String> createSubsets(String str, String curr, int index){

        ArrayList<String> list = new ArrayList<>();

        if(index>=str.length()){
            list.add(curr);
            return list;
        }

        char currChar = str.charAt(index);
        list.addAll(createSubsets(str, curr+String.valueOf(currChar), index+1));
        list.addAll(createSubsets(str, curr, index+1));

        return list;

    }

}
