package stack.StackWithIncOperator;

class CustomStack {
    
    int[] array;
    int size = 0;
    int top = 0;
    int[] incrArr;
    int maxAllowedSize;
    
    public CustomStack(int maxSize) {
        array = new int[maxSize];        
        incrArr = new int[maxSize];
        maxAllowedSize = maxSize;
        
    }
    
    public void push(int x) {
        
        if(size>=maxAllowedSize)
            return;
        
        size+=1;
        array[top] = x;
        top+=1;
        
    }
    
    public int pop() {
        if(size==0)
            return -1;

        top-=1;
        size-=1;
        
        if(incrArray[top]==0) 	  
	        return array[top]; //[0,0,100] ->popped 0
   		else{
   			if(size>0) // negative handle case.
	   			incrArray[top-1]+=incrArray[top];
	   		int result = incrArray[top]+array[top];
	   		//mistake no 3!!!!
	   		incrArray[top] = 0;
//	   		after that increment is used, popped element's index should RESET THE COUNT TO ZERO
	   		return result;	
   		}
    }
    
    public void increment(int k, int val) {
        int indexToIncr = Integer.min(k,size)-1; 
    	//mistake 1 -> handle negative here.
    	if(indexToIncr>=0)
        incrArray[indexToIncr] += val; // [0,0,100,0]
    }
    
}

