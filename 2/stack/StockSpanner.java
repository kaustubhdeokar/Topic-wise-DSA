import java.util.*;

class StockSpanner {

    static Stack<MapPriceToIndex> stack = new Stack<>();
    int index;

    class MapPriceToIndex {
        int price;
        int index;

        MapPriceToIndex(int index, int price) {
            this.index = index;
            this.price = price;
        }

        @Override
        public String toString() {
            return "price:" + price + " index:" + index;
        }
    }

    public StockSpanner() {
        index = 0;
    }

    public int next(int price) {

        //System.out.println("price:" + price + " index:" + index);

        if (stack.isEmpty() || price < stack.peek().price) {
            stack.push(new MapPriceToIndex(this.index, price));
            this.index += 1;
            return 1;
        }

        else {
            while (!stack.isEmpty() && stack.peek().price <= price) {
                stack.pop();
            }
            int answer;
            if (stack.isEmpty()) {
                answer = 0;
            } else {
                //System.out.println("stack peek" + stack.peek().toString());
                answer = index - stack.peek().index;
            }
            stack.push(new MapPriceToIndex(index, price));
            this.index += 1;
            return answer;

        }

    }

    public static void main(String[] args) {

        StockSpanner spanner = new StockSpanner();
        int[] arr = { 100, 80, 60, 75, 60, 40, 90 };
        for (int i : arr) {
            System.out.print(spanner.next(i) + " ");
        }

    }
}