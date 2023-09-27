import java.util.Stack;

public class SortStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();
    int size;
    SortStack() {
        int[] arr = { 2, 3, 1, 4, 5 };
        for (int i : arr) {
            stack.push(i);
        }
        size = stack.size();
    }

    public void stackSort() {

        for (int i = 0; i < size; i++) {

            if (i == 0) {
                tempStack.push(stack.pop()); // stack with size 1 is always sorted.
            } else {
                // 4 - 1 - 3 - 2 //5
                // keeping it sorted in ascending order.
                int popped = stack.pop();
                stack.push(-1); // remove at the end of this loop.
                while (!tempStack.isEmpty() && tempStack.peek() > popped) {
                    stack.push(tempStack.pop());
                }
                tempStack.push(popped);
                while (stack.peek() != -1) {
                    tempStack.push(stack.pop());
                }
                stack.pop(); // removed the -1;

            }

            printStacks();

        }
    }

    public void printStacks() {
        System.out.println(stack);
        System.out.println(tempStack);
    }

    public static void main(String[] args) {

        SortStack sortStack = new SortStack();
        sortStack.stackSort();
    }

}