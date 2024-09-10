package linkedlist;

public class LLNode {
    public int val;
    public LLNode next;

    public LLNode(int val) {
        this.val = val;
    }

    public LLNode() {

    }

    public LLNode createLLNodeList(int[] arr) {
        if (arr.length == 0) return null;
        LLNode head = new LLNode(-1);
        LLNode temp = head;
        for (int i : arr) {
            temp.next = new LLNode(i);
            temp = temp.next;
        }
        return head.next;
    }

    public void print() {
        LLNode llNode = this;
        while (llNode != null) {
            System.out.print(llNode.val + " ");
            llNode = llNode.next;
        }
    }

}
