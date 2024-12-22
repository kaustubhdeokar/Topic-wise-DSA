package array.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinLength {

    public int minLength(String s, int numOps) {

        int start = -1;
        int end = -1;
        char prev = '2';
        char curr = '2';
        Comparator<int[]> comp = (c1, c2) -> Integer.compare(c2[1]-c2[0], c1[1]-c1[0]);
        Queue<int[]> q = new PriorityQueue<>(comp);
        for(int i=0;i<s.length();i++){
            curr = s.charAt(i);
            if(prev!=curr){
                end = i-1;
                if(end!=-1 && (end-start)>1){
                    q.add(new int[]{start, end});
                }
                start = i;
                prev = curr;
            }
        }

        q.add(new int[]{start, s.length()-1});

        int ops = 0;
        while(!q.isEmpty() && ops < numOps){
            int[] top = q.remove();
            start = top[0];
            end = top[1];
            System.out.println(start+":"+end);
            if(end-start<=1) continue;
            int mid = start + (end-start) /2;
            q.add(new int[]{start, mid-1});
            q.add(new int[]{mid+1, end});
            ops +=1;
        }
        if(q.isEmpty()){
            return 1;
        }
        // else{
        //     int[] top = q.remove();
        //     return top[1] - top[0];
        // }
        System.out.println("post");
        while(!q.isEmpty()){
            int[] top = q.remove();
            start = top[0];
            end = top[1];
            System.out.println(start+":"+end);
        }
        return -1;
    }

    public static void main(String[] args) {

        MinLength min = new MinLength();
        min.minLength("000010000",2);

    }
}
