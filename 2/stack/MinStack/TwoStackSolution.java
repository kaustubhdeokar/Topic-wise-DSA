import java.util.Stack;

public class TwoStackSolution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public TwoStackSolution() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        printStacks();
    }

    public void pop() {
        int val = stack.pop();
        if (!minStack.isEmpty() && minStack.peek() == val) {
            minStack.pop();
        }

        printStacks();
    }

    public void printStacks() {
        if (!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
        }
        if (!minStack.isEmpty()) {
            System.out.print(minStack.peek() + " ");
        }
        System.out.println();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args){
        int[] arr = {2, 7, 4, 1, 8, 1};
        TwoStackSolution twoStackSolution = new TwoStackSolution();
        for (int i : arr) {
            twoStackSolution.push(i);
        }

        System.out.println("popping:");

        while(!twoStackSolution.stack.isEmpty()){
            twoStackSolution.pop();
        }
    }
}
