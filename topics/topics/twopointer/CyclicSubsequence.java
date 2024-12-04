package twopointer;

public class CyclicSubsequence {

    public boolean canMakeSubsequence(String str1, String str2) {

        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1<str1.length() && ptr2<str2.length())
        {

            if(str1.charAt(ptr1) == str2.charAt(ptr2)){
                ptr1+=1;
                ptr2+=1;
            }
            else if( (str1.charAt(ptr1)-'a'+1)%26 == (str2.charAt(ptr2)-'a'))
            {
                ptr1+=1;
                ptr2+=1;
            }
            else{
                ptr1+=1;
            }
        }
        if(ptr1==str1.length() && ptr2<str2.length()) return false;

        return true;
    }

    public static void main(String[] args) {
        CyclicSubsequence cyclicSubsequence = new CyclicSubsequence();
        boolean res = cyclicSubsequence.canMakeSubsequence("abc", "ad");
        System.out.println(res);
    }
}
