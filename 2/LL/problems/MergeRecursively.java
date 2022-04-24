package linkedlist;

//https://leetcode.com/problems/merge-two-sorted-lists/discuss/1978528/Java-faster-than-100.00-o(n)-time-and-o(1)-space-Recursively-Merging-into-the-first-Linked-list

public class MergeRecursively {

    Node head;

    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node mergeRecursively(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //1 3 5
        if (head1.data <= head2.data) {
            head1.next = mergeRecursively(head1.next, head2);
            System.out.println("head1 data:" + head1.data);
        }
        //1 2 4
        else { //head2 is smaller

            Node newNode = new Node(head2.data);
            newNode.next = mergeRecursively(head1, head2.next);
            return newNode;
        }

        return head1;

    }

    public Node mergeWithNewList(Node head1, Node head2) {

        Node newHead = new Node(0);
        Node tail = newHead;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 == null)
            tail.next = head2;
        else
            tail.next = head1;

        return newHead.next;
    }


    public static void main(String[] args) {
        MergeRecursively l1 = new MergeRecursively();
        l1.insert(1);
        l1.insert(3);
        l1.insert(5);
        l1.insert(7);
        l1.insert(8);

        MergeRecursively l2 = new MergeRecursively();
        l2.insert(1);
        l2.insert(2);
        l2.insert(4);

        l1.head = l1.mergeWithNewList(l1.head, l2.head);
        l1.print();



    }

}

