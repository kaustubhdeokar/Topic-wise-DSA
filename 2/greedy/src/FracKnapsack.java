import java.util.Comparator;
import java.util.PriorityQueue;

public class FracKnapsack {

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n)
    {
        Comparator<Item> compareDensity = (i1, i2) -> Double.compare
                ((double)i2.value/(double)i2.weight, (double)i1.value/(double)i1.weight);

        PriorityQueue<Item> q = new PriorityQueue<>(compareDensity);

        for(Item item: arr){
            q.add(item);
        }

        double currWeight = 0;
        double currValue = 0;

        while(!q.isEmpty() && currWeight<W){
            Item currItem = q.poll();

            if((currWeight + currItem.weight) < W){
                currWeight +=currItem.weight;
                currValue += currItem.value;
            }
            else{
                currValue += (((double)(W-currWeight))/((double)(currItem.weight)))*1.0*currItem.value;
                currWeight = W;
                break;
            }

        }
        return currValue;
    }

    public static void main(String[] args) {

        /*

        N = 3, W = 50
        values[] = {60,100,120}
        weight[] = {10,20,30}

         output 240.

        * */

    }
}
