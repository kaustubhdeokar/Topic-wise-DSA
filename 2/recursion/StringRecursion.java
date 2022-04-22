package recursion;

import java.util.ArrayList;

public class StringRecursion {

    public static void main(String[] args) {

//        String s = "baccad";
        StringRecursion recursion = new StringRecursion();
//        StringBuilder stringBuilder = recursion.removeA(s, 0);
////        System.out.println(stringBuilder.reverse().toString());
//
//        String s1 = "asdaslfnsdlnfnlsfsdnfdaadasdasdasasd";
//        String s2 = recursion.removeCharA_NewVarNotIntroduced(s1, new StringBuilder(), 0);
////        System.out.println(s2);
//
//        String s3 = "abapplecd";
////        System.out.println(recursion.removeCharA_SkipWord(s3,"apple",new StringBuilder(),0));

        ArrayList<String> abc = recursion.trySubsetMake2LenWords("abcd", 0, "");
        for(String s:abc){
            System.out.print(s+" ");
        }
    }

    public ArrayList<String> trySubsetMake2LenWords(String s, int index, String newStr) {
        ArrayList<String> listOfStrs = new ArrayList<>();
        if(index>=s.length()){
            if(newStr.length()==2)
                listOfStrs.add(newStr);
            return listOfStrs;
        }
        if (newStr.length() == 2) {
            listOfStrs.add(newStr);
            return listOfStrs;
        }

        ArrayList<String> ans1 = trySubsetMake2LenWords(s, index + 1, newStr + s.charAt(index));
        ans1.addAll(trySubsetMake2LenWords(s, index + 1, newStr));
        return ans1;
    }

    public String removeCharA_SkipWord(String s, String toSkip, StringBuilder ans, int index) {
        if (index == s.length())
            return ans.toString();
        if (s.substring(index).startsWith(toSkip))
            return removeCharA_SkipWord(s, toSkip, ans, index + toSkip.length());
        return removeCharA_SkipWord(s, toSkip, ans.append(s.charAt(index)), index + 1);
    }

    public String removeCharA_NewVarNotIntroduced(String s, StringBuilder ans, int index) {
        if (index == s.length())
            return ans.toString();
        if (s.charAt(index) != 'a')
            ans.append(s.charAt(index));
        return removeCharA_NewVarNotIntroduced(s, ans, index + 1);
    }

    public StringBuilder removeA(String s, int index) {
        if (index == s.length())
            return new StringBuilder();
        StringBuilder ans = removeA(s, index + 1);
        if (s.charAt(index) != 'a')
            ans.append(s.charAt(index));
        return ans;
    }

}
