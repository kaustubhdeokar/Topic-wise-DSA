
   PerformOperation isOdd = a -> {
        if(a%2!=0){
            return true;
        }
        return false;
    };

    public PerformOperation isOdd() {
    return isOdd;
    }
    PerformOperation isPrime = a -> {
         for(int i=2;i<Math.sqrt(a);i++){
            if(a%i==0)
                return false;
        }
        return true;
    };


    public PerformOperation isPrime() {
        return isPrime;
    }

    PerformOperation isPallindrome = a ->{

        String str = String.valueOf(a);
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) == str.charAt(str.length() - i -1)){
                continue;
            }
            else
                return false;
        }
        return true;
    };

    public PerformOperation isPalindrome() {
        return isPallindrome;
    }
}


