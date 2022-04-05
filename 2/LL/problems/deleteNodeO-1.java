//this can only work when we don't have to delete the last node. 

 public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }