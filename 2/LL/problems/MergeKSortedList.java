public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode answer = new ListNode(0);
        ListNode head = answer;

        for(int i=0;i<lists.length;i++){
            ListNode curr = lists[i];
            answer = addIntoAnswer(answer,curr);
        }

        return mergeSort(head.next);

    }

    public ListNode addIntoAnswer(ListNode answer, ListNode curr){

        while(curr != null){
            answer.next = new ListNode(curr.val);
            answer = answer.next;
            curr = curr.next;
        }
        return answer;

    }

    public ListNode mergeSort(ListNode head){

        if(head ==null || head.next == null){
            return head;
        }

        ListNode mid = findMidOfListNode(head);
        ListNode left = createList(head,mid);
        ListNode right = createList(mid,null);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);

    }

    public ListNode createList(ListNode start, ListNode end){
        ListNode newHead = new ListNode(0);
        ListNode resHead = newHead;
        while(start!=end){
            newHead.next = new ListNode(start.val);
            start = start.next;
            newHead = newHead.next;
        }
        return resHead.next;
    }

    public ListNode merge(ListNode first,ListNode second){

        ListNode newHead = new ListNode(0);
        ListNode resHead = newHead;

        while(first!=null && second!=null){
            if(first.val<=second.val){
                newHead.next = new ListNode(first.val);
                first = first.next;
            }
            else{
                newHead.next = new ListNode(second.val);
                second = second.next;
            }
            newHead = newHead.next;
        }
        while(first!=null){
            newHead.next = new ListNode(first.val);
            first = first.next;
            newHead = newHead.next;
        }
        while(second!=null){
            newHead.next = new ListNode(second.val);
            second = second.next;
            newHead = newHead.next;
        }
        return resHead.next;
    }

    public ListNode findMidOfListNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
