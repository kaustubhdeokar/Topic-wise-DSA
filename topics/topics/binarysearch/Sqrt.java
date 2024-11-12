package binarysearch;

public class Sqrt {

    public int mySqrtForIntOverflow(int x) {

        int start = 1;
        int end = x;
        int res=0;

        while(start<=end){
            int mid = start + (end-start)/2;
            int xmid = x/mid;
            if(xmid==mid) return mid;
            else if(xmid<mid){
                end = mid - 1;
            }
            else {
                res = mid;
                start = mid +1;
            }


        }
        return res;
    }

    public int mySqrt(int x) {

        int start = 1;
        int end = x;
        int res=0;

        while(start<=end){
            int mid = start + (end-start)/2;
            long square = mid*mid;
            System.out.println("mid:"+mid+" sq:"+square);
            if(square==x) return mid;
            else if(square>x || square<0){
                end = mid - 1;
            }
            else {
                res = mid;
                start = mid +1;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrtForIntOverflow(2147395599));
    }
}
