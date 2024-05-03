package LL.problems;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode newNode = new ListNode();
        newNode.next = head;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode resHead = next;
        while (curr != null && next != null) {

            newNode.next  = curr.next;
            curr.next = next.next;
            next.next = curr;

            newNode = curr;
            curr = curr.next;
            if(curr!=null){
                next = curr.next;
            }
        }
        return resHead;
    }

}
