package recursion;

import java.util.ArrayList;

public class Strings {

    public static void main(String[] args) {

        int mod = 1000000007;
        int b = Integer.MAX_VALUE;
        System.out.println(b);

//        Strings perm = new Strings();
//        perm.subsequences("abc");
//        perm.printSubsequences("abc");
//
    }

    private void printSubsequences(String str) {

        StringBuilder strBuilder = new StringBuilder();
        ArrayList<String> subsequences = subsequences(str, strBuilder, str.length(), 0);
        System.out.println(subsequences);

    }

    public ArrayList<String> subsequences(String str, StringBuilder buffer, int length, int ptr) {

        ArrayList<String> result = new ArrayList<>();
        if (ptr == length) {
            result.add(new String(buffer));
            return result;
        }

        result.addAll(subsequences(str, buffer.append(str.charAt(ptr)), length, ptr + 1));
        buffer.deleteCharAt(buffer.length() - 1);
        result.addAll(subsequences(str, buffer, length, ptr + 1));
        return result;
    }


    private void subsequences(String str) {
        String curr = "";
        subsequencesReverse_DontTake_Take(str, curr, str.length());
        System.out.println();
        subsequences_DontTake_Take(str, curr, str.length(), 0);
        System.out.println();
        subsequencesReverse_Take_DontTake(str, curr, str.length());
        System.out.println();
        subsequences_Take_DontTake(str, curr, str.length(), 0);
    }

    //as we are printing from the last the result will be {},a,b,c,ba,cb,ca,cba
    private void subsequencesReverse_DontTake_Take(String str, String curr, int length) {
        if (length == 0) {
            System.out.print(curr + " ");
            return;
        }
        subsequencesReverse_DontTake_Take(str, curr, length - 1); // don't take
        subsequencesReverse_DontTake_Take(str, curr + str.charAt(length - 1), length - 1); //take
    }

    private void subsequencesReverse_Take_DontTake(String str, String curr, int length) {
        if (length == 0) {
            System.out.print(curr + " ");
            return;
        }
        subsequencesReverse_Take_DontTake(str, curr + str.charAt(length - 1), length - 1); //take
        subsequencesReverse_Take_DontTake(str, curr, length - 1); // don't take
    }


    // a, b,c,ab,bc,ac,abc
    private void subsequences_DontTake_Take(String str, String curr, int length, int ptr) {
        if (length == ptr) {
            System.out.print(curr + " ");
            return;
        }
        subsequences_DontTake_Take(str, curr, length, ptr + 1);
        subsequences_DontTake_Take(str, curr + str.charAt(ptr), length, ptr + 1);
    }

    // a, b,c,ab,bc,ac,abc
    private void subsequences_Take_DontTake(String str, String curr, int length, int ptr) {
        if (length == ptr) {
            System.out.print(curr + " ");
            return;
        }
        subsequences_Take_DontTake(str, curr + str.charAt(ptr), length, ptr + 1);
        subsequences_Take_DontTake(str, curr, length, ptr + 1);
    }


}
