public class ReverseRange {


    public ListNode reverseBetween(ListNode head, int left, int right) {

        int leftIndex = 1;
        int rightIndex = 1;

        ListNode leftHead = head;
        ListNode rightHead = head;
        ListNode prevToLeft = new ListNode(Integer.MIN_VALUE);

        while (left > leftIndex) {
            prevToLeft = leftHead;
            leftHead = leftHead.next;
            leftIndex += 1;
        }

        while (right > rightIndex) {
            rightHead = rightHead.next;
            rightIndex += 1;
        }

        if (leftHead == rightHead) {
            return head;
        }

        ListNode nextToRight = rightHead.next == null ? null : rightHead.next;

        prevToLeft.next = reverse(leftHead, rightHead, nextToRight);

        if (prevToLeft.val == Integer.MIN_VALUE) {
            leftHead.next = nextToRight;
            prevToLeft = prevToLeft.next;
            return prevToLeft;
        } else {
            leftHead.next = nextToRight;
        }

        return head;
    }

    public ListNode reverse(ListNode left, ListNode right, ListNode nextToRight) {


        ListNode prev = null;
        ListNode curr = left;
        ListNode next = curr.next;

        do {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) next = next.next;
        } while (curr != right);

        curr.next = prev;
        return curr;


    }

}