import java.util.*;

public class MinCostOfRopeJoin {
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(long num: arr){
            q.add(num);
        }
        long cost = 0;
        while(q.size()>=2){
            long currCost = q.poll() + q.poll();
            q.add(currCost);
            cost += currCost;
            if(q.size()==1)
                break;
        }
        return cost;
    }
}
