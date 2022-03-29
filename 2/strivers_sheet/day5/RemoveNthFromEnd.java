class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data=data;
        this.next = null;
    }
}

public class RemoveNthFromEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        
        while(temp!=null){
            count+=1;
            temp = temp.next;
        }
        
        if(count==1)
            return null; // one and only one. 
        
        if(count==n)
            return head.next; //first node case.
        
        count-=n;
        
        int i=1;
        ListNode temp2 = head;
        while(i < count){
            i++;
            temp2 = temp2.next;
            
        }        
        temp2.next = temp2.next.next;
        
        return head;
        
    }

}
