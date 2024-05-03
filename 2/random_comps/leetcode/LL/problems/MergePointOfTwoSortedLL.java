package LL.problems;

public class MergePointOfTwoSortedLL {


    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        int ll1Size = sizeOf(head1);
        int ll2Size = sizeOf(head2);

        int delta = Math.abs(ll1Size - ll2Size);

        if (ll1Size > ll2Size) {
            for (int i = 0; i < delta; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < delta; i++) {
                head2 = head2.next;
            }
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }

    static int sizeOf(SinglyLinkedListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size += 1;
        }
        return size;
    }


}