Leetcode problem: 
[Valid mountain array](https://leetcode.com/problems/valid-mountain-array/)
	
> My approach:
 1. to find the max element.
 2. See that it's not the last or the first.
 3. then verify the rising pattern till the maxElem, or falling pattern after that.
	
```

    public static boolean validMountainArray(int[] arr) {
        
        int arrLen = arr.length;
        if(arrLen<3){
            return false;
        }
        int index = 0;
        int maxElem = arr[index];
        for(int i=1;i<arrLen;i++){
            if(arr[i]>maxElem){
                index = i;
                maxElem = arr[i];
            }
        }
        if(index==0 || index == arrLen-1){
            return false;
        }
        //max element is at index = index
        for(int i=1;i<index;i++){
            if(arr[i]<=arr[i-1]){
                return false;
            }
        }
        for(int i=index;i<arrLen-1;i++){
            if(arr[i]<=arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
```

> But this is done in two pass. Can be done in a single pass as follows.


	1. Iterate through the array with increasing number condition
	2. Check if it's not the first or the last element.
	3. Iterate through the array with decreasing number condition.
	4. Check that it should be the last element.

```
public static boolean validMountainArray(int[] arr) {

        int i=0;
        int arrLen = arr.length;
        while(i+1<arrLen && arr[i]<arr[i+1])
            i++;

        if(i==0 || i==arrLen-1){
            return false;
        }

        while(i+1<arrLen && arr[i]>arr[i+1])
            i++;

        return arrLen-1==i;

    }
    
```

