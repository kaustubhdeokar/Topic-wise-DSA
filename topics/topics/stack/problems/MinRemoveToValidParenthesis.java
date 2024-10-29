package stack.problems;

public class MinRemoveToValidParenthesis {
    public static void main(String[] args) {

        char curr = 'a';
        StringBuilder str = new StringBuilder("adasdas((");
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='('){
                str.deleteCharAt(i);
            }
        }

        System.out.println(str.toString());

    }
}
