package LL.problems;

import traversal.Node;

class mergeTwoSortedLL {

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedList newList = new SinglyLinkedList();
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                newList.insertNode(head1.data);
                head1 = head1.next;
            } else {
                newList.insertNode(head2.data);
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            newList.insertNode(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            newList.insertNode(head2.data);
            head2 = head2.next;
        }
        return newList.head;

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

}