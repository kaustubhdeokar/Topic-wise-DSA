import java.util.ArrayDeque;

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
class ReorderList {
    public void reorderList(ListNode head) {
        
        if(head.next==null)
            return;
        
        ListNode mid = findMid(head);
        
        ListNode prevMid = head;
        while(prevMid.next!=mid)
            prevMid = prevMid.next;
        
        prevMid.next = reverseFrom(mid);
        
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode start = head;
        ListNode fakeMid = prevMid.next;
        mid = fakeMid;
        
        while(start!=mid && fakeMid!=null){
            stack.add(start);
            stack.add(fakeMid);
            start = start.next;
            fakeMid = fakeMid.next;
        }
        
        head = createList(stack);
        
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
    
    public ListNode createList(ArrayDeque<ListNode> queue){
    
        ListNode dummyHead = queue.removeFirst();
        ListNode tail = dummyHead;
        
        
        while(!queue.isEmpty()){
            tail.next = queue.remove();
            tail = tail.next;
        }
        return dummyHead;
    }
    
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
