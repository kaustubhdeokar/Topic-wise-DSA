//leetcode - under check, not all testcases passing. 

class StockSpanner {

    static ArrayList<Integer> stockList = new ArrayList<>();
    static Stack<Integer> stocksGreaterThanCurrent = new Stack<>();
    static Stack<Integer> stocksSmallerThanCurrent = new Stack<>();

    int currentCount;

    public StockSpanner() {
    }

    public int next(int price) {
        currentCount = 1;

        while (!stocksGreaterThanCurrent.isEmpty() && stocksGreaterThanCurrent.peek() < price) {
            currentCount += 1;
            Integer lesserThanCurr = stocksGreaterThanCurrent.pop();
            stocksSmallerThanCurrent.push(lesserThanCurr);

        }
        while (!stocksSmallerThanCurrent.empty()) {
            stocksGreaterThanCurrent.push(stocksSmallerThanCurrent.pop());
        }
        stocksGreaterThanCurrent.push(price);

        System.out.println(currentCount);
        return currentCount;

    }
