//https://leetcode.com/problems/add-two-numbers-ii/submissions/882939271/

import java.util.*;

public class AddTwoNumbers2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode resultPtr = null;

        int node1Length = length(l1);
        int node2Length = length(l2);
        int lengthDiff = Math.abs(node2Length - node1Length);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<Integer.max(node1Length, node2Length);i++){
            list.add(0);
        }

        if(node1Length > node2Length){
            addTwoNumbers(l1, l2, list, lengthDiff);
        }
        else{
            addTwoNumbers(l2, l1, list, lengthDiff);
        }

        int carry = 0;

        for(int i=list.size()-1;i>=0;i--)
        {
            int val = (list.get(i)+carry)%10;
            carry = (list.get(i)+carry)/10;
            //System.out.println("val:"+val+" carry:"+carry);
            ListNode newNode = new ListNode(val);
            newNode.next = resultPtr;
            resultPtr = newNode;
        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = resultPtr;
            resultPtr = newNode;
        }

        return resultPtr;
    }

    public void addTwoNumbers(ListNode l1, ListNode l2, ArrayList<Integer> list, int lengthDiff){
        int carry = 0;
        int i=0;
        for(i=0;i<lengthDiff;i++){
            list.set(i, l1.val);
            l1 = l1.next;
        }

        while(l1!=null && l2!=null){
            int val = l1.val + l2.val;
            list.set(i, val);
            i+=1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            System.out.println("l1 val:"+l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            System.out.println("l2 val:"+l2.val);
            l2 = l2.next;
        }
    }

    public int length(ListNode l){
        int len = 0;
        while(l!=null){
            len += 1;
            l = l.next;
        }
        return len;
    }

    public ListNode reverse(ListNode head) {
        
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
}
