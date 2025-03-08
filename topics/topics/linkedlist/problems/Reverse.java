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

    public static void main(String[] args) {

        ListNode ll = new ListNode();
        ListNode list = ll.createList(1, 2, 3, 4, 5);
        list.print();
        ListNode listNode = list.reverseInK(list, 5);
        listNode.print();

    }

}
