package LL.problems;

public class SwapKthFromStartAndEnd {

    public int length(ListNode head) {
        int l = 0;
        while (head != null) {
            head = head.next;
            l += 1;
        }
        return l;
    }

    public ListNode swapPairs(ListNode head, int k) {

        int length = length(head);
        if (k == length) {
            k = 1;
        } else if (k > (length / 2)) {
            k = Integer.min(k, length - k + 1);
        }


        ListNode curr = head;
        ListNode prev = new ListNode();
        prev.next = curr;
        int kTemp = k;

        ListNode kthprev = prev;
        ListNode kth = head;
        ListNode counterNode = head;

        while (k > 1) {

            prev = prev.next;
            curr = curr.next;
            counterNode = counterNode.next;
            k -= 1;
        }

        while (counterNode.next != null) {
            counterNode = counterNode.next;
            kthprev = kthprev.next;
            kth = kth.next;
        }

        ListNode kthNext = kth.next;
        if (curr.next != kth) {
            kth.next = curr.next;
        } else {
            kth.next = prev.next;
        }
        kthprev.next = curr;
        curr.next = kthNext;
        prev.next = kth;

        if (kTemp == 1)
            return prev.next;
        else
            return head;

    }
}
