package array.problems;

import java.util.Stack;

public class RemoveChars {

    public static void main(String[] args) {

        String s = "]]][[[";
        RemoveChars removeChars = new RemoveChars();
        System.out.println(removeChars.minSwaps(s));

    }
    public int minSwaps(String s) {
        int i=0;
        int j=s.length()-1;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int swaps = 0;

        while(i<j || !stack.isEmpty()){
            char curr = chars[i];

            if(curr=='['){
                stack.push(curr);
                i+=1;
            }
            else if(curr==']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
                i+=1;
            }

            else if(curr==']'){
                while(chars[j]!='['){
                    j-=1;
                }
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                swaps+=1;
                stack.push(chars[i]);
                i+=1;j-=1;
            }
        }
        return swaps;
    }
}
