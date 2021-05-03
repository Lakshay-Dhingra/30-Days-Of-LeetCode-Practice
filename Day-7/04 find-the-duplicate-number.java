// https://leetcode.com/problems/find-the-duplicate-number/

// Floyd's Tortoise and Hare Algo or Linked List Cycle Algo

//We Keep 2 pointers sptr and fptr, fptr moves 2 places while sptr moves 1.
//If they collide, then there is cycle in a linked list.

//In this case it is gauranteed to have a cycle because atleast one number is repeated twice.

//Now bring bring fptr to start and keep sptr at point of collision.
//Start moving both pointers by one step and where they meet is point of cycle or duplicate number in this case.

class Solution {
    public int findDuplicate(int[] nums)
    {
        int sptr=0,fptr=0;
        do
        {
            sptr = nums[sptr];
            fptr = nums[nums[fptr]];
        }while(sptr != fptr);
        //Now sptr is at point of intersection
        
        fptr = 0;
        while(sptr != fptr)
        {
            sptr = nums[sptr];
            fptr = nums[fptr];
        }
        
        return sptr;
        
    }
}