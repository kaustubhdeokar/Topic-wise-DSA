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
class PallindromeLL {
    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null)
            return true;
        
        ListNode mid = middle(head);
        
        ListNode prevMid = head;
        while(prevMid.next!=mid)
            prevMid = prevMid.next;
        
        prevMid.next = reverseFrom(mid);
        
        ListNode start = head;
        ListNode fakeMid = prevMid.next;
        mid = fakeMid;

        while(start!=mid && fakeMid!=null){
            if(start.val!=fakeMid.val){
                return false;
            }
            start = start.next;
            fakeMid = fakeMid.next;
        }
        
        return true;
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
