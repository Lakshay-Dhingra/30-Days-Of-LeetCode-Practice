// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }
        int sptr = 0;
        int fptr = 1;
        
        while(fptr<nums.length)
        {
            if(nums[sptr]!=nums[fptr])
            {
                sptr++;
                nums[sptr] = nums[fptr];
            }
            else
            {
                fptr++;
            }
        }
        
        return sptr+=1;
    }
}