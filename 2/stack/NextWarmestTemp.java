package stack;

import java.util.Stack;

class Entry {
    int pos;
    int temp;

    Entry(int pos, int temp) {
        this.pos = pos;
        this.temp = temp;
    }
}

public class NextWarmestTemp {


    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Entry> stack = new Stack<>();
        int[] results = new int[temperatures.length];

        for (int i = temperatures.length-1; i > -1; i--) {

            while (!stack.isEmpty() && stack.peek().temp <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.empty())
                results[i] = stack.peek().pos - i;
            else
                results[i] = 0;

            stack.push(new Entry(i,temperatures[i]));

        }

        return results;
    }

    public static void main(String[] args) {

        NextWarmestTemp temp = new NextWarmestTemp();
        int[] results = temp.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        for(int i:results){
            System.out.print(i+" ");
        }
    }


}
