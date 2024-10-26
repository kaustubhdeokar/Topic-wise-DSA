package linkedlist.problems;

public class AddTwoNumbers {

    public ListNode addTwoNums(ListNode ll1, ListNode ll2) {

        Reverse reverse = new Reverse();
        ll1.print();
        ll2.print();
        ListNode l1 = reverse.reverse(ll1);
        ListNode l2 = reverse.reverse(ll2);

        int carry = 0;
        ListNode l1temp = new ListNode(-1);
        ListNode result = l1temp;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            l1temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1temp = l1temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            l1temp.next = new ListNode(sum % 10);
            l1temp = l1temp.next;
            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            l1temp.next = new ListNode(sum % 10);
            l1temp = l1temp.next;
            carry = sum / 10;
            l2 = l2.next;
        }

        if (carry > 0) {
            l1temp.next = new ListNode(carry);
        }

        return result.next;

    }

    public static void main(String[] args) {

        ListNode master = new ListNode();
        ListNode list1 = master.createList(9, 9, 9, 9, 9, 9);
        ListNode list2 = master.createList(9, 9, 9, 9, 9, 8, 9);

        AddTwoNumbers add = new AddTwoNumbers();
        ListNode listNode = add.addTwoNums(list1, list2);

        Reverse reverse = new Reverse();
        ListNode result = reverse.reverse(listNode);
        result.print();
    }

}
