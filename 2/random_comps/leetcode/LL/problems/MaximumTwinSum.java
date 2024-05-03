package LL.problems;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MaximumTwinSum {
    
    public int pairSum(ListNode head) {
    
        ListNode mid = middle(head);
        
        ListNode prevMid = head;
        while(prevMid.next!=mid)
            prevMid = prevMid.next;
        
        prevMid.next = reverseFrom(mid);
        
        ListNode start = head;
        ListNode fakeMid = prevMid.next;
        mid = fakeMid;
        
        int maxSum = Integer.MIN_VALUE;
        
        while(start!=mid && fakeMid!=null){
            maxSum = Integer.max(maxSum,start.val+fakeMid.val);
            start = start.next;
            fakeMid = fakeMid.next;
        }
        
        return maxSum;
        
    }
    
     public ListNode reverseFrom(ListNode middle){
        ListNode prev = null;
        ListNode curr = middle;
        ListNode next = curr.next;
        
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null)
                next = next.next;
        }
        
        return prev;
        
    }
    
    
    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
}
