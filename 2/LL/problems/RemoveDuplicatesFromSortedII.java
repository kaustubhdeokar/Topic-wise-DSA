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
class RemoveDuplicatesFromSortedII {
    public ListNode deleteDuplicates(ListNode head) {
        
        //prev curr
        //prev.next && curr.next matches
            //data = prev.next
            //& while prev.next!=data
            //prev.next = prev.next.next;
        
        if(head==null)
            return head;
        if(head.next == null)
            return head;
        
        ListNode prev = new ListNode();//dummyNode.
        ListNode curr = head;
        prev.next = curr;
        ListNode tail = prev;
        
        
       
        while(curr!=null && curr.next!=null){
            
            if(prev.next.val == curr.next.val){
                int toRemove = prev.next.val;
                
                while(prev.next != null && prev.next.val == toRemove){
                    prev.next = prev.next.next;
                }
                curr = prev.next;
            }
            else{
                prev = curr;
                curr = curr.next;
            }            
           
        }
        
        return tail.next;
        
    }
}
