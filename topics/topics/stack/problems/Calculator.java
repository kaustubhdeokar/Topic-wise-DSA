package stack.problems;

import java.util.Stack;

public class Calculator {

    public static void main(String[] args) {

        String str = "(1+(4+5+2)-3)+(6+8)";
        Calculator calculator = new Calculator();
        System.out.println(calculator.evaluate(str));

    }

    private int evaluate(String str) {

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        str = str.replaceAll(" ","");
        str = str.replaceAll("\\(","");
        str = str.replaceAll("\\)","");
        while (i < str.length() || stack.size() > 1) {
            char curr = str.charAt(i);
            if (curr == '+') {
                int pop = stack.pop();
                char next = str.charAt(++i);
                int answer = pop + (next - '0');
                stack.push(answer);
            }
            else if (curr == '-') {
                int pop = stack.pop();
                char next = str.charAt(++i);
                int answer = pop - (next - '0');
                stack.push(answer);
            }
            else if (curr >= '0' && curr <= '9') {
                stack.push((int) curr - '0');
            }
            i += 1;
        }

        return stack.pop();
    }

}
