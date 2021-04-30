// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode nptr = head;
        int i=1;
        while(nptr!=null)
        {
            if(i == n)
            {
                break;
            }
            nptr=nptr.next;
            i++;
        }
        
        ListNode cur = head;
        ListNode parent = null;
        
        while(nptr.next!=null)
        {
            nptr = nptr.next;
            parent = cur;
            cur = cur.next;
        }
        
        if(cur == head)
        {
            return head.next;
        }
    
        parent.next = cur.next;
        return head;
    }
}