package LL.problems;//https://leetcode.com/problems/add-two-numbers/submissions/882898545/

import java.util.*;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode(0);
        ListNode resultPtr = result;

        int carry = 0;
        while(l1!=null && l2!=null){
            
            resultPtr.next = new ListNode((l1.val+l2.val+carry)%10);
            resultPtr = resultPtr.next;
            
            carry = (l1.val + l2.val + carry)/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            resultPtr.next = new ListNode((l1.val+carry)%10);
            resultPtr = resultPtr.next;
            carry = (l1.val + carry)/10;
            l1 = l1.next;
        }
        while(l2!=null){
            resultPtr.next = new ListNode((l2.val+carry)%10);
            resultPtr = resultPtr.next;
            carry = (l2.val + carry)/10;
            l2 = l2.next;
        }
        if(carry > 0){
            resultPtr.next = new ListNode(carry);
        }

        return result.next;    


    }
}
