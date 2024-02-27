package recursion;

public class TailRecursiveFactorial {
    
    public static int factorial(int n){
        int[] ans = {1};
        factorial(1, n, ans);
        return ans[0];
    }

    public static void factorial(int start, int max, int[] ans){
        if(start>max) return;
        ans[0]*=start;
        factorial(start+1, max, ans);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(naturalNumberSum(5, 0));
        System.out.println(pallindromeUsingRecursion("abccba"));
    }

    public static int naturalNumberSum(int n, int ans){
        if(n==0) return ans;
        return naturalNumberSum(n-1, n+ans);
    }

    public static boolean pallindromeUsingRecursion(String s){
        return pallindromeUsingRecursion(s, 0, s.length()/2);
    }

    public static boolean pallindromeUsingRecursion(String s, int iter, int mid){
        if(iter==mid) return true;
        if(s.charAt(iter)!=s.charAt(s.length()-iter-1)) return false;
        return pallindromeUsingRecursion(s, iter+1, s.length());
    }

}
