package stack.StackWithIncOperator;// Design a Stack With Increment Operation

//Implement stack with an extra operation
/*
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.

*/

//BruteForceSol.

class CustomStack {
    
    int[] array;
    int size = 0;
    int top = 0;
    int maxAllowedSize;
    
    public CustomStack(int maxSize) {
        array = new int[maxSize];        
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
        return array[top];
    }
    
    public void increment(int k, int val) {
        int elemsToIncr = Integer.min(k,size);
        for(int i=0;i<elemsToIncr;i++){
            array[i]+=val;
        }
    }
}

