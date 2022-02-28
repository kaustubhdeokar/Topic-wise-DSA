private static void nearestGreatestToLeft(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] leftHighest = new int[arr.length];

        //base case. for the first element. 
        leftHighest[0] = -1;
        stack.push(arr[0]);
  
      
        for (int i = 1; i < arr.length; i++) {
            boolean leftHighestFound = false;
      
            while (!stack.empty()) {
                //find the stack element greater than current array element.  
                if (stack.peek() > arr[i]) {
                    
                    leftHighest[i] = stack.peek();
                    stack.push(arr[i]);
                    leftHighestFound = true;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (!leftHighestFound) {
                //if not found, then current element is greater than all stack elements. 
                stack.push(arr[i]);
                leftHighest[i] = -1;
            }
        }

        for (Integer i : leftHighest) {
            System.out.print(i + " ");
        }
    }
