import java.util.*;

public class ReverseNodesInKGroup{

    class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode currHead = head;
        ListNode resultList = new ListNode(0);
        ListNode resultListPtr = resultList;

        while(currHead!=null){

            ListNode kthList = new ListNode(0);
            ListNode kthListPtr = kthList;
            int currNodeCount = 0;

            while(currHead!=null && currNodeCount<k){
                kthListPtr.next = new ListNode(currHead.val);
                kthListPtr = kthListPtr.next;
                currHead = currHead.next;
                currNodeCount += 1;
            }
            
            if(currNodeCount==k){
                resultListPtr.next = reverse(kthList.next);    
            }
            else{
                resultListPtr.next = kthList.next;
            }

            while(resultListPtr.next!=null){
                resultListPtr = resultListPtr.next;
            }
        }
        
        return resultList.next;
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
}