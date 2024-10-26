package linkedlist.problems;

public class Reverse {

    public ListNode reverse(ListNode l1) {
        return reverse(l1, null);
    }

    public ListNode reverse(ListNode curr, ListNode prev) {

        if (curr == null) {
            return prev;
        }
        ListNode ans = reverse(curr.next, curr);
        curr.next = prev;
        return ans;
    }

}
