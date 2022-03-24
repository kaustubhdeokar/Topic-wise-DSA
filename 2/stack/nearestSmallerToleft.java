 private static void nearestSmallerToLeft(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] leftHighest = new int[arr.length];

        leftHighest[0] = -1;
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            boolean leftHighestFound = false;
            while (!stack.empty()) {
                if (stack.peek() < arr[i]) {
                    leftHighest[i] = stack.peek();
                    stack.push(arr[i]);
                    leftHighestFound = true;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (!leftHighestFound) {
                stack.push(arr[i]);
                leftHighest[i] = -1;
            }
        }

        for (Integer i : leftHighest) {
            System.out.print(i + " ");
        }
    }
