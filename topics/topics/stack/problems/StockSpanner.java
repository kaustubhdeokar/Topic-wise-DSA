package stack.problems;

import java.util.Stack;

public class StockSpanner {

    /* Here we have to find the next greater on the left side of the current element. */

    Stack<int[]> stack = new Stack<>();
    int currIdx = 0;

    public StockSpanner() {}

    public int next(int price) {
        currIdx += 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }
        int answer;
        if (stack.isEmpty()) {
            answer = currIdx;
        } else {
            answer = Math.abs(currIdx - stack.peek()[1]);
        }
        stack.push(new int[]{price, currIdx});
        return answer;
    }

    public static void main(String[] args) {


        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        StockSpanner stockSpanner = new StockSpanner();
        for (int i : arr) {
            System.out.print(stockSpanner.next(i)+" ");
        }

    }
}

