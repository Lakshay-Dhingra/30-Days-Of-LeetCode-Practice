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

// I will use recursive approach here rather than reversing the list using 3 ptr theorem.
// So, this solution has more space complexity.... O(max(n,m))
class Solution
{
    private static int findLength(ListNode head)
    {
        ListNode cur = head;
        int len = 0;
        while(cur!=null)
        {
            len++;
            cur = cur.next;
        }
        return len;
    }
    private static int addNums(ListNode ptr1, ListNode ptr2)
    {
        if(ptr1 == null)
        {
            return 0;
        }

        int carry = addNums(ptr1.next, ptr2.next);
        int ans = carry + ptr1.val + ptr2.val;
        if(ans<10)
        {
            ptr1.val = ans;
            return 0;
        }
        else
        {
            ptr1.val = ans-10;
            return 1;
        }
    }
    private static int addOne(ListNode cur, ListNode ptr1)
    {
        if(cur == ptr1)
        {
            return 1;
        }
        int carry = addOne(cur.next, ptr1);
        int ans = carry + cur.val;
        if(ans<10)
        {
            cur.val = ans;
            return 0;
        }
        else
        {
            cur.val = ans-10;
            return 1;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int diff = findLength(l1) - findLength(l2);
        ListNode temp;
        if(diff<0)
        {
            temp=l1;
            l1=l2;
            l2=temp;
            diff = -1*diff;
        }
        //Now L1 will always be longer or equal than L2 in length 
        if(l2 == null)
            return l1;
        
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        
        for(int i=0;i<diff;i++)
        {
            ptr1 = ptr1.next;
        }
        
        int carry = addNums(ptr1, ptr2);
        if(carry == 1)
        {
            carry = addOne(l1, ptr1);
            if(carry==1)
            {
                temp = new ListNode(1);
                temp.next = l1;
                l1 = temp;
            }
        }
        return l1;
    }
}