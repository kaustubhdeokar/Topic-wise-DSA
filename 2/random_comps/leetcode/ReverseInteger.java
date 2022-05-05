class Solution {
    public int reverse(int x) {
        
        if(x==Math.pow(-2,31)) // exceeds negative limit
            return 0;
        
                
        boolean toNegate = false;
        if(x<0){
            toNegate = true;
            x*=-1;
        }
        
        Double d = reverseNum(x);
        
        
        if(d.compareTo(Math.pow(2,31))==1) //exceeds positive limit.
            return 0;
        
        if(toNegate)
            d*=-1;
        
        return d.intValue();
        
    }
    
    private double reverseNum(int num) {
        if (Math.log(num) <= 0)
            return num;
        return num % 10 * (Math.pow(10, Math.floor(Math.log10(num)))) + reverseNum(num / 10);
    }
}
