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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }

        if(head.next == null){
            return true;
        }

        if(head.next.next == null){
            if(head.val != head.next.val){
                return false;
            }else{
                return true;
            }
        }
 
        ListNode fast = head;
        ListNode slow = head;


        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

            slow = slow.next;
            ListNode x = rev(head,slow);
            if(fast.next == null){
                x=x.next;
            }

            while(slow != null){
                if(x.val == slow.val){
                    slow = slow.next;
                    x = x.next;
                }else{
                    return false;
                }
            }

            return true;




        
}

public ListNode rev(ListNode head, ListNode slow){

        ListNode temp = null;

        while(head != slow){
            ListNode next1 = head.next;
            head.next = temp;
            temp = head;
            head = next1;

        }

        return temp;

    }
}