package linkedlist.problems;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
    }

    public ListNode() {

    }

    public ListNode createList(int... nums) {
        ListNode head = new ListNode(-1);
        ListNode result = head;
        for (int n : nums) {
            head.next = new ListNode(n);
            head = head.next;
        }
        return result.next;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode reverseInK(ListNode node, int k) {
        ListNode nextHead = node;
        ListNode newHead = new ListNode(-1);
        ListNode res = newHead;
        int k1 = k;
        while (nextHead != null) {
            ListNode tempHead = nextHead;
            ListNode curr = nextHead;
            ListNode prev = null;
            while (nextHead != null && k1 > 0) {
                nextHead = nextHead.next;
                k1 -= 1;
            }
            if (nextHead != null) {
                //reverse curr to nextHead.
                ListNode reversedLL = reverse(curr, prev, nextHead);
                newHead = addToNewHead(newHead, reversedLL);
                k1=k;
            }
            else{
                newHead.next = tempHead;
            }
        }
        return res.next;
    }

    private ListNode addToNewHead(ListNode newHead, ListNode reversedLL) {
        newHead.next = reversedLL;
        while(newHead.next!=null) newHead = newHead.next;
        return newHead;
    }

    //  <-1 <-2 <-3 4  5
    //p            nh
    public ListNode reverse(ListNode curr, ListNode prev, ListNode nextHead){
        if(curr == nextHead){
            return prev;
        }
        ListNode newHead = reverse(curr.next, curr, nextHead);
        curr.next = prev;
        return newHead;
    }


    public void print() {
        print(this);
    }
}
