import java.util.PriorityQueue;
import java.util.Comparator;

public class KClosest {
    
    static class MapNumToDiff{
        int num;
        int diff;

        MapNumToDiff(int num, int diff){
            this.num = num;
            this.diff = diff;
        }
        @Override
        public String toString(){
            return "num:"+num+" diff:"+diff;
        }
    }
    
    public static void main(String[] args) {
        
        //k closest to x, 3 numbers closest to 5. 
        int[] num = new int[]{10, 2, 14, 4, 7, 6};
        int x = 5;
        int k = 3;
            
        Comparator<MapNumToDiff> comparator = (m1, m2) -> Integer.compare(m2.diff, m1.diff);
        PriorityQueue<MapNumToDiff> queue = new PriorityQueue<>(k+1, comparator);
        
        for(int i: num){
            queue.add(new MapNumToDiff(i, Math.abs(x-i)));
            if(queue.size()>k){
                MapNumToDiff polled = queue.poll();
                System.out.println("removed:"+polled.toString());
            }
        }
        
        while(!queue.isEmpty()){
            System.out.println(queue.poll().toString());
        }

    }
}
