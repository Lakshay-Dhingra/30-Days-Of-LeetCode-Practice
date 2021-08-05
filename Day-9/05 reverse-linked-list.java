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

//3-pointer Iterative Approach
// class Solution {
//     public ListNode reverseList(ListNode head)
//     {
//         if(head == null)
//             return head;
//         if(head.next == null)
//             return head;
//         ListNode prev = head;
//         ListNode cur = head.next;
//         head.next = null;
//         ListNode nex;
        
//         while(cur!=null)
//         {
//             nex = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = nex;
//         }
//         return prev;
//     }
// }

//Recursive Solution
class Solution {
    public ListNode reverseList(ListNode head)
    {
        if(head == null)
            return head;
        if(head.next == null)
            return head;
        ListNode newhead = head;
        while(newhead.next!=null)
            newhead = newhead.next;
        
        reverse(head);
        head.next = null;
        
        return newhead;
    }
    private ListNode reverse(ListNode head)
    {
        if(head.next == null)
            return head;
        ListNode prev = reverse(head.next);
        prev.next = head;
        return head;
    }
}