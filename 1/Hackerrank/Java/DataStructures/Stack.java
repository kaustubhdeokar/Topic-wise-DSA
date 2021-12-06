import java.util.*;
class Solution{

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            Stack<Character> stack = new Stack<>();
            boolean bIsBalanced = true;
            for(int i=0;i<input.length();i++){
                if(bIsBalanced) {
                    switch (input.charAt(i)) {
                        case '{':
                        case '[':
                        case '(':
                            stack.push(input.charAt(i));
                            break;
                        case ')':
                            if(stack.isEmpty()){
                                bIsBalanced = false;
                                break;
                            }
                            if (stack.peek() != '(') {
                                bIsBalanced = false;
                            }
                            stack.pop();
                            break;
                        case ']':
                            if(stack.isEmpty()){
                                bIsBalanced = false;
                                break;
                            }
                            if(stack.peek()!='['){
                                bIsBalanced = false;
                            }
                            stack.pop();
                            break;
                        case '}':
                            if(stack.isEmpty()){
                                bIsBalanced = false;
                                break;
                            }
                            if(stack.peek()!='{'){
                                bIsBalanced = false;
                            }
                            stack.pop();
                            break;
                    }
                }
                else{
                    break;
                }
            }
            if(bIsBalanced && stack.isEmpty()){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }

    }
}




