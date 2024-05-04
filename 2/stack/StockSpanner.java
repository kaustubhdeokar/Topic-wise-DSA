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

    }

    public StockSpanner() {
        index = 0;
    }

    public int next(int price) {

        int stocksSmallerThanCurrent;
        while (!stack.isEmpty() && stack.peek().price < price) {
            stack.pop();
        }

        if(stack.isEmpty()){
            stocksSmallerThanCurrent = index + 1;
        }
        else{
            stocksSmallerThanCurrent = index - stack.peek().index;
        }
                
        stack.push(new MapPriceToIndex(price, index));
        index+=1;
        return stocksSmallerThanCurrent;

    }

    public static void main(String[] args) {

        StockSpanner spanner = new StockSpanner();
        int[] arr = { 100, 80, 60, 75, 60, 40, 90 };
        for (int i : arr) {
            System.out.print(spanner.next(i) + " ");
        }

    }
}
