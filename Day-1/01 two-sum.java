// https://leetcode.com/problems/two-sum/

import java.util.*;

class Solution 
{
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int num=0;
        int ans[] = new int[2];
        for(int i=0; i<nums.length; i++)
        {
            num = nums[i];
            if(map.containsKey(num))
            {
                ans[0]=map.get(num);
                ans[1]=i;
            }
            else
            {
                map.put(target-num, i);
            }
        }
        return ans;
    }
}