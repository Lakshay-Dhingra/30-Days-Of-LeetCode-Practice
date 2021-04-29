// https://leetcode.com/problems/remove-element/

class Solution {
    public int removeElement(int[] nums, int val)
    {
        int i=0;
        int len=nums.length;
        while(i<len)
        {
            if(nums[i] == val)
            {  
                for(int j=i+1;j<len;j++)
                {
                    nums[j-1] = nums[j];
                }
                len--;
            }
            else
            {
                i++;
            }
        }
        return len;
    }
}