// https://leetcode.com/problems/linked-list-cycle-ii/

// Floyd's Tortoise and Hare Algo or Linked List Cycle Algo

//We Keep 2 pointers sptr and fptr, fptr moves 2 places while sptr moves 1.
//If they collide, then there is cycle in a linked list.

//Now bring bring fptr to the head and keep sptr at point of collision.
//Start moving both pointers by one step and where they meet is the node where cycle begins.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head)
    {
        ListNode sptr=head,fptr=head;
        while(fptr!=null)
        {
            sptr = sptr.next;
            fptr = fptr.next;
            if(fptr==null)
                return null;
            fptr = fptr.next;
            
            if(sptr == fptr)
            {
                break;
            }    
        }
        if(fptr==null)
            return null;
        
        fptr = head;
        while(sptr != fptr)
        {
            sptr = sptr.next;
            fptr = fptr.next;
        }
        
        return sptr;
    }
}