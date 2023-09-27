import java.util.ArrayDeque;

class StackUsingQueue {

    ArrayDeque<Integer> queue = null;

    public StackUsingQueue() {
        queue = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        return queue.removeLast();
    }

    public int top() {
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

// Method 2.

class MyStack {

    class Queue {

        int[] queue;
        int top = 0;
        int bottom = 0;

        Queue() {
            queue = new int[100];
        }

        void push(int x) {
            queue[top++] = x;
        }

        int popFirst() {
            if (isEmpty())
                return -1;
            return queue[bottom++];
        }

        int popLast() {
            if (isEmpty())
                return -1;
            top -= 1;
            return queue[top];
        }

        boolean isEmpty() {
            return top == bottom;
        }

        int top() {
            return queue[top - 1];
        }
    }

    Queue queue;

    public MyStack() {
        queue = new Queue();
    }

    public void push(int x) {
        queue.push(x);
    }

    public int pop() {
        return queue.popLast();
    }

    public int top() {
        return queue.top();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}