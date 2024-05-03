package graph.rev;

import java.util.*;

public class ArrayDequePrac{
    public static void main(String[] args){
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((Pair p1, Pair p2)-> Integer.compare(p2.dist, p1.dist));
        q.add(new Pair(1,4));
        q.add(new Pair(2,3));
        q.add(new Pair(3,2));
        q.add(new Pair(4,1));

        System.out.println(q.remove().toString());

        q.add(new Pair(1,5));

        System.out.println(q.remove().toString());
        
        
        ArrayDeque<Pair> q1 = new ArrayDeque<>();
        q1.add(new Pair(1,2));
        System.out.println(q1.remove());
        
    }
}
