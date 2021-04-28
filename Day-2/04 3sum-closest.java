// https://leetcode.com/problems/3sum-closest/

import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int fptr=0,bptr=0,mysum;
        
        int nearest = nums[0]+nums[1]+nums[2];
        
        for(int i=0; i<nums.length-1; i++)
        {
            fptr = i+1;
            bptr = nums.length-1;
            
            while(fptr<bptr)
            {
                mysum = nums[i]+nums[fptr]+nums[bptr];
                if(mysum<target)
                {
                    fptr++;
                }
                else if(mysum>target)
                {
                    bptr--;
                }
                else
                {
                    return target;
                }
                
                if(Math.abs(target-mysum)<Math.abs(target-nearest))
                {
                    nearest=mysum;
                }
            }
        }
        return nearest;
    }
}