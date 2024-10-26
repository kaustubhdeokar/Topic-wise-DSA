package linkedlist.problems;

import linkedlist.LLNode;
//leetcode pod sep 10.
public class InsertGcd {

    
    public LLNode insertGreatestCommonDivisors(LLNode head) {

        LLNode temp = head;
        while(temp.next!=null){
            int first = temp.val;
            int second = temp.next.val;
            int gcd = gcd(first, second);
            LLNode newNode = new LLNode(gcd);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        return head;

    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        InsertGcd insertGcd = new InsertGcd();
        LLNode llNodeList = new LLNode().createLLNodeList(new int[]{18, 6, 10, 3});
        LLNode llNode = insertGcd.insertGreatestCommonDivisors(llNodeList);
        llNode.print();

    }

}
