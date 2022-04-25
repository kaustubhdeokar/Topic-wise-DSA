


    public Node reverseRecursively(Node head) {
        return reverseRecursively(head, null);
    }

    private Node reverseRecursively(Node head, Node prev) {

        if (head == null)
            return prev;

        Node nextNode = head.next;
        head.next = prev;
        return reverseRecursively(nextNode, head);

    }
    
    
    public static void main(String[] args) {
        MergeRecursively l1 = new MergeRecursively();
        l1.insert(1);
        l1.insert(3);
        l1.insert(5);

        l1.head = l1.reverseRecursively(l1.head);
        l1.print();

    }

