
    public int lengthOfCycle(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next.next;

            if (fast == slow) {
                //loop exists. 
                //slow and fast reaches at the same point. 
                //hence increment slow by 1 till it doesn't reach fast. 
                int length = 0;
                do {
                
                    slow = slow.next;
                    length += 1;
                }
                while (slow != fast);
                return length;
            }

        }
        return 0; //loop not present. 

    }
