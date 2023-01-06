 private static void nearestSmallerToLeft(int[] arr) {

    static List<Integer> leftSmaller(int n, int a[])
    {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int num:a){
            
            if(stack.isEmpty()){
                result.add(-1);
            }    
            
            else if(stack.peek()<num){
                result.add(stack.peek());
            }
            
            else if(stack.peek()>=num){
            
                while(!stack.isEmpty() && stack.peek()>=num){
                    stack.pop();
                }
            
                if(stack.isEmpty()){
                    result.add(-1);
                }
                else{
                    result.add(stack.peek());
                }
            }
            
            stack.add(num);
        }
        
        return result;
    }
 }
