//https://leetcode.com/problems/remove-nodes-from-linked-list/description/

public class RemoveNodes{
    public ListNode removeNodes(ListNode head) {
        ListNode newHead = reverse(head);
        //System.out.println(newHead.val);
        ListNode newHeadNext = newHead.next;

        ListNode trimmedList = new ListNode(newHead.val);
        ListNode trimmedListPtr = trimmedList;

        while(newHeadNext!=null){
            while(newHeadNext !=null && newHeadNext.val < newHead.val){
                //System.out.println("val:"+newHeadNext.val +" less than "+newHead.val);
                newHeadNext = newHeadNext.next;
            }
            if(newHeadNext!=null){
                trimmedListPtr.next = new ListNode(newHeadNext.val);
                trimmedListPtr = trimmedListPtr.next;
                //System.out.println("adding val:"+trimmedListPtr.val);
                newHead = newHeadNext;
                newHeadNext = newHeadNext.next;
            }
        }

        //print(trimmedList);

        ListNode result = reverse(trimmedList);

        return result;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}