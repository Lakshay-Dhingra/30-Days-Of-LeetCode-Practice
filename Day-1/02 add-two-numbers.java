// https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int sum=0;
        int carry = 0;
        ListNode prev=null;
        ListNode cur=null;
        ListNode head=null;
        while(l1 != null || l2 !=null)
        {
            if(l1 == null)
            {
                l1 = new ListNode(0, null);
            }
            
            if(l2 == null)
            {
                l2 = new ListNode(0, null);
            }
            
            sum = l1.val + l2.val + carry;
            carry=0;
            
            if(sum <10)
            {
                cur = new ListNode(sum);
                
                if(prev == null)
                    head = cur;
                else
                    prev.next = cur;
                
                prev = cur;
            }
            else
            {
                sum = sum-10;
                carry = 1;
                cur = new ListNode(sum);
                
                if(prev == null)
                    head = cur;
                else
                    prev.next = cur;
                
                prev = cur;
            }
            l1 = l1.next;
            l2= l2.next;
        }
        
        if(carry == 1)
        {
            cur = new ListNode(1, null);
            prev.next = cur;
        }
        
        return head;
    }
}