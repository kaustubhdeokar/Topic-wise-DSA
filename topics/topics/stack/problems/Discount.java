package stack.problems;

import java.util.Stack;

public class Discount {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i=prices.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()>=prices[i]){
                stack.pop();
            }
            int curr = prices[i];
            if(!stack.isEmpty()){
                prices[i] -= stack.peek();
            }
            stack.push(curr);
            System.out.println(stack);
        }
        return prices;
    }

    public static void main(String[] args) {
        Discount discount = new Discount();
        int[] price = discount.finalPrices(new int[]{8, 4, 6, 2, 3});
        for(int p: price){
            System.out.print(p+" ");
        }
    }
}
