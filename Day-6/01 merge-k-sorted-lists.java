// https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.*;

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

class Pair
{
    ListNode ln;
    int index;
    public Pair(ListNode ln, int index)
    {
        this.ln=ln;
        this.index = index;
    }
}

class NodeValueComparator implements Comparator
{
    public int compare(Object o1,Object o2)
    {   
        Pair p1 = (Pair)o1;
        Pair p2 = (Pair)o2;
        
        int val1 = p1.ln.val;
        int val2 = p2.ln.val;
        
        if(val1<val2)
        {
            return -1;
        }
        else if(val1>val2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }  
}

class Solution
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new NodeValueComparator());
        
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                 pq.add(new Pair(lists[i],i));
                 lists[i] = lists[i].next;
            }
        }
        
        Pair opPair = null;
        int opIndex = 0;
        ListNode head = null;
        ListNode cur = null;
        
        while(pq.size()>0)
        {
            //removing head of pq
            opPair=pq.poll();
            opIndex = opPair.index;
            
            //Adding next node of that list in priority queue
            if(lists[opIndex]!=null)
            {
                 pq.add(new Pair(lists[opIndex],opIndex));
                 lists[opIndex] = lists[opIndex].next;
            }
            
            if(head == null)
            {
                head = opPair.ln;
                cur = head;
            }
            else
            {
                cur.next = opPair.ln;
                cur = cur.next;
            }
        }
        
        if(cur!=null)
            cur.next = null;
        
        return head;
    }
}